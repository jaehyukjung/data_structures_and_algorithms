public class Deque <E>{
    private Node head; //가장 첫노드를 가리키는 변수
    private Node tail; // 가장 마지막 노드를 가리키는 변수
    private int size;
    DList<E> dl = new DList<>();
    public Deque(){

    }
    public void add_front(E value){
        dl.insertFirst(value);
    }
    public E delete_front(){
        return dl.remove();
    }
    public void add_rear(E value){
        dl.insertLast(value);
    }
    public E delete_rear(){
        return dl.remove(dl.getSize()-1);
    }

    public boolean is_empty(){
        if(dl.getSize()==0) return true;
        else return false;
    }

    public E get_front(){
        return (E) dl.search(0).data;
    }
    public E get_rear(){
        return (E) dl.search(dl.getSize()-1).data;
    }
//    public boolean is_full(){
//        if() return true;
//        else return false;
//    }
    public int size(){
        return dl.getSize();
    }
}
