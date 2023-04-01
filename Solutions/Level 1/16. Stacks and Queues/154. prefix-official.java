import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> vstack = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> postfix = new Stack<>();

    for (int i = exp.length() - 1; i >= 0; i--) {
      char ch = exp.charAt(i);

      if (ch == '-' || ch == '+' || ch == '*' || ch == '/') {
        int v1 = vstack.pop();
        int v2 = vstack.pop();
        int val = operation(v1, v2, ch);
        vstack.push(val);

        String inv1 = infix.pop();
        String inv2 = infix.pop();
        String inv = "(" + inv1 + ch + inv2 + ")";
        infix.push(inv);

        String postv1 = postfix.pop();
        String postv2 = postfix.pop();
        String postv = postv1 + postv2 + ch;
        postfix.push(postv);
      } else {
        vstack.push(ch - '0');
        infix.push(ch + "");
        postfix.push(ch + "");
      }
    }

    System.out.println(vstack.pop());
    System.out.println(infix.pop());
    System.out.println(postfix.pop());
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