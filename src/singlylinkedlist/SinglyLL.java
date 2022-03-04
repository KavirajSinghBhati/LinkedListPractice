package singlylinkedlist;

class Node {
    int data;
    Node next;
    Node (int x) {
        data = x;
        next = null;
    }
}

public class SinglyLL {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        System.out.println("Initial LL");
        printList(head);

        head = insertBegin(head, 5);
        head = insertBegin(head, 2);
        head = insertBegin(head, 1);

        System.out.println("After Insert at Beginning Operation");
        printList(head);

        head = insertEnd(head, 40);
        head = insertEnd(head, 50);
        head = insertEnd(head, 60);

        System.out.println("After Insert at End Operation");
        printList(head);

        head = insertPosition(head, 25, 6);

        System.out.println("After Insert at any position Operation");
        printList(head);
    }

    static Node insertBegin(Node head, int x) {
        Node temp = new Node(x);
        temp.next = head;
        return temp;
    }

    static Node insertEnd(Node head, int x) {
        Node temp = new Node(x);
        if (head == null)
            return temp;
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = temp;
        return head;
    }

    static Node insertPosition(Node head, int x, int pos) {
        Node temp = new Node(x);
        if (pos == 1) {
            temp.next = head;
            return temp;
        }
        Node curr = head;
        for (int i = 1; i <= pos - 2 && curr.next != null; i++)
            curr = curr.next;
        if (curr == null || curr.next == null) //position out of bounds
            return head;
        temp.next = curr.next;
        curr.next = temp;
        return head;
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
