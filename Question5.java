class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question5 {
    public static void main(String[] args) {
        ListNode head1 = createLinkedList(new int[]{25, 35, 12, 4, 36, 48});
        ListNode head2 = createLinkedList(new int[]{8, 32, 22, 45, 63, 49});

        System.out.println("Linked-List-1: ");
        printLinkedList(head1);

        System.out.println("\nLinked-List-2: ");
        printLinkedList(head2);

        ListNode mergedList = mergeLinkedLists(head1, head2);
        ListNode sortedList = mergeSort(mergedList);

        System.out.println("\nMerged and Sorted Linked-List:");
        printLinkedList(sortedList);
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

    public static ListNode mergeLinkedLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        }
        if (head2 != null) {
            current.next = head2;
        }

        return dummy.next;
    }

    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null) {
            current.next = left;
        }
        if (right != null) {
            current.next = right;
        }

        return dummy.next;
    }
}
