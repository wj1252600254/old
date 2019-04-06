package offer;

import java.util.ArrayList;
import java.util.Arrays;

public class 删除链表中的重复节点 {
    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     *
     * @param pHead
     * @return
     */


    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead ==null || pHead.next==null)
            return pHead;
        ListNode next = pHead.next;
        while (next != null) {
            if (pHead.val == next.val) {
                next = next.next;
            } else {
                pHead.next = deleteDuplication(next);
            }
        }
        return pHead;
    }

    public static int muti(int[] arr) {
        int result = 0;
        int len = arr.length;
        Arrays.sort(arr);
        if (arr[0] >= 0) {
            result = arr[len - 1] * arr[len - 2] * arr[len - 3];
        } else if (arr[len - 1] <= 0) {
            result = arr[0] * arr[1] * arr[2];
        } else {
            result = Math.max(Math.max(arr[0] * arr[1] * arr[len - 1], arr[len - 1] * arr[len - 2] * arr[len - 3]), arr[0] * arr[1] * arr[2]);
        }
        return result;
    }

    public static void main(String[] args) {
//        int a = muti(new int[]{-9,0,2,7,8});
//        System.out.println(a);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(4);
        int[] arr = arrayList.stream().mapToInt(p -> p.intValue()).toArray();
        System.out.println(Arrays.toString(arr));
    }


}
