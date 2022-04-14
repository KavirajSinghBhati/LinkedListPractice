package questions;

public class RecursiveReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        printList(head);

        //head = recursiveReverseNaive(head);

        head = recursiveReverseEfficient(head, null);

        printList(head);
    }

    static Node recursiveReverseNaive(Node head) {
        if (head == null || head.next == null)
            return head;
        Node rest_head = recursiveReverseNaive(head.next);
        Node rest_tail = head.next;
        rest_tail.next = head;
        head.next = null;
        return rest_head;
    }

    static Node recursiveReverseEfficient(Node curr, Node prev) {
        if (curr == null)
            return prev;
        Node next = curr.next;
        curr.next = prev;
        return recursiveReverseEfficient(next, curr);
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
