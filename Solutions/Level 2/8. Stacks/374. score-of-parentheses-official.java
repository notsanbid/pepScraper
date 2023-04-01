import java.io.*;
import java.util.*;

public class Main {
    public static int scoreOfParentheses(String S) {
        Stack<Integer> st = new Stack<>();// ( => -2 ) = -1
        
        for(int i=0;i<S.length();i++){
            int val =S.charAt(i)=='('?-2:-1;
            
            if(val == -2){
                st.push(-2);
            }else{
                int v = st.pop();
                if(v == -2){
                    st.push(1);
                }else{
                    while(st.peek() != -2){
                        v += st.pop();
                    }
                    st.pop();
                    st.push(v*2);
                }
            }
        }
        
        int ans=0;
        while(st.size() > 0)ans += st.pop();
        
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int score = scoreOfParentheses(read.readLine());
        System.out.println(score);
        
    }
}