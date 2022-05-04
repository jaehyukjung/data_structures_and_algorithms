import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void sort(int[] a){
        sort(a,0,a.length-1);
    }
    private static void sort(int[] a,int low, int high){
        int part2 = partition(a ,low, high);
        if(low<part2-1){
            sort(a,low,part2-1);
        }
        if(part2<high){
            sort(a,part2,high);
        }
    }
    private static int partition(int[] a,int low, int high){
        int num =((low+high)/2);
        int pivot = a[num];
        while (low<=high){
            while(a[low]<pivot) low++;
            while(a[high]>pivot) high--;
            if(low <= high) {
                swap(a ,low, high);
                low++;
                high--;
            }
        }
        return low;
    }
    private static void swap(int[] a , int low, int high){
        int temp = a[low];
        a[low]=a[high];
        a[high]=temp;
    }
    private static void printsort(int[] arr){
        for(int data : arr){
            System.out.print(data+ " ");
        }
    }


    public static void main(String[] argv) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arr[]= {3,9,4,7,5,0,1,6,8,2};
        sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

