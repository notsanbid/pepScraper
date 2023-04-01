import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String str = sc.next();

    int count = 0;
    for (char ch = 'z'; ch >= 'a'; ch--) {
      for (int i = 0; i < str.length(); i++) {
        if (str.length() == 1) {
          break;
        }
        if (str.charAt(i) != ch) {
          continue;
        }

        if (i == 0) {
          if (str.charAt(i + 1) == ch - 1) {
            count++;
            str = str.substring(0, i) + str.substring(i + 1);
            i = -1;
          }
        } else if (i == str.length() - 1) {
          if (str.charAt(i - 1) == ch - 1) {
            count++;
            str = str.substring(0, i) + str.substring(i + 1);
            i -= 2;
          }
        } else {
          if (str.charAt(i + 1) == ch - 1 || str.charAt(i - 1) == ch - 1) {
            count++;
            str = str.substring(0, i) + str.substring(i + 1);
            i -= 2;
          }
        }
      }
    }
    System.out.println(count);
  }
}