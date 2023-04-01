import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    String s = read.readLine();//s+s
    int n = s.length();

    int ans = 0;

    int an = 0;
    for (int i = 2 * n - 1; i >= 0; i--) {
      int a = i % n;
      int b = (i + 1) % n;

      if (s.charAt(a) != s.charAt(b)) {
        an++;
      } else {
        an = 1;
      }
      ans = Math.max(ans, an);
    }

    System.out.println(Math.min(ans, n));
  }
}