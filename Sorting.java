public class Sorting {

  public static String generateRandomString(int n) {
    char alphabet[] = {'a', 'c', 'g','t'};
 
    String randomString = ""; //initialize as empty string
    for (int i = 0; i < n; i++)
        randomString = randomString + alphabet[(int) (Math.random() * 100 % 4)]; //concatenate/append idk the word, a character from alphabet array to randomString
     
    return randomString; //return the generated string
}

  public static String[] createSuffix(String text) {
    String [] suffix = new String[text.length()]; //initialize suffix string

    for(int i = 0; i < text.length(); i++) { 
      suffix[i] = text.substring(i,text.length()); //deletes the first character and adds the remaining to suffix array
    }

    return suffix; //returns the suffix array
  } 
  
  //Group 1 sorting algorithms
  public static void bubbleSort(String[] text) { //best case O(n), worst O(n^2)
 
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
  }

  public static void insertionSort(String[] text) { //best case O(n), worst O(n^2)
    for(int i = 0; i < text.length; i++) {
      String key = text[i];
      int j = i - 1;

      while(j >= 0 && text[j].compareTo(key) > 0) {
        text[j + 1] = text[j];
        j = j - 1;
      }
      
      text[j+1] = key;
    }
  }

  public static void selectionSort(String[] text) { //best and worst O(n^2)

    for(int i = 0; i < text.length - 1; i++) {
      int min = i;
      
      for(int j = i + 1; j < text.length; j++){
        if(text[j].compareTo(text[min]) < 0)
          min = j;
      }

      //swapping
      if(i != min) {
        String temp = text[i];
          text[i] = text[min];
          text[min] = temp;
      }
    }
  }
  
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
        if(text[i].equals(text2[j]))
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
    String textT = generateRandomString(10);
    String suffix[] = createSuffix(textT);
    String sortedSuffix[] = suffix.clone();
    int indexArray[] = new int[suffix.length];
    
    System.out.println("Randomly generated string: ");
    System.out.println(textT);
    System.out.println("\nSuffixes: ");
    printArray(suffix);
    
    System.out.println("\nSelection Sorting:");
    selectionSort(sortedSuffix);

    indexArray = index(suffix, sortedSuffix);
    printIntArray(sortedSuffix,indexArray);

    System.out.println("\nThe suffix array: ");
    printSuffix(indexArray);
  }
}



