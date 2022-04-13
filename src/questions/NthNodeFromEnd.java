package questions;

public class NthNodeFromEnd {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        printList(head);

        nthNodeFromEndMethodOne(head, 4);
        nthNodeFromEndMethodTwo(head, 2);
    }

    static void nthNodeFromEndMethodOne(Node head, int n) {
        if (head == null)
            return;
        int len = 0;
        for (Node curr = head; curr != null; curr = curr.next)
            len++;
        if (n > len)
            return;
        Node curr = head;
        for (int i = 1; i < len - n + 1; i++)
            curr = curr.next;
        System.out.println(curr.data);
    }

    static void nthNodeFromEndMethodTwo(Node head, int n) {
        if (head == null)
            return;
        Node first = head, second = head;
        for (int i = 0; i < n; i++) {
            if (first == null)
                return;
            first = first.next;
        }
        while (first != null) {
            second = second.next;
            first = first.next;
        }
        System.out.println(second.data);
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
