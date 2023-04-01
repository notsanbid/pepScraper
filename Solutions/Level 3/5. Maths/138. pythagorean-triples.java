import java.util.*;

public class pytha {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    long n = scn.nextInt();
    if (n == 1 || n == 2) {
      System.out.println(-1);
      return ;
    }
    if (n % 2 > 0) {
      long a = (n * n / 2);
      long b = (n * n / 2) + 1;
      if ((a * a) + n * n == b * b) System.out.println(a + " " + b);
      else System.out.println(-1);
    } else {
      long a = (n * n / 4) - 1;
      long b = (n * n / 4) + 1;
      if ((a * a) + n * n == b * b) System.out.println(a + " " + b);
      else System.out.println(-1);
    }
  }
}