import java.util.NoSuchElementException;

public class SList <E>{
    protected Node head; //첫 노드를 가리킴
    protected Node tail;
    protected Node p;
    private int size;
    public SList(){
        head = null;
        tail = null;
        size =0;
    }
    public int search(E target){
        p = head;
        for(int k =0;k<size;k++){
            if(target == p.getItem()) return k;
            p = p.getNext();
        }
        return -1;
    }

    public void getItem(){
        p =head;
        for(int i=0;i<size;i++){
            System.out.println(p.getItem());
            p = p.getNext();
        }

    }
    public void insertFront(E newItem){
        head = new Node(newItem,head);
        size++;
    }
    public void insertAfter(E newItem, Node p){// 노드p 바로 다음에 새 노드 삽입
        p.setNext(new Node(newItem,p.getNext()));
        size++;
    }
    public void deleteFront(){//맨 앞에 것 삭제 head가 가리키는 곳 변경
        if(size ==0) throw new NoSuchElementException();
        head = head.getNext();
        size--;
    }
    public void deleteAfter(Node p){
        if(p==null) throw new NoSuchElementException();
        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size--;
    }

    public int getSize() {
        return size;
    }
}


