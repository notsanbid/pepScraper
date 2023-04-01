import java.io.*;
import java.util.*;

public class Main {
  public static boolean isValid(String S) {
    Stack<Character> st = new Stack<>();

    char[]chars = S.toCharArray();

    for (char c : chars) {
      if (c == 'c') {
        if (st.size() >= 2 && st.pop() == 'b' && st.pop() == 'a') {
          //correct
        } else return false;
      } else st.push(c);
    }

    return st.size() == 0;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    boolean result = isValid(read.readLine());
    System.out.println(result);

  }
}