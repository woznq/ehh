import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class CustomList<T> extends AbstractList<T> {
    @Override
    public T get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            if (node.next == null) {
                throw new NoSuchElementException();
            }
            node = node.next;
        }
        return node.value;
    }

    @Override
    public int size() {
        if (head == null) {
            return 0;
        }
        Node node = head;
        int size = 1;
        while (node != tail) {
            size++;
            node = node.next;
        }
        return size;
    }

    @Override
    public boolean add(T t) {
        addLast(t);
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node node = head;
            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                Node temp = node;
                node = node.next;
                return temp.value;
            }
        };
    }

    @Override
    public Stream<T> stream() {
        Stream.Builder<T> builder = Stream.builder();
        for (var i: this){
            builder.accept(i);
        }
        return builder.build();
    }

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
        if (head == null) {
            throw new NoSuchElementException();
        } else if (head == tail) {
            Node temp = head;
            head = null;
            tail = null;
            return temp.value;
        } else {
            Node temp = head;
            head = head.next;
            return temp.value;

        }

    }

    public T removeLast() {
        if (head == null) {
            throw new NoSuchElementException();
        } else if (head == tail) {
            Node temp = head;
            head = null;
            tail = null;
            return temp.value;
        } else {
            Node temp = head;

//            for(;temp.next != tail;temp = temp.next); dziala, ale to jest brzydko
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;

            Node temp2 = tail;
            tail = temp;

            return temp2.value;
        }
    }

}
