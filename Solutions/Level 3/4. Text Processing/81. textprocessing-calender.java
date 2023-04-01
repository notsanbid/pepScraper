import java.util.*;

public class calender {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    ArrayList<String> ar = new ArrayList<String>();
    PriorityQueue<String> all = new PriorityQueue<>();
    HashSet<String> done = new HashSet<>();
    HashMap<Integer, PriorityQueue<String>> hm = new HashMap<Integer, PriorityQueue<String>>();
    int sum = 0;

    for (int i = 0; i < n; i++) {
      PriorityQueue<String> emp = new PriorityQueue<>();
      String str = scn.next();
      sum += str.length();
      if (!hm.containsKey(str.length())) hm.put(str.length(), emp);
      hm.get(str.length()).add(str);
      // System.out.println(str.length()+" "+hm.get(str.length()).peek());
      all.add(str);
    }
    int ol = sum / (n / 2) + 1;
    // System.out.println(ol);
    String sep = scn.next();

    ArrayList<String> ans = new ArrayList<String>();
    while (all.size() > 0) {
      String top = all.remove();
      if (done.contains(top)) continue;
      done.add(top);
      // we have found the ideal first string;
      while (done.contains(hm.get(ol - top.length() - 1).peek())) {
        hm.get(ol - top.length() - 1).remove();
      }
      // System.out.print((ol - top.length() - 1)+" ");
      String topn = hm.get(ol - top.length() - 1).remove();
      done.add(topn);
      // System.out.print(topn+" ");

      String s1 = top + sep + topn;
      String s2 = topn + sep + top;

      if (s1.compareTo(s2) < 0) ans.add(s1);
      else ans.add(s2);
    }
    Collections.sort(ans);
    for (String sx : ans) System.out.println(sx);

  }
}