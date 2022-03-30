import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] argv) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SList<String> lst = new SList<>();
        String s = "강호동 122";
        if(lst.search(s)==-1) lst.insertFront(s);
        else {
            lst.search(s);
            lst.deleteAfter(lst.p);
        }
        s = "이승기 123";
        if(lst.search(s)==-1) lst.insertFront(s);
        else {
            lst.search(s);
            lst.deleteAfter(lst.p);
        }
        s = "허준 124";
        if(lst.search(s)==-1) {
            lst.search("강호동 122");
            lst.insertAfter(s,lst.p);
        }
        else {
            lst.search(s);
            lst.deleteAfter(lst.p);
        }
        s = "허준 124";
        if(lst.search(s)==-1) {
            lst.search("이승기 123");
            lst.insertAfter(s,lst.p);
        }
        else {
            lst.search(s);
            lst.deleteAfter(lst.p);
        }

        lst.getItem();

    }
}
