import java.io.*;
import java.util.*;

public class Main {
    public static String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        char chs[] = s.toCharArray();
        
        for(int i=0;i<chs.length;i++){
            char ch= chs[i];
            
            if(ch==')'){
                if(st.size()>0){
                    st.pop();
                }else{
                    chs[i] = '.';
                }
            }else if(ch=='('){
                st.push(i);
            }
        }
        
        while(st.size() > 0){
            chs[st.pop()] = '.';
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c:chs){
            if(c!='.'){
                sb.append(c);
            }
        }
        
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = reverseParentheses(read.readLine());
        System.out.println(result);
        
    }
}