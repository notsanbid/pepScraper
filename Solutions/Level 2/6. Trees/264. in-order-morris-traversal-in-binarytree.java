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

  public static TreeNode rightMostNode(TreeNode node, TreeNode curr) {
    while (node.right != null && node.right != curr) {
      node = node.right;
    }
    return node;
  }

  public static ArrayList<Integer> morrisInTraversal(TreeNode Treenode) {
    ArrayList<Integer> ans = new ArrayList<>();
    TreeNode curr = Treenode;
    while (curr != null) {
      TreeNode leftTreeNode = curr.left;
      if (leftTreeNode == null) { // left null
        ans.add(curr.val);
        curr = curr.right;
      } else {
        TreeNode rmost = rightMostNode(leftTreeNode, curr);
        if (rmost.right == null) { // thread Creation
          rmost.right = curr;
          curr = curr.left;
        } else { // thread Break
          rmost.right = null;
          ans.add(curr.val);
          curr = curr.right;
        }
      }
    }

    return ans;
  }

  // input_section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }
    TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
    Treenode.left = createTree(arr, IDX);
    Treenode.right = createTree(arr, IDX);

    return Treenode;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);

    ArrayList<Integer> ans = morrisInTraversal(root);
    for (Integer i : ans)
      System.out.print(i + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}