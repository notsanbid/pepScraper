import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> vstack = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> prefix = new Stack<>();

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);

      if (ch == '-' || ch == '+' || ch == '*' || ch == '/') {
        int v2 = vstack.pop();
        int v1 = vstack.pop();
        int val = operation(v1, v2, ch);
        vstack.push(val);

        String inv2 = infix.pop();
        String inv1 = infix.pop();
        String inv = "(" + inv1 + ch + inv2 + ")";
        infix.push(inv);

        String prev2 = prefix.pop();
        String prev1 = prefix.pop();
        String prev = ch + prev1 + prev2;
        prefix.push(prev);
      } else {
        vstack.push(ch - '0');
        infix.push(ch + "");
        prefix.push(ch + "");
      }
    }

    System.out.println(vstack.pop());
    System.out.println(infix.pop());
    System.out.println(prefix.pop());
  }

  public static int operation(int v1, int v2, char op) {
    if (op == '+') {
      return v1 + v2;
    } else if (op == '-') {
      return v1 - v2;
    } else if (op == '*') {
      return v1 * v2;
    } else if (op == '/') {
      return v1 / v2;
    } else {
      return 0;
    }
  }
}