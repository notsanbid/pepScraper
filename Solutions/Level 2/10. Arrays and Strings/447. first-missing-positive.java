import java.util.*;

public class Main {


  //~~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~~~
  public static int firstMissingPositive(int[] arr) {
    int n = arr.length;
    boolean one = false;
    for (int i = 0; i < n; i++) {
      if (arr[i] == 1)
        one = true;

      if (0 >= arr[i] || arr[i] > n) {
        arr[i] = 1;
      }
    }

    if (one == false) return 1;

    for (int i = 0; i < n; i++) {
      int indx = Math.abs(arr[i]);
      arr[indx - 1] = -Math.abs(arr[indx - 1]);
    }

    for (int i = 0; i < n; i++) {
      if (arr[i] > 0) {
        return i + 1;
      }
    }
    return n + 1;
  }

  //~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int res = firstMissingPositive(arr);
    System.out.println(res);
  }
}