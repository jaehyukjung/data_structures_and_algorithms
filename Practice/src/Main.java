import java.io.IOException;

public class Main {
    public static void main(String[] argv)throws IOException{

    }

}

class Node<E>{
    private Node<E> prev;
    private Node<E> next;
    private E data;

    public Node(E data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
    public void setPrev(Node prev){
        this.prev = prev;
    }
    public Node<E> getPrev(){
        return prev;
    }
    public void setNext(Node next){
        this.next = next;
    }
    public Node<E> getNext(){
        return next;
    }
    public E getData() {
        return this.data;
    }
}

class DoublyLinkedlist<E>{
    private Node<E> head;
    private Node<E> tail;
    int size =0;

    public Node getNode(int index){
        if(index< size/2){
            Node t = head;
            for(int i=0;i<index;i++){
                t = t.getNext();
            }
            return t;
        }
        else{
            Node t = tail;
            for(int i=size-1;i>index;i--){
                t = t.getPrev();
            }
            return t;
        }
    }

    public void insertFirst(E data){
        Node newNode = new Node<>(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }
    public void insertLast(E data){
        Node newNode =new Node<>(data);
        if(size==0) insertFirst(data);
        else{
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }
    public void insertMiddle(int index,E data){
        Node newNode = new Node(data);
        Node t = getNode(index);
        Node p = t.getPrev();


        newNode.setNext(p.getNext());
        t.setPrev(newNode);
        newNode.setPrev(t.getPrev());
        p.setNext(newNode);
    }

    public E deleteFirst(){

        Node del = getNode(0);
        E delItem = (E) del.getData();
        if( size ==1) {
            head = null;
            tail = null;
        }
        else{
            Node first = head;
            Node second = getNode(1);
            head = first.getNext();
            second.setPrev(null);
        }
        return delItem;
    }
    public E deleteLast(){
        Node last = tail;
        E delItem = (E) last.getData();
        if(size ==1){
            head = null;
            tail = null;
        }
        else{
            tail = last.getPrev();
            last.getPrev().setNext(null);
        }
        return delItem;
    }
    public E deleteMiddle(int index){
        Node del = getNode(index);
        E item = (E) del.getData();
        Node delnext = getNode(index +1);
        del.getPrev().setNext(del.getNext());
        del.getNext().setPrev(del.getPrev());
        del =null;
        return item;
    }



}
