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

  public static int totalTime = 0;

  public static void burningTreeNode(TreeNode root, int time, TreeNode blockNode) {
    if (root == null || root == blockNode)
      return;
    totalTime = Math.max(totalTime, time);
    burningTreeNode(root.left, time + 1, blockNode);
    burningTreeNode(root.right, time + 1, blockNode);

  }

  public static int burningTree_(TreeNode root, int fireNode) {
    if (root == null)
      return -1;
    if (root.val == fireNode) {
      burningTreeNode(root, 0, null);
      return 1;
    }

    int lt = burningTree_(root.left, fireNode);
    if (lt != -1) {
      burningTreeNode(root, lt, root.left);
      return lt + 1;
    }

    int rt = burningTree_(root.right, fireNode);
    if (rt != -1) {
      burningTreeNode(root, rt, root.right);
      return rt + 1;
    }

    return -1;
  }

  public static int burningTree(TreeNode root, int fireNode) {
    totalTime = 0;
    burningTree_(root, fireNode);
    return totalTime;
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
    int fireNode = scn.nextInt();

    int ans = burningTree(root, fireNode);
    System.out.println(ans);

  }

  public static void main(String[] args) {
    solve();
  }
}