import java.util.NoSuchElementException;

public class CustomList<T> {
    private class Node {
        T value;
        Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head = null, tail = null;

    public void addLast(T value) {
        Node node = new Node(value, null);
        if (head == null) {
            head = node;
        } else if (head == tail) {
            head.next = node;
        } else {
            tail.next = node;
        }
        tail = node;
    }

    public void addFirst(T value) {
        Node node = new Node(value, null);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public T getFirst() {
        return head.value;
    }

    public T getLast() {
        return tail.value;
    }

    public T removeFirst() {
        if (head==null){
            throw new NoSuchElementException();
        } else if (head==tail) {
            Node temp = head;
            head = null;
            tail = null;
            return temp.value;
        }else{
            Node temp = head;
            head = head.next;
            return temp.value;

        }

    }


}
