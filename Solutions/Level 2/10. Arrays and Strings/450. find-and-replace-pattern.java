import java.util.*;

public class Main {

  // ~~~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~
  public static boolean isMatching(String str, String pat) {
    HashMap<Character, Character> map = new HashMap<>();
    HashSet<Character> set = new HashSet<>();

    for (int i = 0; i < str.length(); i++) {
      char pch = pat.charAt(i); // pattern character
      char sch = str.charAt(i); // string character
      if (map.containsKey(pch)) {
        if (map.get(pch) != sch)
          return false;
      } else {
        if (set.contains(sch)) return false;
        map.put(pch, sch);
        set.add(sch);
      }
    }
    return true;
  }

  public static List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> res = new ArrayList<>();
    for (String str : words) {
      if (isMatching(str, pattern)) {
        res.add(str);
      }
    }
    return res;
  }

  // ~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String pattern = scn.nextLine();
    int n = scn.nextInt();
    scn.nextLine(); // to consume enter after number
    String[] words = new String[n];
    for (int i = 0; i < n; i++) {
      words[i] = scn.nextLine();
    }
    List<String> res = findAndReplacePattern(words, pattern);
    if (res.size() == 0) {
      System.out.println("Empty");
      return;
    }
    Collections.sort(res);
    for (String str : res) {
      System.out.print(str + " ");
    }
    System.out.println();
  }
}