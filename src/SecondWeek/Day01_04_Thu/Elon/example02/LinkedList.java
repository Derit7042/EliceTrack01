package SecondWeek.Day01_04_Thu.Elon.example02;

public class LinkedList<T> {
    private Node head;
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    public LinkedList() {
        head = null;
    }

    public void append(T data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void printList() {
        if (head == null) {
            System.out.println("현재 연결 리스트가 비어있습니다.");
        }
        Node current = head;
        System.out.print(current.data.toString());
        while (current.next != null) {
            current = current.next;
            System.out.print("," + current.data.toString());
        }
    }
}
