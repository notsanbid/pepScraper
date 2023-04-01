import java.io.*;
import java.util.*;

public class Main {

  public static class MinStack {
    Stack<Integer> data;
    int min;

    public MinStack() {
      data = new Stack<>();
    }

    int size() {
      return data.size();
    }

    void push(int val) {
      if (size() == 0) {
        min = val;
        data.push(val);
      } else if (val >= min) {
        data.push(val);
      } else {
        data.push(val + val - min); // encoding
        min = val;
      }
    }

    int pop() {
      if (size() == 0) {
        System.out.println("Stack underflow");
        return -1;
      } else {
        int val = data.pop();

        if (val >= min) {
          int v2r = val;
          return v2r;
        } else {
          int v2r = min;
          min = 2 * min - val;
          return v2r;
        }
      }
    }

    int top() {
      if (size() == 0) {
        System.out.println("Stack underflow");
        return -1;
      } else {
        int val = data.peek();

        if (val >= min) {
          return val;
        } else {
          return min;
        }
      }
    }

    int min() {
      if (size() == 0) {
        System.out.println("Stack underflow");
        return -1;
      } else {
        return min;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStack st = new MinStack();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("min")) {
        int val = st.min();
        if (val != -1) {
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}