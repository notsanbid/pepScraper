import java.util.*;

public class Main {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static class levelPair {
    TreeNode par = null;
    int lb = -(int) 1e8;
    int rb = (int) 1e8;

    levelPair() {

    }

    levelPair(TreeNode par, int lb, int rb) {
      this.par = par;
      this.lb = lb;
      this.rb = rb;
    }
  }

  public static TreeNode constructBSTFromLevelOrder(int[] arr) {
    int idx = 0;
    LinkedList<levelPair> que = new LinkedList<>();
    que.add(new levelPair());
    TreeNode root = null;

    while (que.size() != 0 && idx < arr.length) {
      levelPair pair = que.removeFirst();

      if (arr[idx] < pair.lb || arr[idx] > pair.rb)
        continue;

      TreeNode node = new TreeNode(arr[idx++]);
      if (pair.par == null)
        root = node;
      else {
        if (node.val < pair.par.val)
          pair.par.left = node;
        else
          pair.par.right = node;
      }

      que.addLast(new levelPair(node, pair.lb, node.val));
      que.addLast(new levelPair(node, node.val, pair.rb));
    }

    return root;
  }

  // input_section=================================================

  public static void display(TreeNode node) {
    if (node == null)
      return;

    StringBuilder sb = new StringBuilder();
    sb.append((node.left != null ? node.left.val : "."));
    sb.append(" -> " + node.val + " <- ");
    sb.append((node.right != null ? node.right.val : "."));

    System.out.println(sb.toString());

    display(node.left);
    display(node.right);

  }

  public static void solve() {
    int n = scn.nextInt();
    int[] level = new int[n];
    for (int i = 0; i < n; i++)
      level[i] = scn.nextInt();

    TreeNode root = constructBSTFromLevelOrder(level);
    display(root);
  }

  public static void main(String[] args) {
    solve();
  }
}