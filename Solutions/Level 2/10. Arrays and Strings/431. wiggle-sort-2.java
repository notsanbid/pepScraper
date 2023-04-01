import java.util.*;

public class Main {

  // ~~~~~~~~~~~~~User's Section~~~~~~~~~~~~
  public static void wiggleSort2(int[] nums) {
    Arrays.sort(nums);
    int[] res = new int[nums.length];
    int j = nums.length - 1;
    int index = 1;
    while (index < nums.length) {
      res[index] = nums[j--];
      index += 2;
    }
    index = 0;
    while (index < nums.length) {
      res[index] = nums[j--];
      index += 2;
    }
    for (int i = 0; i < res.length; i++) {
      nums[i] = res[i];
    }
  }

  // ~~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    wiggleSort2(arr);
    /*
    -if index is even then smaller than next,
    -if index is odd then greater than next element,
    -to check any correct order, we will not print array, we will check inequality
    -if print false, that means wrong answer, if true than correct answer.
    */
    for (int i = 0; i < n - 1; i++) {
      if (i % 2 == 0 && arr[i] >= arr[i + 1]) {
        System.out.println(false);
        return;
      } else if (i % 2 == 1 && arr[i] <= arr[i + 1]) {
        System.out.println(false);
        return;
      }
    }
    System.out.println(true);
  }
}