package singlylinkedlist;

class SearchNode {
    int data;
    SearchNode next;
    SearchNode (int x) {
        data = x;
        next = null;
    }
}

public class SearchingInSinglyLL {
    public static void main(String[] args) {
        SearchNode head = new SearchNode(10);
        head = insertEnd(head, 5);
        head = insertEnd(head, 20);
        head = insertEnd(head, 15);
        System.out.println("Our LL is ");
        printList(head);

        System.out.println(searchIterative(head, 20));
    }

    // utility functions

    static SearchNode insertEnd(SearchNode head, int x) {
        SearchNode temp = new SearchNode(x);
        if (head == null)
            return temp;
        SearchNode curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = temp;
        return head;
    }

    static void printList (SearchNode head) {
        SearchNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // iterative search
    static int searchIterative (SearchNode head, int x) {
        int pos = 1;
        SearchNode curr = head;
        while (curr != null) {
            if (curr.data == x) {
                return pos;
            }
            pos++;
            curr = curr.next;
        }
        return -1;
    }

    // recursive search

}
