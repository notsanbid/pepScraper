import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    int[] arr = { 1, 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000 };
    while (t-- > 0) {
      String[] st = br.readLine().split(" ");
      int a = Integer.parseInt(st[0]);
      int b = Integer.parseInt(st[1]);
      int c = Integer.parseInt(st[2]);

      long num1 = arr[c];
      long num2 = arr[c];

      while (num1 < arr[a]) {
        num1 = num1 * 2;
      }

      while (num2 < arr[b]) {
        num2 = num2 * 3;
      }

      System.out.println(num1 + " " + num2);
    }
  }
}