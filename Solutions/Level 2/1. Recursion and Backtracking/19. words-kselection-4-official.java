import java.io.*;
import java.util.*;

public class Main {

  public static void generateSelection(int cs, int ts, String ustr, HashMap<Character, Integer> unique, int ls, String asf) {
    if (cs > ts) {
      System.out.println(asf);
      return;
    }

    for (int i = ls; i < ustr.length(); i++) {
      char ch = ustr.charAt(i);

      if (unique.get(ch) > 0) {
        unique.put(ch, unique.get(ch) - 1);
        generateSelection(cs + 1, ts, ustr, unique, i, asf + ch);
        unique.put(ch, unique.get(ch) + 1);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        ustr += ch;
      } else {
        unique.put(ch, unique.get(ch) + 1);
      }
    }

    generateSelection(1, k, ustr, unique, 0, "");
  }

}