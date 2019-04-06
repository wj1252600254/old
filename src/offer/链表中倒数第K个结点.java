package offer;

public class 链表中倒数第K个结点 {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null && k-- > 0) {
            p1 = p1.next;
        }   //此处并没有考虑k大于链表长度
        if(k>0)
            return null;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;

        }
        return p2;
    }
}
