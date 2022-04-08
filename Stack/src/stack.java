import java.util.NoSuchElementException;

public class stack<E> {
    private E arr[];
    private int top; //배열 선언
    private int size;

    public stack(){  // 기본선언은 개수와 배열의 크기가 모두 0으로 시작
        top =-1;
        size = 1;
        arr = (E[]) new Object[size];
    }


    public void push(E num){
        resize();
        arr[++top] = num;
    }

    public E pop(){
        E item = arr[top];
        arr[top--] =null;
        resize();
        return item;
    }

    public E peek(){
        if(top == -1) throw new NoSuchElementException();
        return arr[top];
    }

    public int size(){
        return top;
    }
    public void resize(){
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
        else if(top+1 <=0.25*size) { //데이터 삭제시 배열의 언더플로우를 고려해 데이터 개수가 배열 크기의 25% 이하로 떨어지면 임시배열을 이용해 배열의 크기를 반으로 줄인다.
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

}
