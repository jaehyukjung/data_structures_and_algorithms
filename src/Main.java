import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static void main(String[] argv) throws IOException{
        Random rand = new Random();  // 랜덤 인스턴스 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[rand.nextInt(100)+1]; //크기가 1에서 100 사이인 변수 선언
        System.out.println(arr.length);
        for (int i=0;i<arr.length-1;i++){
            arr[i] = rand.nextInt()+1;
        }
        for (int i=0;i<arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();


        int key = Integer.parseInt(br.readLine()); //찾고자 하는 값.
        arr[arr.length-1] = key;
        seqSearch(arr,key,arr.length-2); //인덱스는 0부터 시작하고 배열의 끝에는 target값이 들어있으므로 배열크기 -2만큼 설정합니다.



        //과제 2
        int[] arr2 ={0,4,6,8,3,5,2,77,95,12,36,54,78,68,94,11,18,17,10,32};

        sort(arr2,0,arr2.length-1);
        printdata(arr2);
        System.out.println("찾고자 하는 값을 입력하세요 : ");
        int num =Integer.parseInt(br.readLine());  //찾고자 하는 값을 입력해서 비교
        binsearch(arr2,num);
    }


    public static void seqSearch(int[] arr, int target, int high){  //과제1
        int i;

        arr[high+1] = target;  //배열 끝값에 target 값을 집어 넣어 for문 조건에서 받드시 종료되도록 설정
        for(i = 0; arr[i] != target ; i++) ; //이렇게 하면 기존 배열에 찾고자 하는 값이 없어도 마지막에 target을 추가해줬기때문에 배열 크기까지 간다면 반드시 종료된다.

        if(i == (high + 1)) System.out.println("실패");  //만약 high 즉 배열의 크기와 같은 값이 출력되면 찾고자 하는 값이 없으프로 실패를 출력
        //이를 위해서 i를 초기에 설정해 for문이 끝나도 값이 유지되도록 설정. 또한 i++의 조건이 있으므로 high까지 돌아도 high +1이 i에 저장되기 때문에 이렇게 설정했습니다.
        else System.out.println("성공 : "+(i+1)+"번째에 존재.");
    }


    public static int binsearch(int arr[],int target){  //과제 2 이진탐색 구현
        int start =0;
        int end = arr.length-1;
        int mid =(start+end)/2;  //인덱스 중간 값을 기준으로 비교 후
        while(end-start>= 0){
            if(arr[mid]== target){  //중간값이 찾고자 하는 값과 같다면 성공을 출력하고 mid 즉 target의 인덱스 번호를 반환하도록 한다.
                System.out.println("탐색성공 : "+mid+"번째 인덱스");
                return mid;
            }
            else if(arr[mid]<= target){ //타겟보다 값이 작다면
                start= mid+1;           //정렬된 배열의 중간보다 우측에 있으니 끝값은 그대로 두고, 시작값을 중간값보다 1큰값으로 설정한다. (인덱스기준)
            }
            else{  //타겟보다 큰경우면,
                end= mid-1;  // 정렬된 배열의 중간보다 좌측에 있으니 시작값은 그대로 두고, 끝값을 중간값보다 1 작은값으로 설정한다. (인덱스기준)
            }
            System.out.println("현재 탐색 비교 값: "+arr[mid]); //arr[mid]값과 비교하고 어떤 값과 비교했는지 보여주는 문장입니다.
            mid= (end+start)/2; // 그 후 mid값을 분기문을 통해 수정된 start와 end의 중간값으로 다시 실행한다.
        }
        System.out.println("탐색실패");
        return 0;
    }



    //과거 사용한 퀵정렬 활용.
    public static void sort(int[] a){
        sort(a,0,a.length-1);
    }
    private static void sort(int[] a,int low, int high){
        int part2 = partition(a ,low, high); //partition으로 피봇을 기준으로 다 변경했다면 재귀 호출.

        if(low<part2-1){
            sort(a,low,part2-1); //low부터 partition을 통해 return값 -1까지 다시 정렬 시작
        }
        if(part2<high){
            sort(a,part2,high); //partition을 통해 return값 -1부터 high값 까지 재귀를 통해 정렬.
        }
    }
    private static int partition(int[] a,int low, int high){
        int num =((low+high)/2);
        int pivot = a[num]; //피봇 넘버를 설정하고, 피봇 값을 선언.
        while (low<=high){
            while(a[low]<pivot) low++; // 왼쪽부터 피봇값보다 작으면 패스 아니라면 while문 종료.
            while(a[high]>pivot) high--; //오른쪽부터 피봇값보다 크면 패스 아니라면 while문 종료.
            if(low <= high) {
                swap(a ,low, high); //종료된 각각의 while문을 통해 도출된 값을 비교해 low가 high보다 작다면 즉 왼쪽에 있다면 swap을 통해 둘을 바꾼다.
                low++; //그후 low와 high을 한칸씩 피봇 근처로 옮긴 후 다시 while문으로 비교.
                high--;
            }
        }
        return low;
    }
    private static void swap(int[] a , int low, int high){ //임시변수를 통해 a[low]값과 a[high]값의 위치를 서로 변경.
        int temp = a[low];
        a[low]=a[high];
        a[high]=temp;
    }
    private static void printdata(int arr[]){  //기존에 만들어둔 배열 내부를 보여주는 함수입니다.
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
