import java.util.Scanner;

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

  public static class maxNodeToNodePair {
    int NTN_sum = -(int) 1e9; // Node to Node sum
    int NTR_sum = 0; // Node to root sum

    maxNodeToNodePair(int NTN_sum, int NTR_sum) {
      this.NTN_sum = NTN_sum;
      this.NTR_sum = NTR_sum;
    }

    maxNodeToNodePair() {

    }
  }

  public static int maxValue(int... arr) {
    int max = arr[0];
    for (int ele : arr) {
      max = Math.max(max, ele);
    }

    return max;
  }

  // {nodeToNode, rootToNode}
  public static maxNodeToNodePair maxPathSum2_(TreeNode node) {
    if (node == null)
      return new maxNodeToNodePair();

    maxNodeToNodePair lpair = maxPathSum2_(node.left);
    maxNodeToNodePair rpair = maxPathSum2_(node.right);

    maxNodeToNodePair myAns = new maxNodeToNodePair();

    myAns.NTN_sum = maxValue(lpair.NTN_sum, rpair.NTN_sum, node.val, lpair.NTR_sum + node.val,
                             rpair.NTR_sum + node.val, lpair.NTR_sum + node.val + rpair.NTR_sum);
    myAns.NTR_sum = maxValue(node.val, lpair.NTR_sum + node.val, rpair.NTR_sum + node.val);

    return myAns;
  }

  public static int maxPathSum(TreeNode root) {
    if (root == null)
      return 0;

    return maxPathSum2_(root).NTN_sum;
  }

  // input_Section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }

    TreeNode node = new TreeNode(arr[IDX[0]++]);
    node.left = createTree(arr, IDX);
    node.right = createTree(arr, IDX);

    return node;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    System.out.println(maxPathSum(root));
  }

  public static void main(String[] args) {
    solve();
  }
}