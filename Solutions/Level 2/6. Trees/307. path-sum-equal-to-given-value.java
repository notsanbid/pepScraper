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

  public static int ans = 0;

  public static void pathSum(TreeNode node, HashMap<Integer, Integer> map, int tar, int prefixSum) {
    if (node == null)
      return;

    prefixSum += node.val;
    ans += map.getOrDefault(prefixSum - tar, 0);

    map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

    pathSum(node.left, map, tar, prefixSum);
    pathSum(node.right, map, tar, prefixSum);

    map.put(prefixSum, map.get(prefixSum) - 1);
    if (map.get(prefixSum) == 0)
      map.remove(prefixSum);
  }

  public static int pathSum(TreeNode root, int K) {
    // prefix sum , Frequency
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    pathSum(root, map, K, 0);
    return ans;
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
    int tar = scn.nextInt();

    int ans = pathSum(root, tar);
    System.out.println(ans);
  }

  public static void main(String[] args) {
    solve();
  }
}