import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int testCase = sc.nextInt();

    while (testCase-- > 0) {
      long n = sc.nextInt();
      String a = sc.next();

      HashMap<Long, Long> map = new HashMap<>();
      map.put(0L, 1L);
      long sum = 0;
      long res = 0;

      for (int i = 0; i < n; i++) {
        sum += a.charAt(i) - '0';
        long k = sum - (i + 1);
        if (map.containsKey(k) == false) {
          map.put(k, 1L);
        } else {
          map.put(k, map.get(k) + 1);
        }
      }

      for (long key : map.keySet()) {
        long x = map.get(key);
        res += x * (x - 1) / 2;
      }
      System.out.println(res);
    }
  }
}