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

  public static ListNode reverseList(ListNode node) {
    if (node == null || node.next == null)
      return node;

    ListNode prev = null;
    ListNode curr = node;
    while (curr != null) {
      ListNode forw = curr.next; // backup.

      curr.next = prev; // connection

      prev = curr; // move forw.
      curr = forw;
    }

    return prev;
  }

  public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
    if (l2 == null)
      return l1;
    l1 = reverseList(l1);
    l2 = reverseList(l2);

    ListNode dummy = new ListNode(-1), prev = dummy, c1 = l1, c2 = l2;

    int borrow = 0;
    while (c1 != null) {
      int sub = borrow + c1.val - (c2 != null ? c2.val : 0);
      if (sub < 0) {
        borrow = -1;
        sub += 10;
      } else
        borrow = 0;

      prev.next = new ListNode(sub);
      prev = prev.next;

      c1 = c1.next;
      if (c2 != null)
        c2 = c2.next;
    }

    ListNode head = reverseList(dummy.next), curr = head;
    while (curr != null && curr.val == 0) {
      ListNode forw = curr.next;
      curr.next = null;
      curr = forw;
    }

    return curr != null ? curr : new ListNode(0);
  }

  // InFput_code===================================================

  public static void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }

  public static ListNode makeList(int n) {
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    while (n-- > 0) {
      prev.next = new ListNode(scn.nextInt());
      prev = prev.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode head1 = makeList(scn.nextInt());
    ListNode head2 = makeList(scn.nextInt());

    ListNode ans = subtractTwoNumbers(head1, head2);
    printList(ans);
  }

}