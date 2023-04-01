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

    public static ListNode segregateOnLastIndex(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode small = new ListNode(-1); // all Nodes smaller or equal to given data.
        ListNode sp = small; // smaller previous

        ListNode greater = new ListNode(-1); // all Nodes greater than given data.
        ListNode gp = greater; // greater previous

        ListNode tail = head;
        while (tail.next != null)
            tail = tail.next;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val <= tail.val){
                sp.next = curr;
                sp = sp.next;
            }
            else{
                gp.next = curr;
                gp = gp.next;
            }

            curr = curr.next;
        }

        gp.next = null;
        sp.next = greater.next;

        small.next = null;
        greater.next = null;

        return sp;
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
        h1 = segregateOnLastIndex(h1);
        printList(h1);
    }
}