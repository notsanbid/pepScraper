import java.io.*;
import java.util.*;

public class Main {
  public static int[] nextGreaterElement(int[] nums, int[] query) {
    int ngr[] = nextGreaterRight(nums);

    HashMap<Integer, Integer> hm = new HashMap<>();

    // nums -> key  ngr -> value
    for (int i = 0; i < nums.length; i++) {
      hm.put(nums[i], ngr[i]);
    }

    int ans[] = new int[query.length];

    for (int i = 0; i < query.length; i++) {
      ans[i] = hm.get(query[i]);
    }

    return ans;
  }

  public static int[] nextGreaterRight(int[] nums) {
    Stack<Integer> st = new Stack<>();

    int ans[] = new int[nums.length];

    for (int i = nums.length - 1; i >= 0; i--) {
      while (st.size() > 0 && st.peek() < nums[i])st.pop();
      ans[i] = st.size() > 0 ? st.peek() : -1;
      st.push(nums[i]);
    }

    return ans;
  }

  public static int[] getArr(String s) {
    String nums[] = s.split(" ");
    int n = nums.length;
    int ar[] = new int[n];
    for (int i = 0; i < n; i++) {
      ar[i] = Integer.parseInt(nums[i]);
    }
    return ar;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int query[] = getArr(read.readLine());
    int nums[] = getArr(read.readLine());

    int ans[] = nextGreaterElement(nums, query);

    int n = ans.length;

    System.out.println(n);
    for (int e : ans) {
      System.out.println(e);
    }

  }
}