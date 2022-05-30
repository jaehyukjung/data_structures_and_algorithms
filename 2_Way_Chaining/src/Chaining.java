

public class Chaining<K,V> {
    private int M = 13;
    private int N = 7;
    private Node[] a = new Node[M];
    public static class Node{
        private Object key;
        private Object data;
        private Node next;
        public Node(Object newkey, Object newdata, Node ref){ //생성자
            key = newkey;
            data = newdata;
            next = ref;
        }
        public Object getKey(){ return key;}
        public Object getData(){return data;}
    }
    private int hash(K key){
        return (key.hashCode());
    }

}
