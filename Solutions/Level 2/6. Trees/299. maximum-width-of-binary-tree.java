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

  public static class pair {
    TreeNode node = null;
    long w = 0;

    pair(TreeNode node, long w) {
      this.node = node;
      this.w = w;
    }
  }

  public static int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    LinkedList<pair> que = new LinkedList<>();
    que.addLast(new pair(root, 0));
    long ans = 0;

    while (que.size() != 0) {
      int size = que.size();
      long fi = que.getFirst().w;
      long li = que.getFirst().w;

      while (size-- > 0) {
        pair p = que.removeFirst();

        TreeNode node = p.node;
        long w = p.w;
        li = w;

        if (node.left != null)
          que.addLast(new pair(node.left, 2 * w + 1));
        if (node.right != null)
          que.addLast(new pair(node.right, 2 * w + 2));

      }

      ans = Math.max(ans, li - fi + 1);
    }

    return (int) ans;
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

  public static int idx = 0;

  private static TreeNode deserialize(String[] arr) {
    if (idx >= arr.length || arr[idx].equals("null")) {
      idx++;
      return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
    node.left = deserialize(arr);
    node.right = deserialize(arr);

    return node;
  }

  public static TreeNode deserialize(String str) {
    String[] arr = str.split(" ");
    return deserialize(arr);
  }

  public static void solve() {
    String str = scn.nextLine();
    TreeNode root = deserialize(str);

    int ans = widthOfBinaryTree(root);
    System.out.println(ans);
  }

  public static void main(String[] args) {
    solve();
  }
}