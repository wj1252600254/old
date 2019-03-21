package leetcode;

public class Q19 {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
        while (n-- >= 0) {
            System.out.println(n);
        }

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode p1 = phead, p2 = phead;
        while (n-- >= 0) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return phead.next;
    }
}
