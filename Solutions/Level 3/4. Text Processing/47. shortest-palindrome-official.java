import java.io.*;
import java.util.*;

public class Main {

  public static String solution(String s) {
    String temp = s + "#" + new StringBuilder(s).reverse().toString();
    int[] table = getTable(temp);

    return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
  }

  public static int[] getTable(String s) {
    int[] table = new int[s.length()];

    int index = 0;
    for (int i = 1; i < s.length();) {
      if (s.charAt(index) == s.charAt(i)) {
        table[i] = ++index;
        i++;
      } else {
        if (index > 0) {
          index = table[index - 1];
        } else {
          index = 0;
          i++;
        }
      }
    }
    return table;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    System.out.println(solution(str));
  }

}