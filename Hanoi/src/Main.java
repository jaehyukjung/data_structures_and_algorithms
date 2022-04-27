import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        stack start= new stack<>();
        stack center =new stack<>();
        stack last = new stack<>();
        int number = scanner.nextInt();
        System.out.println(number);
        for(int i=number;i>=1;i--){
            start.push(i);
        }
        start.showStack();
        System.out.println("start : " +start);  //각 스택의 위치를 스택명 대신으로 출력.
        System.out.println("center : " +center); //이렇게 하는 이유는 각 스택이 밑에 재귀호출할 때 순서가 바뀌어 들어가기 때문에 하나의 값으로 특정하기 어렵기 때문에 위치를 선택했습니다.
        System.out.println("last : " +last);
        moveDisk hanoi =new moveDisk(start, center, last , number);
        hanoi.show();
    }


}

class moveDisk{
    private stack start;
    private stack center;
    private stack last;
    int number;

    moveDisk(stack start,stack center,stack last, int num){
        this.start = start; //start : 원반이 있던 탑 
        this.center = center; //center : 중간 위치 탑
        this.last = last; //last : 원반들을 옮길 목적지 탑
        this.number = num; //원반의 개수

        if(number == 1){
            System.out.println(number + "을 " + start + "에서 " + last + "으로 옮긴다. "); //가장 큰것부터 하나씩 last로 옮긴다.
            last.push(start.pop()); //스택에서 삭제한 값을 옮기는 옮기는 스택으로 push한다.
        }
        else{
            new moveDisk(start, last, center, number -1); //n을 제외한 나머지것들을 center로 옮긴다.
            System.out.println(number + "을 " + start + "에서 " + last + "으로 옮긴다. "); //n을 last로 옮긴다.
            last.push(start.pop());
            new moveDisk(center,start, last,number -1);
        }
    }
    void show(){
        System.out.println("각 스택의 상황");
        System.out.print("1번스택 : ");
        start.showStack();
        System.out.print("2번스택 : ");
        center.showStack();
        System.out.print("3번스택 : ");
        last.showStack();
    }

}