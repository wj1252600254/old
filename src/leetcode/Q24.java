package leetcode;

public class Q24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p1 = head;
        ListNode p2 = p1.next;
        p1.next = p2.next;
        p2.next = p1;
        head = p2;
        while (p1.next != null && p1.next.next != null) {
            p2 = p1.next.next;
            ListNode p = p1.next;
            p.next=p2.next;
            p1.next = p2;
            p2.next = p;
            p1 = p;
        }
        return head;
    }
}
