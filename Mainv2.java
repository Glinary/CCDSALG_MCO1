public class Mainv2 {

  public static void main (String[] args) {
    genRanStr generate = new genRanStr();
    String randomText[] = generate.getAlphabet(10);
    String randomText2[] = randomText.clone();

    MergeSort merge = new MergeSort();
    merge.MergeSort2(randomText, 0, randomText.length - 1);
    int index[] = new int[10];
  
    index = merge.getIndex(randomText, 
                           randomText2, 
                           randomText.length);

    System.out.println("");
    System.out.println("Sorted:");
    int i;
    for (i = 0; i < randomText.length; i++) {
      System.out.println(index[i] + ":" + randomText[i]);
    }

    indexArray indexList = new indexArray();
    indexList.indexArray(index);

      //pero tama na ung print dba, ung pagkuha nalang
  }
}