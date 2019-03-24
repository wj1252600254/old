package leetcode;

public class Q25 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode pre = n1;
        while (pre != null) {
            System.out.println(pre.val);
            pre = pre.next;
        }
        System.out.println("------------");
        ListNode ans = new Q25().reverse(n1, 3);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    /**
     * 先判断是否可以逆转，再递归
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode node = head;
//        while (k-- > 1) {    //此处不能用自减，因为后面还会用到k，如果用的，那么后面k相当于等于1了
//            node = node.next;
//            if (node == null)
//                return head;
//        }
        for(int i=0; i<k-1; i++){
            node = node.next;
            if(node == null){
                return head;
            }
        }
        ListNode end = node;
        ListNode temp = end.next;
        ListNode ans = reverse(head, k);
        head.next = reverseKGroup(temp, k);
        return ans;
    }

    public ListNode reverse(ListNode head, int k) {
        ListNode dump = new ListNode(-1);
        while (k-- > 0 && head != null) {
            ListNode next = head.next;
            head.next = dump.next;
            dump.next = head;
            head = next;
        }
        return dump.next;
    }
}
