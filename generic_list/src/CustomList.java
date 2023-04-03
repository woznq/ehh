public class CustomList <T>{
    private class Node{
        T value;
        Node next;
        public Node(T value, Node next){
            this.value = value;
            this.next = next;
        }
    }
    private Node head=null, tail=null;

    public void addLast(T value){
        if(head==null){
            Node node = new Node(value, null);
            tail = node;
            head = node;
        }else if(head==tail){
            Node node = new Node(value, null);
            head.next = node;
            tail = node;
        }else {
            Node node = new Node(value, null);
            tail.next = node;
            tail = node;
        }
    }
    public T getLast(){
        return tail.value;
    }


}
