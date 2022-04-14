package questions;

import java.util.ArrayList;

public class IterativeReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        printList(head);

        head = reverseNaive(head);

        printList(head);
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    static Node reverseNaive(Node head) {
        if (head == null)
            return null;
        ArrayList<Integer> arr = new ArrayList<>();
        for (Node curr = head; curr != null; curr = curr.next)
            arr.add(curr.data);
        for (Node curr = head; curr != null; curr = curr.next)
            curr.data = arr.remove(arr.size() - 1);
        return head;
    }
}
