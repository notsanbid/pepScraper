import java.io.*;
import java.util.*;

public class Main {
  public static int sortingCost(int arr[]) {
    // code here
    HashMap<Integer, Integer> map = new HashMap<>();

    int maxss = 1;
    for (int n : arr) {
      if (map.containsKey(n - 1)) {
        int fre = map.get(n - 1);
        map.put(n, fre + 1);

        maxss = Math.max(maxss, fre + 1);
      } else {
        map.put(n, 1);
      }
    }

    return arr.length - maxss;
  }

  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] arr = new int[n];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(sortingCost(arr));
  }
}