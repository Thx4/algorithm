package leetcode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        int n = 1;
        ListNode list = head;
        while (list.next != null) {
            list = list.next;
            n++;
        }

        int add = n - k % n;
        if (add == n) {
            return head;
        }

        list.next = head;
        while (add-- > 0) {
            list = list.next;
        }
        ListNode res = list.next;
        list.next = null;
        return res;
    }
    class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}
