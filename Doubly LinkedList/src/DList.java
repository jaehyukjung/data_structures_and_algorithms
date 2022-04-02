import java.util.NoSuchElementException;

public class DList<E> {

    private Node head; //가장 첫노드를 가리키는 변수
    private Node tail; // 가장 마지막 노드를 가리키는 변수
    private int size;

    public DList(){ // 생성자
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public Node search(int index){
        if(index <0 || index>=size) throw new IndexOutOfBoundsException();
        if( index> size/2){
            Node x = tail;
            for(int i = size-1;i>index;i--){
                x = x.prev;
            }
            return x;
        }
        else {
            Node x = head;
            for(int i =0;i<index;i++){
                x = x.next;
            }
            return x;
        }
    }

    public void insertFirst(E value) {
        Node<E> newNode = new Node<E>(value);
        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        size++;

        if (head.next == null) {
            tail = head;
        }
    }
    public boolean insert(E value) {
        insertLast(value);
        return true;
    }

    public void insertLast(E value) {
        Node<E> newNode = new Node<E>(value);	// 새 노드 생성

        if (size == 0) {	// 처음 넣는 노드일 경우 addFisrt로 추가
            insertFirst(value);
            return;
        }

        /*
         * 마지막 노드(tail)의 다음 노드(next)가 새 노드를 가리키도록 하고
         * tail이 가리키는 노드를 새 노드로 바꿔준다.
         */
        tail.next = newNode;
        newNode.prev = tail; //새로운 노드의 이전 노드의 값은 tail이 가리켰던 값.
        tail = newNode; //마지막은 새로운 노드기 때문에 tail은 새로운 노드를 가리킴.
        size++;
    }
    public void insertAter(int index, E value) {

        // 잘못된 인덱스를 참조할 경우 예외 발생
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        // 추가하려는 index가 가장 앞에 추가하려는 경우 addFirst 호출
        if (index == 0) {
            insertFirst(value);
            return;
        }
        // 추가하려는 index가 마지막 위치일 경우 addLast 호출
        if (index == size) {
            insertLast(value);
            return;
        }

        // 추가하려는 위치의 이전 노드
        Node<E> prevNode = search(index - 1);

        // 추가하려는 위치의 노드
        Node<E> nextNode = prevNode.next;

        // 추가하려는 노드
        Node<E> newNode = new Node<E>(value);

        /**
         * 이전 노드가 가리키는 노드를 끊은 뒤
         * 새 노드로 변경해준다.
         * 또한 새 노드가 가리키는 노드는 next_Node로
         * 설정해준다.
         */
        prevNode.next = null;
        nextNode.prev = null;

        prevNode.next = newNode;

        newNode.prev = prevNode;
        newNode.next = nextNode;

        nextNode.prev = newNode;
        size++;
    }

    public E remove() {

        Node<E> headNode = head;

        if (headNode == null) throw new NoSuchElementException();

        // 삭제된 노드를 반환하기 위한 임시 변수
        E element = headNode.data;

        // head의 다음 노드
        Node<E> nextNode = head.next;

        // head 노드의 데이터들을 모두 삭제
        head.data = null;
        head.next = null;
        if(nextNode != null) {
            nextNode.prev = null;
        }

        // head 가 다음 노드를 가리키도록 업데이트
        head = nextNode;
        size--;

        /**
         * 삭제된 요소가 리스트의 유일한 요소였을 경우
         * 그 요소는 head 이자 tail이었으므로
         * 삭제되면서 tail도 가리킬 요소가 없기 때문에
         * size가 0일경우 tail도 null로 변환
         */
        if(size == 0) {
            tail = null;
        }
        return element;
    }

    public E remove(int index) {

        // 잘못된 범위에 대한 예외
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        // 삭제하려는 노드가 첫 번째 원소일 경우
        if (index == 0) {
            return remove();
        }


        Node<E> prevNode = search(index - 1);	// 삭제할 노드의 이전 노드
        Node<E> removedNode = prevNode.next;	// 삭제할 노드
        Node<E> nextNode = removedNode.next;	// 삭제할 노드의 다음 노드

        E element = removedNode.data;	// 삭제되는 노드의 데이터를 반환하기 위한 임시변수

        // 이전 노드가 가리키는 노드를 삭제하려는 노드의 다음노드로 변경
        prevNode.next = null;
        removedNode.next = null;
        removedNode.prev = null;
        removedNode.data = null;

        // 삭제하려는 노드가 마지막 노드가 아닌 경우
        if(nextNode != null) {
            nextNode.prev = null;
            nextNode.prev = prevNode; //삭제 노드 다음 노드의 이전을 삭제노드 이전 노드에 연결
            prevNode.next = nextNode; //삭제 노드 이전 노드의 다음을 삭제노드 이후 노드에 연결
        }
        // 마지막 노드를 삭제하는 경우
        else {
            tail = prevNode;
        }
        size--;

        return element;
    }
    public int get(E target) {
        for(int i=0;i<size;i++){
            if(target.equals(search(i).data)) return i;
        }
        return -1;
    }
    public int getSize() {
        return size;
    }
}
