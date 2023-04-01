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

    // lr -> left range, rr = right range
    static int bst_idx = 0;

    public static TreeNode constructBSTFromPostOrder(int[] arr, int lr, int rr) {
        if (bst_idx == -1 || arr[bst_idx] < lr || arr[bst_idx] > rr)
            return null;

        TreeNode node = new TreeNode(arr[bst_idx--]);
        node.right = constructBSTFromPostOrder(arr, node.val, rr);
        node.left = constructBSTFromPostOrder(arr, lr, node.val);

        return node;
    }

    public static TreeNode bstFromPostorder(int[] preorder) {
        return constructBSTFromPostOrder(preorder, -(int) 1e8, (int) 1e8);
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
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        bst_idx = n - 1;
        TreeNode root = bstFromPostorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}