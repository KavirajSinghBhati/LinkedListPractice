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

        head = insertBegin(head, 5);
        head = insertBegin(head, 2);

        printList(head);

        head = insertEnd(head, 40);
        head = insertEnd(head, 50);

        printList(head);

        head = deleteHead(head);
        head = deleteHead(head);

        printList(head);

        head = deleteKthNode(head, 4);
        head = deleteKthNode(head, 4);

        printList(head);
    }

    static Node insertBegin(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
            return temp;
        }
        else {
            temp.next = head.next;
            head.next = temp;
            int d = head.data;
            head.data = temp.data;
            temp.data = d;
            return head;
        }
    }

    static Node insertEnd(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
            return temp;
        }
        else {
            temp.next = head.next;
            head.next = temp;
            int t = head.data;
            head.data = temp.data;
            temp.data = t;
            return temp;
        }
    }

    static Node deleteHead(Node head) {
        if (head == null || head.next == head) {
            return null;
        }
        else {
            head.data = head.next.data;
            head.next = head.next.next;
            return head;
        }
    }

    static Node deleteKthNode(Node head, int k) {
        if (head == null)
            return null;
        if (k == 1)
            deleteHead(head);
        Node r = head;
        for (int i = 0; i < k - 2; i++)
            r = r.next;
        r.next = r.next.next;
        return head;
    }

    static void printList(Node head) {
        Node curr = head;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);
        System.out.println();
    }
}
