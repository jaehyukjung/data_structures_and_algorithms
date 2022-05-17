import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void insert_sort(int[] arr){
        int N = arr.length;
        for(int i=1;i<N;i++){
            for(int j =0;j<i;j++){
                if(arr[i]<arr[j]){
                    int temp = arr[i];
                    for(int k=i-1;k>=j;k--){
                        arr[k+1] =arr[k];
                    }
                    arr[j]=temp;
                }
            }
        }
    }

    public static void shell_sort(int[] arr){
        int gap = arr.length / 2;
        for (int i=gap;i>=1; i = i/2){
            int ea = arr.length/i;
            for(int j=0;j<i;j++){
                int[] a= new int[ea];
                for(int k =0;k<ea;k++){
                    a[k]= arr[k*i+j];
                }
                insert_sort(a);
                for(int k =0;k<ea;k++){
                    arr[k*i+j]= a[k];
                }
            }
            printdata(arr);
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
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        insert_sort(arr);
        printdata(arr);

        int[] a = new int[8];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        shell_sort(a);
    }
}
