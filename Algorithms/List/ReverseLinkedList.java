package Algo.List;

/**
 * Abhijit.Biswas
 * Iterative:
 * 	Create 3 nodes, currNode, PrevNode and nextNode.
 * 	Initialize them as currNode = head; nextNode = null;prevNode = null;
 * 	Now keep reversing the pointers one by one till currNode!=null.
 *    while(currNode!=null){
 *      nextNode = currNode.next;
 *      currNode.next = prevNode;
 *      prevNode = currNode;
 *      currNode = nextNode;
 * }
 * 	At the end set head = prevNode;
 *Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class ReverseLinkedList {
    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Function to reverse the linked list */
    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }
}
