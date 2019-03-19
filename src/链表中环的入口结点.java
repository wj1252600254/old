public class 链表中环的入口结点 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null)   //得判断pHead.next
            return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while (p1 != p2) {    //此处应该用do{}while{}至少执行一次吧，一开始是相等的呢
            p1 = p1.next.next;
            p2 = p2.next;
        }
        p1 = pHead;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
