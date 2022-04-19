import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        Main main = new Main();
        main.moveDisk("A", "B", "C" , number);
    }


    public void moveDisk(String first, String center, String last, int number){
        //first : 원반이 있던 탑
        //center : 중간 위치 탑
        //last : 원반들을 옮길 목적지 탑
        if(number == 1){
            System.out.println(number + "을 " + first + "에서 " + last + "으로 옮긴다. ");
        } else{
            moveDisk(first, last, center, number -1); //n을 제외한 나머지것들을 center로 옮긴다.
            System.out.println(number + "을 " + first + "에서 " + last + "으로 옮긴다. "); //n을 last로 옮긴다.
            moveDisk(center,first, last,number -1);
        }
    }
}