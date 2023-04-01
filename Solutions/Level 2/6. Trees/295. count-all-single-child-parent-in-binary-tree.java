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

  public static int countExactlyOneChild(TreeNode node) {
    if (node == null || (node.left == null && node.right == null))
      return 0;

    int left = countExactlyOneChild(node.left);
    int right = countExactlyOneChild(node.right);
    int sum = left + right;
    if (node.left == null || node.right == null)
      sum += 1;
    return sum;
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

    System.out.println(countExactlyOneChild(root));
  }

  public static void main(String[] args) {
    solve();
  }
}