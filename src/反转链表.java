public class 反转链表 {
    /**
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        ListNode phead = new ListNode(-1);
        while (head != null){
            ListNode next=head.next;
            head.next=phead.next;
            phead.next=head;
            head=next;
        }
        return phead.next;
    }

}
