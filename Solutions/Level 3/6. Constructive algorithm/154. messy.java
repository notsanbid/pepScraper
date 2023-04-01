import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(read.readLine());

    PrintWriter out = new PrintWriter(System.out);
    while (t-- > 0) {
      String inp[] = read.readLine().split(" ");
      int n = Integer.parseInt(inp[0]);
      int k = Integer.parseInt(inp[1]);

      char ch[] = read.readLine().toCharArray();

      ArrayList<int[]>list = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        int j = i;
        if (i % 2 == 0) {
          while (ch[j] != '(')j++;
        } else {
          while (ch[j] != ')')j++;
        }

        if (i != j) {
          list.add(new int[] {i, j});
          char c = ch[i];
          ch[i] = ch[j];
          ch[j] = c;
        }
      }

      int ans = n / 2;
      int i = 1;
      while (ans != k) {
        list.add(new int[] {i, i + 1});
        i += 2;
        ans--;
      }

      out.println(list.size());
      for (int op[] : list) {
        out.println((op[0] + 1) + " " + (op[1] + 1));
      }
    }

    out.close();
  }
}