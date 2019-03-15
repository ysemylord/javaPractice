package leetcode;

public class N2 {

    public static void main(String[] args) {
        ListNode listOne = getListOne();
        ListNode listTwo = getListTwo();
        printList(listOne);
        printList(listTwo);
        ListNode node = addTwoNumbers2(listOne, listTwo);
        printList(node);
    }

    private static ListNode getListOne() {
        ListNode l1 = new ListNode(1);
        ListNode l2_1 = new ListNode(8);
        ListNode l3_2 = new ListNode(3);
        l1.next = l2_1;
        l2_1.next = l3_2;
        l3_2.next = null;
        return l1;
    }

    private static ListNode getListTwo() {
        ListNode l1 = new ListNode(7);
        ListNode l2_1 = new ListNode(1);
        l1.next = l2_1;
        return l1;
    }

    /**
     * 执行用时: 48 ms, 在Add Two Numbers的Java提交中击败了68.72% 的用户
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        int size1 = 0, size2 = 0;
        while (p1 != null) {
            size1++;
            p1 = p1.next;
        }

        while (p2 != null) {
            size2++;
            p2 = p2.next;
        }

        ListNode lengthList = null;
        ListNode shortList = null;
        if (size1 < size2) {
            shortList = l1;
            lengthList = l2;
        } else {
            shortList = l2;
            lengthList = l1;
        }

        ListNode lengthPointer = lengthList;
        ListNode shortPointer = shortList;

        while (shortPointer != null) {
            int sum = shortPointer.val + lengthPointer.val;
            if (sum >= 10) {
                lengthPointer.val = sum % 10;
                if (lengthPointer.next == null) {
                    lengthPointer.next = new ListNode(0);
                }
                lengthPointer.next.val = lengthPointer.next.val + 1;
            } else {
                lengthPointer.val = sum;
            }
            lengthPointer = lengthPointer.next;
            shortPointer = shortPointer.next;
        }

        while (lengthPointer != null && lengthPointer.val >= 10) {
            int orginValue = lengthPointer.val;
            int yuValue = orginValue % 10;
            int shangValue = orginValue / 10;
            lengthPointer.val = yuValue;
            if (lengthPointer.next == null) {
                lengthPointer.next = new ListNode(0);
            }
            lengthPointer.next.val = lengthPointer.next.val + shangValue;
            lengthPointer = lengthPointer.next;
        }


        return lengthList;

    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = l3;

        while (p1 != null || p2 != null) {

            int sum = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val)+p3.val;
            p1=(p1!=null?p1.next:p1);
            p2=(p2!=null?p2.next:p2);
            if (sum >= 10) {
                sum = sum % 10;
                ListNode newNode = new ListNode(1);
                p3.val = sum;
                p3.next = newNode;
                p3=p3.next;
            } else{
                ListNode newNode = new ListNode(0);
                p3.val = sum;

                if(p1==null&&p2==null){
                    break;
                }
                p3.next = newNode;
                p3=p3.next;
            }
        }

        return l3;

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val);
            System.out.print(",");
            listNode = listNode.next;
        }
        System.out.println();
    }
}
