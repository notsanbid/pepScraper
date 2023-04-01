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

    // Encodes a tree to a single string.
    private static void serialize_(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("-1001 ");
            return;
        }

        sb.append(root.val + " ");
        serialize_(root.left, sb);
        serialize_(root.right, sb);
    }

    public static String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        serialize_(root, sb);
        return sb.toString();
    }

    static int idx = 0;

    private static TreeNode deserialize(int[] arr) {
        if (idx >= arr.length || arr[idx] == -1001) {
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(arr[idx++]);
        node.left = deserialize(arr);
        node.right = deserialize(arr);

        return node;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String str) {
        String[] ar = str.split(" ");
        int[] arr = new int[ar.length];
        int i = 0;
        for (String s : ar)
            arr[i++] = Integer.parseInt(s);

        return deserialize(arr);
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

        String s = serialize(root);
        display(deserialize(s));
    }

    public static void main(String[] args) {
        solve();
    }
}