package leetcode;

public class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode cur = node, p = l1, q = l2;
        int carry = 0;
        while (p != null || q != null) {
            int pval = p == null ? 0 : p.val;
            int qval = q == null ? 0 : q.val;
            int sum = pval + qval + carry;
            cur.next = new ListNode(sum % 10);    //缺少一个curcur.next;
            carry = sum / 10;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        if(carry!=0)
            cur.next=new ListNode(1);
        return node.next;
    }
}
