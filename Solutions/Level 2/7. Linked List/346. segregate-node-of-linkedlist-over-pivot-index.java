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

  public static int length(ListNode head) {
    int len = 0;
    ListNode curr = head;
    while (curr != null) {
      curr = curr.next;
      len++;
    }
    return len;
  }

  public static ListNode segregate(ListNode head, int idx) {
    if (head == null || head.next == null)
      return head;

    int i = 0, data = 0;
    ListNode curr = head;
    while (curr != null) {
      if (i == idx)
        data = curr.val;

      i++;
      curr = curr.next;
    }

    ListNode smaller = new ListNode(-1);
    ListNode sp = smaller;

    ListNode greater = new ListNode(-1);
    ListNode gp = greater;

    i = 0;
    curr = head;
    ListNode pivot = null;
    while (curr != null) {
      if (i == idx) {
        pivot = curr;
      } else if (curr.val <= data) {
        sp.next = curr;
        sp = sp.next;
      } else {
        gp.next = curr;
        gp = gp.next;
      }

      curr = curr.next;
      i++;
    }

    sp.next = pivot;
    pivot.next = greater.next;
    gp.next = null;
    sp = sp.next;

    return smaller.next;
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
    int idx = scn.nextInt();
    h1 = segregate(h1, idx);
    printList(h1);
  }
}