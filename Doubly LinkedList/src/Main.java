import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] argv) throws IOException{
        DList dlist = new DList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s = br.readLine();
            if(s.equals("print")) break;
            if(dlist.get(s)==-1){ //해당 값이 없으면, 마지막에 삽입.
                dlist.insertLast(s);
            }
            else {
                int N = dlist.get(s); // 기존에 요소가 있으면 인덱스 번호 반환하고 삭제.
                dlist.remove(N);
            }
        }
        for(int i=0;i<dlist.getSize();i++){
            System.out.println(dlist.search(i).data);
        }
    }
}
