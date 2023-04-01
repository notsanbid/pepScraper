import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int testCase = sc.nextInt();

    while (testCase-- > 0) {
      long x1 = sc.nextLong();
      long y1 = sc.nextLong();

      long x2 = sc.nextLong();
      long y2 = sc.nextLong();

      System.out.println((x2 - x1) * (y2 - y1) + 1);
    }
  }
}