package leetcode.topic100;

public class N2AddTwoNumbers {

    public static void main(String[] args) {

    }


    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p1 = l1, p2 = l2;
        ListNode dummyHead = new ListNode(0);

        //Note that we use a dummy head to simplify the code.
        // Without a dummy head,
        // you would have to write extra conditional statements to initialize the head's value.
        ListNode currNode = dummyHead;
        while (p1 != null || p2 != null) {
            ListNode node = new ListNode(0);
            int value1 = p1 != null ? p1.val : 0;
            int value2 = p2 != null ? p2.val : 0;
            int sum = value1 + value2 + carry;
            node.val = sum % 10;
            carry = sum / 10;
            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null ? p2.next : null;

            currNode.next = node;
            currNode = node;

        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            currNode.next = node;
        }
        return dummyHead.next;
    }

}
