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

    int[] rb = new int[arr.length]; // nse on the right
    Stack<Integer> st = new Stack<>();

    st.push(arr.length - 1);
    rb[arr.length - 1] = arr.length;
    for (int i = arr.length - 2; i >= 0; i--) {
      while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
        st.pop();
      }

      if (st.size() == 0) {
        rb[i] = arr.length;
      } else {
        rb[i] = st.peek();
      }

      st.push(i);
    }

    int[] lb = new int[arr.length]; // nse on the left
    st = new Stack<>();

    st.push(0);
    lb[0] = -1;
    for (int i = 1; i < arr.length; i++) {
      while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
        st.pop();
      }

      if (st.size() == 0) {
        lb[i] = -1;
      } else {
        lb[i] = st.peek();
      }

      st.push(i);
    }

    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      int width = rb[i] - lb[i] - 1;
      int area = width * arr[i];
      if (area > max) {
        max = area;
      }
    }

    System.out.println(max);
  }
}