package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q23 {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o1 <= o2 ? 1 : -1);
        priorityQueue.add(4);
        priorityQueue.add(3);
        System.out.println(priorityQueue.peek());
    }

    /**
     * 利用分治的思想
     */

    /**
     * 利用堆实现
     * 直接将所有ListNode放入堆，会导致超出内存
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) ->
                o1.val < o2.val ? -1 : o1.val == o2.val ? 0 : 1
        );
//        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                if (o1.val < o2.val)
//                    return -1;
//                else if (o1.val == o2.val)
//                    return 0;
//                else
//                    return 1;
//            }
//        });

        for (ListNode temp : lists) {
            if (temp != null)
                priorityQueue.add(temp);
        }
        ListNode dump = new ListNode(0);
        ListNode cur = dump;
        while (!priorityQueue.isEmpty()) {
            cur.next = priorityQueue.poll();
            if (cur.next.next != null)
                priorityQueue.add(cur.next.next);
            cur = cur.next;
        }
        return dump.next;

        /*  会超出内存的呢
        for (ListNode temp : lists) {
            while (temp != null) {
                priorityQueue.add(temp);
                temp = temp.next;
            }
        }
        ListNode dump = new ListNode(0);
        ListNode cur = dump;
        while (!priorityQueue.isEmpty()) {
            cur.next = priorityQueue.poll();
            cur = cur.next;
        }
        return dump.next;
        */
    }
}
