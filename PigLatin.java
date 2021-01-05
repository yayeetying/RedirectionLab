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

  // //given a single word of at least 1 character:
  // //starts with any digraph: move first 2 letters to end, then add "ay"
  // //rest, follow Simple's instructions^
  // public static String pigLatin(String s) {
  //   String[] digraphs = new String[]{"bl", "br", "ch", "ck", "cl",
  //     "cr", "dr", "fl", "fr", "gh", "gl", "gr", "ng", "ph", "pl",
  //     "pr", "qu", "sc", "sh", "sk", "sl", "sm", "sn", "sp", "st",
  //     "sw", "th", "tr", "tw", "wh", "wr"}
  //   if (s.length() < 2) return s;
  //
  //   String temp = "";
  //   for (int i = 0; i < digraphs.length; i++) {
  //     if (s.substring(0,2).equals(digraphs[i])) {
  //       for (int i = 2; i < s.length(); i++) {
  //         temp += Character.toString()
  //       }
  //       //return
  //     }
  //   }
  // }

  public static void main(String[] argsss) {
    String[] simple = new String[]{"aya", "mock", "pie", "david", "aaron"};
    for (int i = 0; i < simple.length; i++) {
      System.out.println(pigLatinSimple(simple[i]));
    }

  }
}
