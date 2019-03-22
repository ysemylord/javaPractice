package leetcode.littleTips;

public class DumpyHeadUse {

    //将数组arr转成一个链表
    public static void main(String[] args) {

    }


    //使用一个虚头部，可以使代码更加简洁和连贯
    private ListNode changeArrByDummyHead(int arr[]) {
        ListNode dummyHead = new ListNode(0);
        ListNode currNode = dummyHead;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            currNode.next = node;
            currNode = node;
        }
        return dummyHead;
    }


    private ListNode changeArrByNotDummyHead(int arr[]) {
        ListNode currNode = null, head = null;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            if (currNode == null) {//第一个节点
                head = currNode;
                currNode = node;
            } else {
                currNode.next = node;
                currNode = node;
            }

        }
        return head;
    }


}
