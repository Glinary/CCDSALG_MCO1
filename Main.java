import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    genRanStr generate = new genRanStr();

    Scanner numScanner = new Scanner(System.in);
    System.out.print("Enter number: ");
    int n = numScanner.nextInt();

    numScanner.close();

    String randomText[] = generate.getAlphabet(n);
    String randomText2[] = randomText.clone();

    Sort merge = new Sort();
    merge.mergeSort2(randomText, 0, randomText.length - 1);
    int index[] = new int[randomText.length];

    index = merge.getIndex(randomText,
        randomText2,
        randomText.length);

    System.out.println("");
    System.out.println("Merge Sorted:");
    int i;
    for (i = 0; i < randomText.length; i++) {
      System.out.println(index[i] + ":" + randomText[i]);
    }

    IndexArray indexList = new IndexArray();
    indexList.indexArray(index);

    System.out.println("\n");
    Sort bubble = new Sort();
    String newText[] = generate.getAlphabet(n);
    String newText2[] = newText.clone();
    int index2[] = new int[newText.length];

    bubble.bubbleSort(newText2);
    index2 = bubble.getIndex(newText2, newText, newText.length);

    System.out.println("");
    System.out.println("Bubble Sorted:");
    for (i = 0; i < newText2.length; i++) {
      System.out.println(index2[i] + ":" + newText2[i]);
    }

    indexList.indexArray(index2);
  }
}