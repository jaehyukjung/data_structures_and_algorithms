import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    static int[] arr;

    public static void seqSearch2(int key, int high){
        int i;

        arr[high+1] = key;
        for(i = 0; arr[i] != key ; i++) ;

        if(i == (high + 1)) System.out.println("실패");
        else System.out.println("성공 : "+(i+1)+"번째에 존재.");
    }

    public static void main(String[] argv) throws IOException{
        Random rand = new Random();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[rand.nextInt(100)+1];
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
        seqSearch2(key,arr.length-2);



        //과제 2
        int[] arr2 ={0,4,6,8,3,5,2,77,95,12,36,54,78,68,94,11,18,17,10,32};

        sort(arr2,0,arr2.length-1);
        printdata(arr2);
        binsearch(arr2,36);
    }


    public static int binsearch(int arr[],int target){
        int start =0;
        int end = arr.length-1;
        int mid =(start+end)/2;
        while(end-start>= 0){
            if(arr[mid]== target){
                System.out.println("탐색성공 : "+mid+"번째 인덱스");
                return mid;
            }
            else if(arr[mid]<= target){
                start= mid+1;
            }
            else{
                end= mid-1;
            }
            System.out.println("현재 탐색 비교 값: "+arr[mid]);
            mid= (end+start)/2;
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
    private static void printdata(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
