import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    displayArrReverse(arr, 0);
  }

  public static void displayArrReverse(int[] arr, int idx) {
    if (idx == arr.length) {
      return;
    }

    displayArrReverse(arr, idx + 1);
    System.out.println(arr[idx]);
  }

}