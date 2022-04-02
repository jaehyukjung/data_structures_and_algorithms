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
            if(dlist.get(s)==-1){
                dlist.insertLast(s);
            }
            else {
                int N = dlist.get(s);
                dlist.remove(N);
            }
        }
        for(int i=0;i<dlist.getSize();i++){
            System.out.println(dlist.search(i).data);
        }
    }
}
