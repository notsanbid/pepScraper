import java.io.*;
import java.util.*;

public class Main {
  public static int trap(int[] height) {

    Stack<Integer> st = new Stack<>();

    int ans = 0;
    for (int i = 0, n = height.length; i < n; i++) {
      while (st.size() > 0 && height[st.peek()] <= height[i]) {
        int rm = i;
        int curr = height[st.pop()];
        if (st.size() == 0)break;
        int lm = st.peek();

        int width = rm - lm - 1;
        ans += (Math.min(height[rm], height[lm]) - curr) * width;
      }

      st.push(i);
    }

    return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)arr[i] = Integer.parseInt(read.readLine());
    int result = trap(arr);
    System.out.println(result);

  }
}