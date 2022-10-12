public class genRanStr {
  private char[] alphabet;

  public genRanStr() {
    alphabet = new char[4];
    alphabet[0] = 'a';
    alphabet[1] = 'c';
    alphabet[2] = 'g';
    alphabet[3] = 't';
  }

  public String[] getAlphabet(int n) {

    String res = "";
    int i;

    for (i = 0; i < n; i++)
      res = res + alphabet[(int) (Math.random() * 100 % 4)]; // concatenate a random char from array alphabet with string res
  
    String[] suffix = new String[res.length()];

    for (i = 0; i < res.length(); i++)
      suffix[i] = res.substring(i, res.length());

    System.out.println("Generated: " + res);
    for (i = 0; i < suffix.length; i++) {

      System.out.println(i + ":" + suffix[i]);
    }

    return suffix;
  }

}