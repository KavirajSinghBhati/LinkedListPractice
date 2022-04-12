package circularlinkedlist;

class Node {
    int data;
    Node next;
    Node (int x) {
        data = x;
        next = null;
    }
}

public class CircularLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = head;

        printList(head);
    }

    static void printList(Node head) {
        Node curr = head;
        do {
            System.out.println(curr.data);
            curr = curr.next;
        } while (curr != head);
    }
}
