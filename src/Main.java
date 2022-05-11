import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
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



    public static void main(String[] argv) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arr[]= {3,9,4,7,5,0,1,6,8,2}; //샘플 자료.
        System.out.println("정렬전");
        for(int i=0;i<arr.length;i++){ //정렬전.
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        sort(arr); //정렬

        System.out.println("정렬후");

        for(int i=0;i<arr.length;i++){ //정렬 후
            System.out.print(arr[i]+" ");
        }
    }
}

