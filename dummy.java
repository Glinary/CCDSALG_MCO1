public class dummy {

  public static String generateRandomString(int n) {
    char alphabet[] = {'a', 'c', 'g','t'};
 
    String res = "";
    for (int i = 0; i < n; i++)
        res = res + alphabet[(int) (Math.random() * 100 % 4)];
     
    return res;
}

  public static String[] createSuffix(String text) {
    String [] suffix = new String[text.length()];

    for(int i = 0; i < text.length(); i++) {
      suffix[i] = text.substring(i,text.length());
    }

    return suffix;
  } 


  /*public static void bubbleSort(String[] text) {
      for(int i = 0; i <= text.length-1; i++) {
        for(int j = text.length-1; j >= i+1; j--) {
          //compare the adjacent strings
          if(text[j].compareTo(text[j-1]) < 0) {
            //swapping
            String temp = text[j];
            text[j] = text[j-1];
            text[j-1] = temp;
         }
        }
      }
    }*/
  
  public static void bubbleSort(String[] text) {
    for (int i = 0; i < text.length - 1; i++) {
      for (int j = 0; j < text.length - i - 1; j++) {
        // compare the adjacent strings
        if (text[j].compareTo(text[j + 1]) > 0) {
          String temp = text[j + 1];
          text[j + 1] = text[j];
          text[j] = temp;
        }
      }
    }
  }
  public static void insertionSort(String[] text) {
    for(int i = 1; i < text.length; i++) {
      String key = text[i];
      int j = i - 1;

      while(j >= 0 && text[j].compareTo(key) > 0) {
        text[j + 1] = text[j];
        j = j - 1;
      }
      
      text[j+1] = key;
    }
  }
  /*//Group 1 sorting algorithms
  public static void bubbleSort(String[] text) {
 
    for(int i = 0; i < text.length; i++) {
      for(int j = i + 1; j < text.length; j++) {
        //compare the adjacent strings
        if(text[j].compareTo(text[i]) < 0) {
          String temp = text[i];
          text[i] = text[j];
          text[j] = temp;
       }
      }
    }
  }*/
  
  public static void printArray(String[] text) {
    for(int i = 0; i < text.length; i++){
      System.out.print(i + " ");
      System.out.println(text[i]);
    }
  }

  public static void printIntArray(String[] text, int[] index) {
    for(int i = 0; i < text.length; i++){
      System.out.print(index[i] + " ");
      System.out.println(text[i]);
    }
  }
  
  public static int[] index(String[] text, String[] text2){
    int[] indexArray = new int[text2.length];

    for(int i = 0; i < text.length; i++) {
      for(int j = 0; j < text2.length; j++)
        if(text[i] == text2[j])
          indexArray[j] = i;
    }
    return indexArray;
  }

  public static void printSuffix(int[] index){
    for(int i = 0; i< index.length; i++){
      System.out.print(index[i] + " ");
    }
  }
  public static void main(String[] args) {
    //String textT = generateRandomString(10);
    String textT = "tcagtgtaga";
    String suffix[] = createSuffix(textT);
    String sortedSuffix[] = suffix.clone();
    int indexArray[] = new int[suffix.length];
   
    System.out.println("Randomly generated string: ");
    System.out.println(textT);
    System.out.println("\nSuffixes: ");
    printArray(suffix);
    
    System.out.println("\nBubble Sorting:");
    insertionSort(sortedSuffix);

    //Sort merge = new Sort();
    //merge.mergeSort2(sortedSuffix, 0, sortedSuffix.length - 1);

    //System.out.println("\nMerge Sorting:");

    indexArray = index(suffix, sortedSuffix);
    printIntArray(sortedSuffix,indexArray);

    System.out.println("\nThe suffix array: ");
    printSuffix(indexArray);
  }
}