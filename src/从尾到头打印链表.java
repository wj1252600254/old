import java.util.ArrayList;
import java.util.Stack;

public class 从尾到头打印链表 {
    /**
     * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    /**
     * 利用头插法
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        ListNode head = new ListNode(-1);
        while (listNode!=null){
            ListNode next=listNode.next;
            listNode.next=head.next;
            head.next=listNode;
            listNode=next;
        }
        head=head.next;
        while (head!=null){
            arrayList.add(head.val);
            head=head.next;
        }
        return arrayList;
    }

    /**
     * 使用递归
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> arrayList=new ArrayList<>();
//        if(listNode==null)
//            return arrayList;
        while (listNode!=null){
            arrayList.addAll(printListFromTailToHead2(listNode.next));
            arrayList.add(listNode.val);
        }
        return arrayList;
    }


}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
