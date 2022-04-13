import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    public static void main(String[] argv) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        //실습과제1번
        stack st = new stack();
        String str = br.readLine(); // A+B*(C+D-E)/(F+G) 를 입력.

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch !='+' && ch!= '-' && ch!='*' && ch!='/' && ch !='(' && ch!= ')'){
                sb.append(ch);
            }
            else if(ch =='(') {
                st.push(ch);
                st.showStack();
                while(true){
                    ch = str.charAt(++i);
                    if(ch == '*' || ch =='/'){
                        while(true){
                            if(st.peek().equals('+') || st.peek().equals('-') || st.peek().equals('*') || st.peek().equals('/')) sb.append(st.pop());
                            else {
                                st.push(ch);
                                st.showStack();
                                break;
                            }
                        }
                    }
                    else if(ch == '+' || ch =='-'){
                        while(true){
                            if(st.peek().equals('+') || st.peek().equals('-')) sb.append(st.pop());
                            else {
                                st.push(ch);
                                st.showStack();
                                break;
                            }
                        }
                    }
                    else if(ch == ')') {
                        while(!st.peek().equals('(')) sb.append(st.pop());
                        st.pop();
                        st.showStack();
                        break;
                    }
                    else sb.append(ch);
                }
            }

            else st.push(ch);
            st.showStack();
        }
        int N = st.size();
        for(int i=0;i<N+1;i++){
            sb.append(st.pop());
            st.showStack();
        }
        System.out.println(sb);



        //실습과제 2
        st = new stack();
        String ch = "1";
        while(ch !="0"){
            ch = sc.next();
            if(ch.equals("0")) { //반복문을 종료하기 위한 조건.
                System.out.println(st.pop()); //마지막에 있는거 출력하고 종료
                break;
            }
            if(ch.equals("/")){
                int num1 = Integer.valueOf(Objects.toString(st.pop())) ; //실제 계산을 위해 E 형식을 String으로 변환후 이를 다시 Integer로 변호나
                int num2 = Integer.valueOf(Objects.toString(st.pop())) ;
                st.push(num2/num1); //먼저 들어간 num2가 앞에 나오도록 계산.
            }
            else if(ch.equals("*")){
                int num1 = Integer.valueOf(Objects.toString(st.pop())) ;
                int num2 = Integer.valueOf(Objects.toString(st.pop())) ;
                st.push(num2*num1);
            }
            else if(ch.equals("+")){
                int num1 = Integer.valueOf(Objects.toString(st.pop())) ;
                int num2 = Integer.valueOf(Objects.toString(st.pop())) ;
                st.push(num2+num1);
            }
            else if(ch.equals("-")){
                int num1 = Integer.valueOf(Objects.toString(st.pop())) ;
                int num2 = Integer.valueOf(Objects.toString(st.pop())) ;
                st.push(num2-num1);
            }
            else {
                st.push(ch);
            }


            st.showStack(); //하나 진행될때 마다 stack 보여주기.
        }

    }
}
