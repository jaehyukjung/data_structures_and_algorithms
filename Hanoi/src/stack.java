import java.util.NoSuchElementException;

public class stack<E> {
    private E arr[];
    private int top; //배열 선언
    private int size;

    public stack(){
        top =-1;
        size = 1;
        arr = (E[]) new Object[size];
    }


    public void push(E num){
        resize();
        arr[++top] = num; //top이 -1부터 시작하므로 먼저 +1을 해주고 그자리에 넣는다.
    }

    public E pop(){
        E item = arr[top]; //top에 있는 값을 임시변수에 저장해주고
        arr[top--] =null;  //top에 있는 데이터를 삭제한다.
        resize(); //그 후 resize를 통해 언더플로우를 계산해준다.
        return item; //임시변수에 저장된 top의 내용을 반환한다.
    }

    public E peek(){
        if(top == -1) throw new NoSuchElementException(); //top이 -1 즉 데이터가 없다면 해당 해러를 띄운다.
        return arr[top]; //그게 아니라면 top의 인덱스에 있는 값을 반환한다.
        //pop은 삭제하고 반환하지만, peek는 단순히 값만 반환하고 스택에는 영향을 미치지 않음.
    }

    public int size(){
        return top+1;
    }
    public void resize(){ //임시 배열을 만들어 저장하고 기존 배열의 크기를 재정의한다음 오버플로우와 언더플로우를 막는다.
        if(top+1 >= size){ //그게 아니라 데이터를 넣으려고 할 때 기존의 데이터를 임시 배열에 저장하고 배열의 크기를 2배로 늘린후 다시 저장하기.
            size *=2; // 사이즈를 두배로 바꿔줌.(오버플로우를 고려)
            E temp[] = (E[]) new Object[top+1]; //임시배열
            for(int i=0;i<top+1;i++){
                temp[i] = arr[i];
            }
            arr =(E[]) new Object[size];
            for(int i=0;i<top+1;i++){
                arr[i] = temp[i];
            }
            temp =null;
        }
        else if(top+1 <=0.25*size && top>0) {//데이터 삭제시 배열의 언더플로우를 고려해 데이터 개수가 배열 크기의 25% 이하로 떨어지면 임시배열을 이용해 배열의 크기를 반으로 줄인다.
            size /=2;
            E temp[] = (E[]) new Object[top+1];
            for(int i=0;i<top+1;i++){
                temp[i] = arr[i];
            }
            arr =(E[]) new Object[size];
            for(int i=0;i<top+1;i++){
                arr[i] = temp[i];
            }
            temp =null;
        }
    }
    public void showStack(){ //현재 스택의 상태를 띄어쓰기를 활용해 출력한다.
        for(int i=0;i<top+1;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}
