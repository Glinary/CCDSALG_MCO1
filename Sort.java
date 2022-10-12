public class Sort {

  public void merge(String[] text, int p, int q, int r) {
    int n1 = q - p + 1;
    int n2 = r - q;

    String L[] = new String[n1];
    String R[] = new String[n2];

    int i, j;
    for (i = 0; i < n1; i++) 
      L[i] = text[p + i];

    for (j = 0; j < n2; j++)
      R[j] = text[q + 1 + j];
  
    //para mareset yung values here;
    i = 0; 
    j = 0; 
    int k = p;

    while (i < n1 && j < n2) {
      //if (L[i] <= R[j]]) {
      if (L[i].compareTo(R[j]) < 0) { 
        text[k] = L[i];
        i++;
      } else {
        text[k] = R[j];
        j++;        
      }
      k++;
    }

    while (i < n1) {
      text[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      text[k] = R[j];
      j++;
      k++;
    }
      
  }

  public void mergeSort2(String[] text, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;

      mergeSort2(text, left, mid);
      mergeSort2(text, mid + 1, right);

      merge(text, left, mid, right);
    }
    
  }

  public int[] getIndex(String[] text1,
                        String[] text2, 
                        int length) { 

    int indexArray[] = new int[length];
    int i, j;

    for (i = 0; i < length; i++) { 
      for (j = 0; j < length; j++) {
        if (text2[i].equals(text1[j]))
          indexArray[j] = i;
      }
    }
    
    return indexArray;
  }

  public void bubbleSort(String[] text) {
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
}
