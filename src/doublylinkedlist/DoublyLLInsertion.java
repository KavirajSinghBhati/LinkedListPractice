package doublylinkedlist;

class Node {
    int data;
    Node prev;
    Node next;
    Node (int x) {
        data = x;
        prev = null;
        next = null;
    }
}

public class DoublyLLInsertion {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node tmp1 = new Node(20);
        Node tmp2 = new Node(30);
        head.next = tmp1;
        tmp1.prev = head;
        tmp1.next = tmp2;
        tmp2.prev = tmp1;
        System.out.println("Printing Doubly LL initially");
        printList(head);
        // insert at begin
        head = insertBegin(5, head);
        head = insertBegin(1, head);
        System.out.println("After insert at begin");
        printList(head);
        //insert end
        head = insertEnd(40, head);
        head = insertEnd(50, head);
        System.out.println("After insert at end");
        printList(head);
        //delete from head
        head = deleteHead(head);
        System.out.println("After deleting head");
        printList(head);
        //delete at end
        head = deleteEnd(head);
        System.out.println("After deleting at end");
        printList(head);
    }

    static Node insertBegin(int data, Node head) {
        Node temp = new Node(data);
        temp.next = head;
        if (head != null)
            head.prev = temp;
        return temp;
    }

    static Node insertEnd(int data, Node head) {
        Node temp = new Node(data);
        if (head == null)
            return temp;
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = temp;
        temp.prev = curr;
        return head;
    }

    static Node deleteHead(Node head) {
        if (head == null || head.next == null)
            return null;
        else {
            head = head.next;
            head.prev = null;
            return head;
        }
    }

    static Node deleteEnd(Node head) {
        if (head == null || head.next == null)
            return null;
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.prev.next = null;
        return head;
    }

    static void reverse(Node head) {

    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
