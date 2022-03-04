package singlylinkedlist;

class List {
    int data;
    List next;
    List (int x) {
        data = x;
        next = null;
    }
}

public class SinglyLLDeletion {
    public static void main(String[] args) {
        List head = new List(10);
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);
        head = insertEnd(head, 40);
        head = insertEnd(head, 50);
        head = insertEnd(head, 60);
        head = insertEnd(head, 70);

        System.out.println("Initial LL");
        printList(head);

        head = deleteBegin(head);
        head = deleteBegin(head);

        System.out.println("After Delete at Beginning Operation");
        printList(head);

        head = deleteEnd(head);
        head = deleteEnd(head);

        System.out.println("After Delete at End Operation");
        printList(head);

        head = deleteAtPosition(head, 2);

        System.out.println("After Delete at any position Operation");
        printList(head);
    }

    // utility functions

    static List insertEnd(List head, int x) {
        List temp = new List(x);
        if (head == null)
            return temp;
        List curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = temp;
        return head;
    }

    static void printList(List head) {
        List curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // deletion functions

    static List deleteBegin(List head) {
        if (head == null)
            return null;
        return head.next;
    }

    static List deleteEnd(List head) {
        if (head == null || head.next == null)
            return null;
        List curr = head;
        while (curr.next.next != null)
            curr = curr.next;
        curr.next = null;
        return head;
    }

    static List deleteAtPosition(List head, int pos) {
        if (head == null)
            return null;
        if (pos == 1) {
            return head.next;
        }
        List curr = head;
        for (int i = 1; i <= pos - 2 && curr.next != null; i++)
            curr = curr.next;
        if (curr == null || curr.next == null)
            return head;
        List next = curr.next.next;
        curr.next = next;
        return head;
    }
}
