import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] argv) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        stack st = new stack();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                st.push(str.charAt(i));
                for(int j=i+1;j<str.length();j++){
                    if(str.charAt(i)=='/' || str.charAt(i)=='*'){
                        System.out.print(str.charAt(j));
                        if(st.peek().equals('+')||st.peek().equals('-')){
                            System.out.print(st.pop());
                            j++;
                        }
                    }
                }
            }
            else if(str.charAt(i)=='/' || str.charAt(i)=='*'){
                st.push(str.charAt(i));
            }
            else if(str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)=='/' || str.charAt(i)=='*'){

            }


            else System.out.print(str.charAt(i));
        }


    }
}
