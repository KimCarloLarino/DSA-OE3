import java.util.Scanner;

public class OE3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList list = new LinkedList();

        class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
            }
        }  

        int choice = 0;
        while (choice != 5) {
            System.out.println();
            System.out.println("Choose an operation:");
            System.out.println();
            System.out.println("1. Add a node at the beginning");
            System.out.println("2. Add a node at the end");
            System.out.println("3. Add a node after a specified node");
            System.out.println("4. Display the list");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the element to add at the beginning: ");
                    int element = input.nextInt();
                    list.addFirst(element);
                    System.out.println("Element " + element + " added to the beginning of the list.");
                    break;
                case 2:
                    System.out.print("Enter the element to add at the end: ");
                    element = input.nextInt();
                    list.addLast(element);
                    System.out.println("Element " + element + " added to the end of the list.");
                    break;
                case 3:
                    System.out.print("Enter the element to add: ");
                    element = input.nextInt();
                    System.out.print("Enter the element after which to add: ");
                    int afterElement = input.nextInt();
                    list.addAfter(element, afterElement);
                    System.out.println("Element " + element + " added after " + afterElement);
                    break;
                case 4:
                    System.out.println("The list contains:");
                    list.displayList();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }
        input.close();
    }
}

class LinkedList {
    Node head;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void addAfter(int data, int after) {
        Node newNode = new Node(data);
        Node current = head;
        while (current != null && current.data != after) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Element " + after + " not found in the list.");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void displayList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
