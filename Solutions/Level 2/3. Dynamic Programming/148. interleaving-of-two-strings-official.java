import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    String s3 = scn.nextLine();
    System.out.println(solution2(s1, s2, s3));
  }

  public static boolean solution2(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }

    boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

    for (int i = 0 ; i < dp.length; i++) {
      for (int j = 0 ; j < dp[0].length; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = true;
        } else if (i == 0) {
          dp[i][j] = s2.charAt(j - 1) == s3.charAt(i + j - 1) ? dp[i][j - 1] : false;
        } else if (j == 0) {
          dp[i][j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) ? dp[i - 1][j] : false;
        } else {
          if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
            dp[i][j] = dp[i - 1][j];
          }
          if (!dp[i][j] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
            dp[i][j] = dp[i][j - 1];
          }
        }
      }
    }
    return dp[dp.length - 1][dp[0].length - 1];
  }

  public static boolean solution(String s1, String s2, String s3, int i, int j) {
    if (i == s1.length() && j == s2.length()) {
      return true;
    }


    if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
      if (solution(s1, s2, s3, i + 1, j)) {
        return true;
      }
    }

    if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
      if (solution(s1, s2, s3, i, j + 1)) {
        return true;
      }
    }
    return false;
  }

}