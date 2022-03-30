import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] argv) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arr ar = new Arr();

        ar.Arr_add(1); //값 추가하기
        //배열 형태 1
        for(int i=0;i<ar.getSize();i++){
            System.out.print(ar.getArr(i)+" ");
        }
        System.out.println();

        ar.Arr_add(2); //값 추가하기
        //배열 형태 1 2
        for(int i=0;i<ar.getSize();i++){
            System.out.print(ar.getArr(i)+" ");
        }System.out.println();

        ar.Arr_add(3); //값 추가하기
        //배열 형태 1 2 3 0
        for(int i=0;i<ar.getSize();i++){
            System.out.print(ar.getArr(i)+" ");
        }System.out.println();


        ar.Arr_add(4); //값 추가하기
        //배열 형태 1 2 3 4
        for(int i=0;i<ar.getSize();i++){
            System.out.print(ar.getArr(i)+" ");
        }System.out.println();

        ar.Arr_add(5); //값 추가하기
        //배열 형태 1 2 3 4 5 0 0 0 0 0
        for(int i=0;i<ar.getSize();i++){
            System.out.print(ar.getArr(i)+" ");
        }System.out.println();

        ar.Arr_add(6); //값 추가하기
        //배열 형태 1 2 3 4 5 6 0 0 0 0
        for(int i=0;i<ar.getSize();i++){
            System.out.print(ar.getArr(i)+" ");
        }System.out.println();


        ar.Arr_add(7); //값 추가하기
        //배열 형태 1 2 3 4 5 6 7 0 0 0
        for(int i=0;i<ar.getSize();i++){
            System.out.print(ar.getArr(i)+" ");
        }System.out.println();

        ar.Arr_insert(3,9); //3번째 인덱스에 9추가
        //배열 형태 1 2 3 9 4 5 6 7 0 0
        for(int i=0;i<ar.getSize();i++){
            System.out.print(ar.getArr(i)+" ");
        }System.out.println();

        ar.Arr_remove(2); //값 삭제하기(2번째 자리 삭제)
        //배열 형태 1 2 9 4 5 6 7 0 0 0
        for(int i=0;i<ar.getSize();i++){
            System.out.print(ar.getArr(i)+" ");
        }System.out.println();

        ar.Arr_remove(1); //값 삭제하기(2번째 자리 삭제)
        //배열 형태 1 9 4 5 6 7 0 0 0 0
        for(int i=0;i<ar.getSize();i++){
            System.out.print(ar.getArr(i)+" ");
        }System.out.println();


        ar.Arr_remove(1); //값 삭제하기(2번째 자리 삭제)
        for(int i=0;i<ar.getSize();i++){
            System.out.print(ar.getArr(i)+" ");
        }System.out.println();
        //배열 형태 1 4 5 6 7 0 0 0 0 0

        ar.Arr_remove(1); //값 삭제하기(2번째 자리 삭제)
        for(int i=0;i<ar.getSize();i++){
            System.out.print(ar.getArr(i)+" ");
        }System.out.println();
        //배열 형태 1 5 6 7 0 0 0 0 0 0

        ar.Arr_remove(1); //값 삭제하기(2번째 자리 삭제)
        for(int i=0;i<ar.getSize();i++){
            System.out.print(ar.getArr(i)+" ");
        }System.out.println();
        //배열 형태 1 6 7 0 0 0 0 0 0 0

        ar.Arr_remove(1);
        for(int i=0;i<ar.getSize();i++){
            System.out.print(ar.getArr(i)+" ");
        }System.out.println();
        //배열 형태 1 7 0 0 0(언더플로우를 고려해 배열의 크기를 반으로 줄임.)


        System.out.println("응용과제");

        Arr arrA = new Arr();
        Arr arrB = new Arr();
        Arr arrC = new Arr(); //A배열과 B배열 입력받기.

        System.out.print("최대 차수를 입력하세요: ");
        int N = Integer.parseInt(br.readLine());
        System.out.print("배열A의 각 차수별 계수를 입력하세요: "); //높은차수부터 3 1 0 2 1이런식으로 입력받기.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N+1;i++){
            int num = Integer.parseInt(st.nextToken());
            arrA.Arr_add(num);
        }
        System.out.print("배열B의 각 차수별 계수를 입력하세요: "); //0 4 3 5 0
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N+1;i++){
            int num = Integer.parseInt(st.nextToken());
            arrB.Arr_add(num);
        }
        for(int i=0;i<N+1;i++){ //두 배열의 같은 차수끼리 더하기
            arrC.Arr_add((arrA.getArr(i))+arrB.getArr(i));
        }
        System.out.print("두 배열의 합은: ");
        for(int i=0;i<N+1;i++){ //각 다항식의 합 출력하기.
            System.out.print("("+arrC.getArr(i)+")"+"X^"+"("+(N-i)+")");
            if(i<N) System.out.print("+"); //마지막은 +출력 없이 그냥 출력
        }

    }
}
