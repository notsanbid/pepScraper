import java.io.*;
import java.util.*;

public class Main {

  public static void generateSelection(int cc, String ustr, int ssf, int ts, HashMap<Character, Integer> unique, String asf) {
    if (cc == ustr.length()) {
      if(ssf == ts){
        System.out.println(asf);
      }
      return;
    }

    char ch = ustr.charAt(cc);
    for(int i = unique.get(ch); i > 0; i--){
      char[] fasf = new char[i];
      Arrays.fill(fasf, ch);
      generateSelection(cc + 1, ustr, ssf + i, ts, unique, asf + new String(fasf));
    }
    generateSelection(cc + 1, ustr, ssf + 0, ts, unique, asf);
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

    generateSelection(0, ustr, 0, k, unique, "");
  }

}