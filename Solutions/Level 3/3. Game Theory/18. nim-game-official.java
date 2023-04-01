import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] st = br.readLine().split(" ");

    long xor = 0;
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st[i]);
      xor = xor ^ arr[i];
    }

    if (xor != 0) {
      System.out.println("ALICE");
    } else {
      System.out.println("BOB");
    }

  }
}