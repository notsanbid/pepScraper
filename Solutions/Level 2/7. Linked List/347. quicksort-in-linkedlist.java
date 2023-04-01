import java.util.*;

class Main {
  public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static int length(ListNode node) {
    if (node == null)
      return 0;

    ListNode curr = node;
    int len = 0;
    while (curr != null) {
      len++;
      curr = curr.next;
    }

    return len;
  }

  public static ListNode[] segregate(ListNode head, int pivotIdx) {
    ListNode small = new ListNode(-1);
    ListNode large = new ListNode(-1);
    ListNode pivotNode = head, sp = small, lp = large, curr = head;
    while (pivotIdx-- > 0)
      pivotNode = pivotNode.next;

    while (curr != null) {
      if (curr != pivotNode) {
        if (curr.val <= pivotNode.val) {
          sp.next = curr;
          sp = sp.next;
        } else {
          lp.next = curr;
          lp = lp.next;
        }
      }

      curr = curr.next;
    }

    pivotNode.next = null;
    sp.next = null;
    lp.next = null;

    return new ListNode[] { small.next, pivotNode, large.next };
  }

  public static ListNode[] mergeElements(ListNode[] left, ListNode pivotNode, ListNode[] right) {
    ListNode head = null;
    ListNode tail = null;
    if (left[0] != null && right[0] != null) {
      head = left[0];
      tail = right[1];
      left[1].next = pivotNode;
      pivotNode.next = right[0];
    } else if (left[0] != null) {
      head = left[0];
      tail = pivotNode;
      left[1].next = pivotNode;
    } else if (right[0] != null) {
      head = pivotNode;
      tail = right[1];
      pivotNode.next = right[0];
    } else {
      head = tail = pivotNode;
    }

    return new ListNode[] { head, tail };
  }

  public static ListNode[] quickSort_(ListNode head) {
    if (head == null || head.next == null)
      return new ListNode[] { head, head };

    int len = length(head);
    int pivotIdx = len / 2;
    ListNode[] segregatedElements = segregate(head, pivotIdx);

    ListNode[] left = quickSort_(segregatedElements[0]);
    ListNode[] right = quickSort_(segregatedElements[2]);

    return mergeElements(left, segregatedElements[1], right);
  }

  public static ListNode quickSort(ListNode head) {
    return quickSort_(head)[0];
  }

  public static void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }

  public static ListNode createList(int n) {
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    while (n-- > 0) {
      prev.next = new ListNode(scn.nextInt());
      prev = prev.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    int n = scn.nextInt();
    ListNode h1 = createList(n);

    ListNode head = quickSort(h1);
    printList(head);
  }
}