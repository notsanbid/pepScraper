import java.io.*;
import java.util.*;

public class Main {

  public static int validSubarrays(int[] nums) {
    Stack<Integer> st = new Stack<>();
    int count = 0;

    for (int num : nums) {
      while (st.size() > 0 && st.peek() > num) {
        st.pop();
      }
      st.push(num);
      count += st.size();
    }

    return count;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int nums[] = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(read.readLine());
    }

    int count = validSubarrays(nums);

    System.out.println(count);

  }
}