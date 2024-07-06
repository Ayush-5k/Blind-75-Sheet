import java.util.*;
public class MergeKsortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });
        int n = lists.length;

        for (int i = 0; i < n; i++) {
            if (lists[i] != null) pq.add(lists[i]);
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            dummy.next = temp;
            dummy = dummy.next;

            if (temp.next != null) {
                pq.add(temp.next);
            }
        }
        return head.next;
    }
}
