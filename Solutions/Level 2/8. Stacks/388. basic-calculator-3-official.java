import java.io.*;
import java.util.*;

public class Main {
  static class Pair {
    Stack<Integer> stP;
    char sign;

    Pair(Stack<Integer> st, char s) {
      stP = st;
      sign = s;
    }
  }

  public static int calculate(String s) {
    Stack<Pair> stP = new Stack<>();
    Stack<Integer> st = new Stack<>();
    int n = s.length();
    char sign = '+';
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (Character.isDigit(ch)) {
        int val = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
          val = val * 10 + (s.charAt(i) - '0');
          i++;
        }
        i--;
        cal(st, sign, val);
      } else

        if (ch == '(') {
          stP.push(new Pair(st, sign));
          sign = '+';
          st = new Stack<>();
        } else if (ch == ')') {
          Pair p = stP.pop();
          int sum = 0;
          while (st.size() > 0)
            sum += st.pop();
          st = p.stP;
          sign = p.sign;
          cal(st, sign, sum);
        } else if (ch != ' ') {
          sign = ch;
        }
    }

    int sum = 0;
    while (st.size() > 0)
      sum += st.pop();

    return sum;
  }

  public static void cal(Stack<Integer> st, char sign, int val) {
    if (sign == '+') {
      st.push(val);
    } else if (sign == '-') {
      st.push(-val);
    } else if (sign == '*') {
      int a = st.pop();
      int ans = a * val;
      st.push(ans);
    } else if (sign == '/') {
      int a = st.pop();
      int ans = a / val;
      st.push(ans);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int result = calculate(read.readLine());
    System.out.println(result);

  }
}