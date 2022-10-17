import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    int count = 0;

    Scanner numScanner = new Scanner(System.in);
      System.out.print("Enter number: ");
      int n = numScanner.nextInt();

      numScanner.close();

  int k = 60;
  double gleeTime1 = 0,
         gleeTime2 = 0;
  
      while(count <= k) {
          GenRanStr generate = new GenRanStr();
    
          double startTime1 = System.currentTimeMillis() /1.0;
  
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
    
          double stopTime1 = System.currentTimeMillis() /1.0;
          double elapsedTime1 = stopTime1 - startTime1;
          gleeTime1 += (elapsedTime1);
    
          System.out.println("\n");
    
          double startTime2 = System.currentTimeMillis()/1.0;
    
          Sort bubble = new Sort();
          String newText[] = randomText2.clone();
          String newText2[] = newText.clone();
          int index2[] = new int[newText.length];
    
          bubble.bubbleSort(newText2);
          index2 = bubble.getIndex(newText2, newText, newText.length);
    
          System.out.println("Bubble Sorted:");
          for (i = 0; i < newText2.length; i++) {
            System.out.println(index2[i] + ":" + newText2[i]);
          }
    
          indexList.indexArray(index2);
    
          double stopTime2 = System.currentTimeMillis()/1.0;
          double elapsedTime2 = stopTime2 - startTime2;
    
          //System.out.println(String.format("%.3f",elapsedTime2));
          System.out.println("Execution time of Bubble Sort: " + elapsedTime2);
          gleeTime2 += (elapsedTime2);   
          System.out.println("Execution time of Merge Sort: " + elapsedTime1);
          count++;
      }
  
    gleeTime1 /= (k*1.0);
    gleeTime2 /= (k*1.0);
    System.out.println(String.format("Merge Avg: %.3f", gleeTime1));
    System.out.println(String.format("Bubble Avg: %.3f", gleeTime2));
  }
}
/* FOR MEMORY USAGE
    int mb = 1024 * 1024; 
    // get Runtime instance
    Runtime instance = Runtime.getRuntime();
    System.out.println("***** Heap utilization statistics [MB] *****\n");
    // available memory
    System.out.println("Total Memory: " + instance.totalMemory() / mb);
    // free memory
    System.out.println("Free Memory: " + instance.freeMemory() / mb);
    // used memory
    System.out.println("Used Memory: "
            + (instance.totalMemory() - instance.freeMemory()) / mb);
    // Maximum available memory
    System.out.println("Max Memory: " + instance.maxMemory() / mb);
    */