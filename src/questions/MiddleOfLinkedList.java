package questions;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        printList(head);

        // middleOfLinkedListNaive(head);
        middleOfLinkedListEfficient(head);
    }

    static void middleOfLinkedListNaive(Node head) {
        if (head == null)
            return;
        int count = 0;
        Node curr;
        for (curr = head; curr != null; curr = curr.next)
            count++;
        curr = head;
        for (int i = 0; i < count / 2; i++)
            curr = curr.next;
        System.out.println("Middle = " + curr.data);
    }

    static void middleOfLinkedListEfficient(Node head) {
        if (head == null)
            return;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle = " + slow.data);
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
