import java.util.*;
public class MakeStars {
  public static void main(String[] args) {
    Scanner n = new Scanner( System.in );
    //we are using the terminal input (System.in) as the string we read from
    while (n.hasNextLine()) {
      Scanner s = new Scanner(n.nextLine()); //takes the line
      while (s.hasNext()) { //takes every word-by-word of that line
        String data = s.next();
        for (int i = 0; i < data.length(); i++) {
          System.out.print("*");
        }
        System.out.print(" ");
      }
      System.out.println();
    }
  }
}
