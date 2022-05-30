import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void insert_sort(int[] arr){
        int N = arr.length;
        for(int i=1;i<N;i++){  //1부터 N까지 추가해가며 정렬
            for(int j =0;j<i;j++){  //추가된 부분까지 새롭게 정렬
                if(arr[i]<arr[j]){ //새로 추가된 부분이 순차적으로 정렬된 앞의 배열을 차례로 지나며 자신보다 큰 값이 나타나면 해당 인덱스부터 한칸씩 뒤로밀기.
                    int temp = arr[i]; //한칸씩 뒤로 밀기 전 임시 변수에 값을 저장
                    for(int k=i-1;k>=j;k--){ //i값이 들어갈 자리부터 뒤로 한칸씩밀고
                        arr[k+1] =arr[k];
                    }
                    arr[j]=temp; //한칸씩 밀어내고 비어있는 j공간에 기존의 i번째를 저장.
                }
            }
        }
    }

    public static void shell_sort(int[] arr){
        int gap = arr.length / 2;  //처음 gap의 경우 배열 길이를 절반으로 나눈 정수값으로 설정.
        for (int i=gap;i>=1; i = i/2){  //i는 gap부터 반씩 줄여가며
            int ea = arr.length/i; //쉘 정렬을 위해 ea개씩 뽑아서
            for(int j=0;j<i;j++){
                int[] a= new int[ea];
                for(int k =0;k<ea;k++){
                    a[k]= arr[k*i+j];  //gap만큼 배열의 크기 전까지 새로운 배열에 담아 이를 삽입정렬을 통해 정렬한다.
                }                      //이때 j를 더해주는 것은 gap의 개수만큼 새로운 배열이 만들어지고 인덱스 하나씩 늘려가기 때문에 j를 더해줘야 한다.
                insert_sort(a);
                for(int k =0;k<ea;k++){
                    arr[k*i+j]= a[k]; //정렬된 내용을 다시 원래 빼낸 곳에 새롭게 집어넣는다.
                }
            }
//            printdata(arr); //gap의 크기가 변화될 때 마다, 정렬된 내용을 보여주기 위해 출력함수를 넣었다.
        }

    }



    private static void printdata(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] argv) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[8];
        for(int i=0;i<arr.length;i++){  // 69 10 30 2 16 8 31 22 입력
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long start = System.currentTimeMillis(); //속도측정 시작지점
        insert_sort(arr);
        printdata(arr);
        long end = System.currentTimeMillis();//속도측정 종료 지점


        long time1 = end - start; //측정한 시점의 차를 통해 소요된 시간 계산 1
        int[] a = new int[8]; // 69 10 30 2 16 8 31 22 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        start= System.currentTimeMillis();
        shell_sort(a);
        printdata(a);
        end = System.currentTimeMillis();

        long time2 = end - start; //측정한 시점의 차를 통해 소요된 시간 계산

        System.out.println("insert정렬 시간: "+time1);
        System.out.println("shell정렬 시간: "+time2);
        System.out.println(time2-time1);
        if(time1<time2){
            System.out.println("insert가 "+time2/time1*100+"% 더  빠르다.");
        }
        else{
            System.out.println("shell이 "+time1/time2*100+"% 더 빠르다.");
        }
    }
}
