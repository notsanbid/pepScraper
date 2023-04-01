import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    boolean[] row = new boolean[n];
    boolean[] col = new boolean[n];

    long empty_row = n;
    long empty_col = n;

    while (m-- > 0) {
      int i = sc.nextInt();
      int j = sc.nextInt();

      if (row[i - 1] == false) {
        row[i - 1] = true;
        empty_row--;
      }

      if (col[j - 1] == false) {
        col[j - 1] = true;
        empty_col--;
      }

      System.out.println(empty_row * empty_col);
    }
  }
}