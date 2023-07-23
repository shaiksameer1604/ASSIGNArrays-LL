import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question6 {
    public static void main(String[] args) {
        ListNode head = createLinkedList(new int[]{2, 5, 12, 2, 3, 5, 1, 2, 5, 5});

        System.out.println("Original Linked-List:");
        printLinkedList(head);

        removeDuplicates(head);

        System.out.println("\nLinked-List after removing duplicates:");
        printLinkedList(head);
    }

    public static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.print("null");
    }

    public static void removeDuplicates(ListNode head) {
        if (head == null) {
            return;
        }

        HashSet<Integer> uniqueSet = new HashSet<>();
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            if (uniqueSet.contains(current.val)) {
                // Remove the duplicate node
                prev.next = current.next;
            } else {
                uniqueSet.add(current.val);
                prev = current;
            }
            current = current.next;
        }
    }
}
