import java.util.Scanner;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int testCase = sc.nextInt();

    while (testCase-- > 0) {
      int n = sc.nextInt();
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }

      HashMap<Integer, Integer> map = new HashMap<>();
      boolean flag = true;

      for (int i = 0; i < n; i++) {
        int room = (arr[i] + i) % n;

        if (room < 0) {
          room += n;
        }

        if (map.containsKey(room)) {
          flag = false;
          break;
        } else {
          map.put(room, 1);
        }
      }

      System.out.println(flag ? "YES" : "NO");
    }
  }
}