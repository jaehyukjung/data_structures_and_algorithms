import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] argv) throws IOException{
        Scanner sc = new Scanner(System.in);
        Deque deque = new Deque();

        int n=1;

        while(n>0){
            n= sc.nextInt();
            if(n<=0) break;
            deque.add_front(n);  //앞쪽으로 집어넣는것.
        }
        int size = deque.size();
        for(int i=0;i<size;i++){   //원래 출력은 rear로 출력해야 큐의 구조지만 넣은 곳에서 다시 빼는 형태로 출력하면 역순으로 출력가능.
            System.out.print(deque.delete_front()+" ");
        }


        //과제2
        deque = new Deque();
        int num = sc.nextInt();
        int k = sc.nextInt();
        for(int i=0;i<num;i++){
            deque.add_rear(i+1);  //끝에서 하나씩 입력을 받은 후
        }
        while(!deque.is_empty()){ //덱이 빌때까지 진행
            for(int i=0;i<k-1;i++){  //순서를 맞추기 위해 k 전까지 있던것들을 끝으로 다시 입력해주는 형태
                deque.add_rear(deque.delete_front());
            }
            System.out.print(deque.delete_front()+" "); //그럼 맨 앞에 있는 값이 k번째 값이므로 얘를 삭제하면서 출력하는 형태로 진행, 이때 진행되면서 덱의 사이즈는 1씩 줄어든다.
        }

    }
}
