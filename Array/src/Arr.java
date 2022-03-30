import java.util.NoSuchElementException;

public class Arr {
    int arr[]; //배열 선언
    int count; //배열 내부에 데이터 개수
    int size; // 배열의 크기

    Arr(){  // 기본선언은 개수와 배열의 크기가 모두 0으로 시작
        count =0;
        size =0;
        arr =new int[size];
    }

    void Arr_add(int num){
        if(size==0)  { //처음 크기는 0이기 때문에 곱하기를 못한다. 따라서 +1을 해주는 형태
            size += 1;
            arr = new int[size];
        }
        else if(count >= size){ //그게 아니라 데이터를 넣으려고 할 때 기존의 데이터를 임시 배열에 저장하고 배열의 크기를 2배로 늘린후 다시 저장하기.
            size *=2; // 사이즈를 두배로 바꿔줌.(오버플로우를 고려)
            int temp[] =new int[count+1]; //임시배열
            for(int i=0;i<count;i++){
                temp[i] = arr[i];
            }
            arr =new int[size];
            for(int i=0;i<count;i++){
                arr[i] = temp[i];
            }
            temp =null;
        }
        arr[count++] = num;
    }

    void Arr_insert(int place, int num){ //add와 동일한 방식으로 접근하지만 한칸씩 옆으로 밀고 저장. 이때 중요한 건 배열의 가장 끝부분부터 순차적으로 옮겨야 함.

        if(size==0)  {
            size += 1;
            arr = new int[size];
        }
        else if(count >= size){
            size *=2;
            int temp[] =new int[count+1];
            for(int i=0;i<count;i++){
                temp[i] = arr[i];
            }
            arr =new int[size];
            for(int i=0;i<count;i++){
                arr[i] = temp[i];
            }
            temp =null;
        }

        if(place <0 || place >count){
            throw new NoSuchElementException();
        }
        for(int i=count;i>place;i--){
            arr[i]=arr[i-1];
        }
        arr[place]=num;
        count++;
    }
    void Arr_remove(int place){
        for(int i=place;i<count-1;i++){
            arr[i] =arr[i+1];
        }
        arr[count-1] = 0; //삭제를 하고 한칸씩 당겨 갔으므로 배열의 데이터 개수의 크기자리를 0으로 설정. 즉 빈데이터를 표시.
        count--;
        if(count <=0.25*size) { //데이터 삭제시 배열의 언더플로우를 고려해 데이터 개수가 배열 크기의 25% 이하로 떨어지면 임시배열을 이용해 배열의 크기를 반으로 줄인다.
            size /=2;
            int temp[] =new int[count+1];
            for(int i=0;i<count;i++){
                temp[i] = arr[i];
            }
            arr =new int[size];
            for(int i=0;i<count;i++){
                arr[i] = temp[i];
            }
            temp =null;
        }
    }

    public int getSize()
    {
        return count;
    }

    int getArr(int place){
        if(place <0 || place >count-1){
            throw new NoSuchElementException();
        }
//        else System.out.println(place+"위치의 값: "+arr[place]);
        else return arr[place];
}

}
