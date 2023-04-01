import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    String t = sc.next();

    String str = "";
    for (int idx = s.length() - 1; idx >= 0; idx--) {
      if (s.charAt(idx) == 'z') {
        str += 'a';
      } else {
        break;
      }
    }
    int i = s.length() - str.length() - 1;
    String ans = s.substring(0, i) + (char)(s.charAt(i) + 1) + str;

    if (ans.equals(t)) {
      System.out.println("No such string");
    } else {
      System.out.println(ans);
    }
  }
}