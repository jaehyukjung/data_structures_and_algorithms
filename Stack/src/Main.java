import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] argv) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        stack st = new stack();
        String str = br.readLine();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch !='+' && ch!= '-' && ch!='*' && ch!='/' && ch !='(' && ch!= ')'){
                System.out.print(ch);
            }
            else if(ch =='(') {
                st.push(ch);

                while(true){
                    ch = str.charAt(++i);
                    if(ch == '*' || ch =='/'){
                        while(true){
                            if(st.peek().equals('+') || st.peek().equals('-') || st.peek().equals('*') || st.peek().equals('/')) System.out.print(st.pop());
                            else {
                                st.push(ch);
                                break;
                            }
                        }
                    }
                    else if(ch == '+' || ch =='-'){
                        while(true){
                            if(st.peek().equals('+') || st.peek().equals('-')) System.out.print(st.pop());
                            else {
                                st.push(ch);
                                break;
                            }
                        }
                    }
                    else if(ch == ')') {
                        while(!st.peek().equals('(')) System.out.print(st.pop());
                        st.pop();
                        break;
                    }
                    else System.out.print(ch);
                }
            }

            else st.push(ch);
        }
        int N = st.size();
        for(int i=0;i<N+1;i++){
            System.out.print(st.pop());
        }



        //실습과제 2
        st = new stack();
        String ch = "1";
        while(ch !="0"){
            ch = sc.next();
            if(ch.equals("/")){
                int num1 = Integer.valueOf(Objects.toString(st.pop())) ;
                int num2 = Integer.valueOf(Objects.toString(st.pop())) ;
                st.push(num2/num1);
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
            if(ch.equals("0")) {
                System.out.println(st.pop());
                break;
            }

            st.showStack();
        }

    }
}
