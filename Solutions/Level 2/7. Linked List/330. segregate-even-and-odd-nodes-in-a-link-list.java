import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode oitr = odd;
        ListNode eitr = even;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val % 2 != 0) {
                oitr.next = curr;
                oitr = oitr.next;
            } else {
                eitr.next = curr;
                eitr = eitr.next;
            }

            curr = curr.next;
        }

        eitr.next = odd.next;
        oitr.next = null;

        return even.next;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}