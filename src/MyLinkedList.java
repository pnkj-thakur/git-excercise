// Final Demo
public class MyLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; next = null; }
    }

    Node head;

    // FEATURE 1: Add
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    // FEATURE 2: Delete (NEW CODE)
    public void deleteByKey(int key) {
        Node current = head, prev = null;

        // If head holds the key
        if (current != null && current.data == key) {
            head = current.next;
            return;
        }

        // Search for key
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        // If key was not present
        if (current == null) return;

        // Unlink the node
        prev.next = current.next;
    }

    // FEATURE 1: Print
    public void printList() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        System.out.println("--- Testing Feature 1: Add & Print ---");
        list.add(10);
        list.add(20);
        list.add(30);
        list.printList();

        System.out.println("\n--- Testing Feature 2: Delete 20 ---");
        list.deleteByKey(20);
        list.printList();
    }
}
