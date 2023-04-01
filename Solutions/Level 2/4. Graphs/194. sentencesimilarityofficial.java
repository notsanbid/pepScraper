import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] sentence1 = br.readLine().split(" ");
    String[] sentence2 = br.readLine().split(" ");

    int m = Integer.parseInt(br.readLine());

    String[][] pairs = new String[m][2];
    for (int i = 0; i < m; i++) {
      pairs[i] = br.readLine().split(" ");
    }

    System.out.println(areSentencesSimilarTwo(sentence1, sentence2, pairs));

  }

  static HashMap<String, String> parent;
  static HashMap<String, Integer> rank;

  public static boolean areSentencesSimilarTwo(String[] Sentence1, String[] Sentence2, String[][] pairs) {
    rank = new HashMap<>();
    parent = new HashMap<>();
    if (Sentence1.length != Sentence2.length) {
      return false;
    }
    parent = new HashMap<>();
    for (String[] p : pairs) {
      union(p[0], p[1]);
    }

    for (int i = 0; i < Sentence1.length; i++) {
      if (!Sentence1[i].equals(Sentence2[i]) && !find(Sentence1[i]).equals(find(Sentence2[i]))) {
        return false;
      }
    }
    return true;
  }

  public static String find(String s) {
    if (!parent.containsKey(s)) {
      parent.put(s, s);
      rank.put(s, 1);
    }

    if (s.equals(parent.get(s))) {
      return s;
    }
    String temp = find(parent.get(s));
    parent.put(s, temp);
    return temp;
  }

  public static void union(String x, String y) {
    String lx = find(x);
    String ly = find(y);

    if (lx.equals(ly) == false) {
      if (rank.get(lx) > rank.get(ly)) {
        parent.put(ly, lx);
      } else if (rank.get(lx) < rank.get(ly)) {
        parent.put(lx, ly);
      } else {
        parent.put(lx, ly);
        rank.put(ly, rank.get(ly) + 1);
      }
    }
  }

}