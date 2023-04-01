import java.util.*;
import java.io.*;

public class Main {

  public static int guessNumber(int n) {
    //write your code here
    int lo = 1;
    int hi = n;

    while (lo <= hi) {
      int num = lo + (hi - lo) / 2;

      if (guess(num) == 0) {
        return num;
      }
      else if (guess(num) == -1) {
        hi = num - 1;
      }
      else {
        lo = num + 1;
      }
    }

    return -1;
  }

  static int pn = 0; //picked number
  public static int guess(int val) {
    if (val == pn) {
      return 0;
    }
    else if (val < pn) {
      return 1;
    }
    else {
      return -1;
    }
  }

  public static void solve(int n, int pick) {
    pn = pick;
    System.out.println(guessNumber(n));
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int pick = scn.nextInt();

    solve(n, pick);
  }
}