
public class ReorderList {
    public ListNode reverse(ListNode root) {
        if (root == null) return null;
        ListNode prev = null;
        ListNode curr = root;
        ListNode last = null;
        while (curr != null) {
            last = curr.next;
            curr.next = prev;
            prev = curr;
            curr = last;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;

        secondHalf = reverse(secondHalf);
        ListNode firstHalf = head;

        while (secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }
    }
}
