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

  public static void burningTreeNode(TreeNode root, int time, TreeNode blockNode, ArrayList<ArrayList<Integer>> ans) {
    if (root == null || root == blockNode)
      return;
    if (time == ans.size()) // if(time == ans.size()) ans.push_back({});
      ans.add(new ArrayList<>());
    ans.get(time).add(root.val);

    burningTreeNode(root.left, time + 1, blockNode, ans);
    burningTreeNode(root.right, time + 1, blockNode, ans);

  }

  public static int burningTree(TreeNode root, int fireNode, ArrayList<ArrayList<Integer>> ans) {
    if (root == null)
      return -1;
    if (root.val == fireNode) {
      burningTreeNode(root, 0, null, ans);
      return 1;
    }

    int lt = burningTree(root.left, fireNode, ans);
    if (lt != -1) {
      burningTreeNode(root, lt, root.left, ans);
      return lt + 1;
    }

    int rt = burningTree(root.right, fireNode, ans);
    if (rt != -1) {
      burningTreeNode(root, rt, root.right, ans);
      return rt + 1;
    }

    return -1;
  }

  public static ArrayList<ArrayList<Integer>> burningTree(TreeNode root, int data) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    burningTree(root, data, ans);
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
    int fireNode = scn.nextInt();

    ArrayList<ArrayList<Integer>> ans = burningTree(root, fireNode);
    if (ans.size() == 0)
      System.out.println();
    for (ArrayList<Integer> ar : ans) {
      for (Integer ele : ar)
        System.out.print(ele + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}