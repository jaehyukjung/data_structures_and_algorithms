import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class ChainHash {
    class Node {
        private int key;
        private int value;
        private Node next;

        public Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        int getKey() {
            return key;
        }
        int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
    }

    private int size = 13;       //  해시 테이블 사이즈
    private Node[] table;   //  해시 테이블

    public ChainHash() {
        table = new Node[size];
        this.size = size;
    }


    public int hashValue(int key) { //해시 값 구하는 함수 h(x) = x % 13
        int hashcode = key;
        return hashcode % size;
    }
    public int hashValue2(int key) { //두번 째 해시 값 구하는 함수 g(x) = 7- x % 7
        int hashcode = key;
        return 7-hashcode %7 ;
    }



    public int search(int key) { // key를 이용하여 value 검색
        int hash = hashValue(key);
        int hash2 = hashValue2(key);
        Node p = table[hash];

        while (p != null) {
            if (p.getKey() == key ) //같으면 종료하고 리턴
                return p.getValue();
            p = p.next;
        } //끝까지 다 찾았는데 없으면 -1 리턴
        p = table[hash2];
        while (p != null) {
            if (p.getKey() == key) //같으면 종료하고 리턴
                return p.getValue();
            p = p.next;
        } //끝까지 다 찾았는데 없으면 -1 리턴

        return -1;
    }


    public int count(int hash){ //각 hash에 얼마나 들어있는지 확인하는 함수
        int cnt =0;
        Node p = table[hash];

        while (p != null) { //비어있다면 그냥 0 return ,아니라면
            p = p.next; //p를 옮겨 가면서 카운트를 1 늘리고 더이상 가리키는 노드가 없는경우 종료
            cnt++;
        }
        return cnt;
    }

    public void add(int key, int value) { //요소 추가하는 기능
        if( search(key)!=-1) return; // 추가하기 전에 탐색하고 집어넣기 //없는 경우 -1을 출력하므로 -1이 아니면 존재하니까 추가 x
        int hash = hashValue(key);  //h(x)를 호출하고
        int hash2 = hashValue2(key); //g(x)를 호출해

        if(count(hash)>count(hash2)) hash=hash2;  //count함수를 통해 해시 테이블 내에 더 적은 걸 선택해서 hash값에 저장.

        Node p = table[hash]; //hash 값에 head부분이 가리키는 노드를 p로 설정

        while (p != null) { //가리키는 노드가 없는 경우 반복문 종료 후 새 노드 삽입
            if (p.getKey()==(key)) { // 기존에 값이 있다면 value 값을 수정하고 집어넣기. 이번 경우엔 키값과 value값이 같기 때문에 필요 x
                return; //값이 있고 수정 했으므로 함수 종료.
            }
            if(p.next ==null){  // p가 가라키는 노드가 마지막 노드라면
                Node tmp = new Node(key, value, null); //노드를 생성하고
                p.next = tmp; // 가리키는 노드의 다음 노드를 새로 생성한 노드로 연결
                return; //이경우 삽입이 완료 했으므로 종료
            }
            p = p.next; //아니면 비어 있을 때까지, 계속 탐색
        }
        Node tmp = new Node(key, value, null);  //비어있는 경우,
        table[hash] = tmp; // 바로 헤드에서 연결
    }


    public void remove(int key) {  // 삭제하는 기능
        int hash = hashValue(key);
        Node p = table[hash];
        Node pp = null;     // 바로 앞 노드

        while (p != null) {
            if (p.getKey()==(key)) {
                if (pp == null)
                    table[hash] = p.next;
                else
                    pp.next = p.next;
                return;
            }

            pp = p;
            p = p.next;
        }
    }


    public void print_all() { //전체 해시 테이블 출력하는 함수
        for (int i = 0; i < size; i++) {  //각 해시 테이블의 해시 키값을 반복을 통해 출력
            Node p = table[i];
            System.out.printf("%02d  ", i);  //해시 키값을 출력후
            while (p != null) {  // 링크드 리스트 출력
                System.out.printf("->  %d  ", p.getKey());
                p = p.next;
            }
            System.out.println();
        }
    }

    public void print_one(int key) { //key 값이 속한 해시테이블의 라인 출력
        int hash = hashValue(key);
        int hash2 = hashValue2(key);
        if(count(hash)>count(hash2)) hash=hash2;

        Node p = table[hash];
        System.out.printf("%02d  ", hash);
        while (p != null) {
            System.out.printf("->  %d  ", p.getKey());
            p = p.next;
        }
        System.out.println();
    }


    public static void main(String[] args) throws IOException {
        ChainHash ch = new ChainHash();  //크기가 13인 해시테이블 생성
        Random rand =new Random();
        int arr[] =new int[20];
        for(int i=0;i<20;i++){
            arr[i] = rand.nextInt(20);  //크기가 20 이하인 양의 정수 생성
            System.out.print(arr[i]+" "); //출력해서 보여주고
            ch.add(arr[i],arr[i]); // 해시테이블에 추가 이때 키값과 value값을 동일하게 설정.
        }
        System.out.println();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ch.print_all(); // 전체 테이블 보여주기
        int num;
        while(true){
            System.out.print("수를 입력하세요: ");
            num = Integer.parseInt(br.readLine()); //정수 입력후
            int hash = ch.hashValue(num);  //h(x)를 호출해서 hash 값을 하나 구한뒤
            int hash2 = ch.hashValue2(num); //g(x)를 호출해 나머지 값을 구해서
            if(ch.count(hash)>ch.count(hash2)) hash=hash2; //더 작은 양이 들어있는 곳을 찾은 후

            if(ch.count(hash)==0){ //테이블이 비어있다면 추가하는 기능
                ch.add(num,num);
            }
            else break; //비어있지 않다면 멈추고
        }
        ch.print_one(num); //해당 key값에 해당하는 해시 내부 보여주기
        System.out.println();


    }

}