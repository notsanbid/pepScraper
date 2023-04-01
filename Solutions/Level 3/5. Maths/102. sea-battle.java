import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    String inp[] = read.readLine().split(" ");
    int n = Integer.parseInt(inp[0]);
    int a = Integer.parseInt(inp[1]);
    int b = Integer.parseInt(inp[2]);
    int k = Integer.parseInt(inp[3]);

    String miss = read.readLine();// 0

    // write your code here

    int count = 0;

    int l = 1;
    int r = 1;

    for (int i = 0; i < n; i++) {
      if (miss.charAt(i) == '0') {
        r = i + 1;
        if (r - l + 1 == b) {
          count++;
          l = r = i + 2;
        }
      } else {
        l = r = i + 2;
      }
    }
    StringBuilder sb = new StringBuilder();
    int shoot = count - a + 1; // 2
    sb.append(shoot + "\n");

    l = r = 1;
    for (int i = 0; i < n && shoot > 0; i++) {
      if (miss.charAt(i) == '0') {
        r = i + 1;
        if (r - l + 1 == b) {
          sb.append(r + " ");
          shoot--;
          l = r = i + 2;
        }
      } else {
        l = r = i + 2;
      }
    }
    System.out.println(sb);
  }
}