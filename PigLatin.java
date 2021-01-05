public class PigLatin {

  //given a single word of at least 1 character:
  //starts with a, e, i, o, u: add "hay" to end of word
  //all others: move first letter to the end, then add "ay" to end
  public static String pigLatinSimple(String s) {
    s = s.toLowerCase(); //to avoid issues with capitalization
    if (s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i' ||
        s.charAt(0) == 'o' || s.charAt(0) == 'u') {
      s += "hay";
      return s;
    }
    else {
      String temp = "";
      for (int i = 1; i < s.length(); i++) {
        temp += Character.toString(s.charAt(i));
      }
      temp += Character.toString(s.charAt(0)) + "ay";
      return temp;
    }
  }

  //given a single word of at least 1 character:
  //starts with any digraph: move first 2 letters to end, then add "ay"
  //rest, follow Simple's instructions^
  public static String pigLatin(String s) {
    s = s.toLowerCase();
    String[] digraphs = new String[]{"bl", "br", "ch", "ck", "cl",
      "cr", "dr", "fl", "fr", "gh", "gl", "gr", "ng", "ph", "pl",
      "pr", "qu", "sc", "sh", "sk", "sl", "sm", "sn", "sp", "st",
      "sw", "th", "tr", "tw", "wh", "wr"};
    if (s.length() < 2) return s;

    String temp = "";
    for (int i = 0; i < digraphs.length; i++) {
      if (s.substring(0,2).equals(digraphs[i])) { //if word starts with digraph
        for (int j = 2; j < s.length(); j++) {
          temp += Character.toString(s.charAt(j));
        }
        temp += s.substring(0,2) + "ay";
        return temp;
      }
    }
    return pigLatinSimple(s);
  }

  //given a single word of at least 1 character, can optionally have a punctuation mark afterwards
  //start with a NON letter: leave alone
  //punctuation is any non-letter, non-number symbol after the word
  //punctuation must remain after you convert to pig latin
  public static String pigLatinBest(String s) {
    s = s.toLowerCase();
    if (!Character.isLetter(s.charAt(0))) return s;

    //last character is a punctuation
    if (!Character.isLetter(s.charAt(s.length()-1)) && !Character.isDigit(s.charAt(s.length()-1))) {
      return pigLatin(s.substring(0,s.length()-1)) + Character.toString(s.charAt(s.length()-1));
    }
    else {
      return pigLatin(s);
    }
  }

  public static void main(String[] argsss) {
    String[] simple = new String[]{"aya", "mock", "pie", "david", "aaron", "OYOYO", "O"};
    for (int i = 0; i < simple.length; i++) {
      System.out.println(pigLatinSimple(simple[i]));
    }
    System.out.println();

    String[] normal = new String[]{"the", "check", "skee", "emu", "grade", "BLP", "th", "O", "fish"};
    for (int i = 0; i < normal.length; i++) {
      System.out.println(pigLatin(normal[i]));
    }
    System.out.println();

    String[] best = new String[]{"*emu", "4chan", "fish!", "fish", "the.", "cat!", "amazing?", "apple%"};
    for (int i = 0; i < best.length; i++) {
      System.out.println(pigLatinBest(best[i]));
    }
    System.out.println();

  }
}
