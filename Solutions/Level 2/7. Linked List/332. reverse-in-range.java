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

  static ListNode tt = null;
  static ListNode th = null;

  public static void addFirst(ListNode node) {
    if (th == null) {
      th = node;
      tt = node;
    } else {
      node.next = th;
      th = node;
    }
  }

  public static ListNode reverseInRange(ListNode head, int n, int m) {
    if (head == null || head.next == null || m == n)
      return head;

    ListNode curr = head;
    ListNode prev = null;

    int idx = 1;
    while (idx < m) {
      while (idx >= n && idx <= m) {
        ListNode forw = curr.next;
        curr.next = null;

        addFirst(curr);

        curr = forw;
        idx++;
      }

      if (idx > n) {
        tt.next = curr;
        if (prev != null) {
          prev.next = th;
          return head;
        }

        return th;
      }
      idx++;
      prev = curr;
      curr = curr.next;
    }

    return head;
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
    int sz = scn.nextInt();
    ListNode h1 = createList(sz);

    int m = scn.nextInt();
    int n = scn.nextInt();

    h1 = reverseInRange(h1, m, n);
    printList(h1);
  }
}