import java.util.*;

// import jdk.internal.org.jline.terminal.impl.CursorSupport;
// import jdk.internal.org.jline.utils.Curses;

public class Main {

  static class node {
    HashMap<Character, node> child = new HashMap<>();
    node suffix_link;
    node output_link;
    int pattern_ind;

    node() {
      this.suffix_link = null;
      this.output_link = null;
      this.pattern_ind = -1;
    }
  }

  public static void build_trie(node root, String[] patterns) {
    for (int i = 0; i < patterns.length; i++) {
      node curr = root;
      for (int j = 0; j < patterns[i].length(); j++) {
        char c = patterns[i].charAt(j);
        if (curr.child.containsKey(c)) curr = curr.child.get(c);
        else {
          node nn = new node();
          curr.child.put(c, nn);
          curr = nn;
        }
      }
      curr.pattern_ind = i;
    }
  }

  public static void build_suffix_and_output_links(node root) {       // will use bfs to set links
    root.suffix_link = root;           //root represents empty string
    Queue<node> qu = new LinkedList<>();

    for (char rc : root.child.keySet()) {
      qu.add(root.child.get(rc));
      root.child.get(rc).suffix_link = root;  // root's children suffixlink will point to root only
    }

    while (qu.size() > 0) {
      node curState = qu.peek();
      qu.remove();

      for (char cc : curState.child.keySet()) {
        node cchild = curState.child.get(cc); // jiske liye suffix link dhund rhe hein
        node tmp = curState.suffix_link;    // parent suffix link
        while (!tmp.child.containsKey(cc) && tmp != root) tmp = tmp.suffix_link;    //finding lps

        if (tmp.child.containsKey(cc)) cchild.suffix_link = tmp.child.get(cc);
        else cchild.suffix_link = root;
        qu.add(cchild);
      }

      // setting output link
      if (curState.suffix_link.pattern_ind >= 0) curState.output_link = curState.suffix_link;
      else curState.output_link = curState.suffix_link.output_link;
    }
  }

  public static void search(node root, String text, ArrayList<ArrayList<Integer>> searchResults) {
    node parent = root;

    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (parent.child.containsKey(c)) {      // if parent has a child node in trie, travel it
        parent = parent.child.get(c);
        if (parent.pattern_ind >= 0) {
          searchResults.get(parent.pattern_ind).add(i); // reached a output node
        }

        node myOutput = parent.output_link;
        while (myOutput != null) {
          searchResults.get(myOutput.pattern_ind).add(i);
          myOutput = myOutput.output_link;
        }
      } else {
        while (parent != root && !parent.child.containsKey(c)) parent = parent.suffix_link;
        if (parent.child.containsKey(c)) i--;           // hold i and start traversing in next iteration
      }
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int k = scn.nextInt();
    String garbage = scn.nextLine();
    String[] patterns = new String[k];
    for (int i = 0; i < k; i++) patterns[i] = scn.nextLine();

    node root = new node();

    build_trie(root, patterns);
    build_suffix_and_output_links(root);

    // search occurances
    int n = scn.nextInt();
    garbage = scn.nextLine();
    for (int line = 1; line <= n; line++) {
      String txt = scn.nextLine();
      // System.out.println(txt);
      ArrayList<ArrayList<Integer>> searchResults = new ArrayList<ArrayList<Integer>>();
      for (int i = 0; i < k; i++) {
        ArrayList<Integer> na = new ArrayList<>();
        searchResults.add(na);
      }
      search(root, txt, searchResults);
      ArrayList<Integer> sp = new ArrayList<>();
      for (int i = 0; i < k; i++) {
        for (int ep : searchResults.get(i)) {
          sp.add(ep - patterns[i].length() + 1);
        }
      }
      Collections.sort(sp);
      if (sp.size() > 0) {
        System.out.println(line + " " + (sp.get(0) + 1));
        return;
      }
    }
    System.out.println("Passed");
    scn.close();
  }
}