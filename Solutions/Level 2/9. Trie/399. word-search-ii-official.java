import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Main {

  public static class Node {
    Node []childs = new Node[26];
    String str;
    int count = 0;
  }

  public static void insert(Node curr, String s) {

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (curr.childs[ch - 'a'] == null) {
        curr.childs[ch - 'a'] = new Node();
        curr.count++;
      }
      curr = curr.childs[ch - 'a'];
    }
    curr.str = s;
  }

  public static ArrayList<String> findWords(char[][] board, String[] words) {

    Node root = new Node();
    for (String s : words) {
      insert(root, s);
    }
    boolean visited[][] = new boolean[board.length][board[0].length];
    ArrayList<String> ans = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, i, j, root, ans, visited);
      }
    }
    return ans;
  }

  public static void dfs(char[][]board, int i, int j, Node root, ArrayList<String> ans, boolean visited[][]) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] == true || root.count == 0)return;
    if (root.childs[board[i][j] - 'a'] == null)return;

    Node child = root.childs[board[i][j] - 'a'];
    if (child.str != null) {
      ans.add(child.str);
      child.str = null;
    }

    visited[i][j] = true;
    dfs(board, i + 1, j, child, ans, visited);
    dfs(board, i - 1, j, child, ans, visited);
    dfs(board, i, j + 1, child, ans, visited);
    dfs(board, i, j - 1, child, ans, visited);
    visited[i][j] = false;

    if (child.count == 0) {
      root.count--;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int m = Integer.parseInt(read.readLine());
    char[][]board = new char[n][];
    for (int i = 0; i < n; i++) {
      board[i] = read.readLine().trim().toCharArray();
    }
    int count = Integer.parseInt(read.readLine());
    String words[] = new String[count];
    for (int i = 0; i < count; i++) {
      words[i] = read.readLine();
    }

    ArrayList<String> result = findWords(board, words);
    Collections.sort(result);
    System.out.println(result);

  }
}