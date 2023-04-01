import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String num = read.readLine();
        int k = Integer.parseInt(read.readLine());

        if(num.length() <= k){
            System.out.println("0");
            return;
        }
        
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<num.length();i++){
            while(st.size()>0 && k>0 && st.peek() > num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        
        while(st.size() > 1 && k>0){
            st.pop();
            k--;
        }
        char ans[] = new char[st.size()];
        int i=ans.length-1;
        while(i>=0)ans[i--] = st.pop();
        
        int j=0;
        while(j<ans.length-1 && ans[j] == '0')j++;
        
        System.out.println(new String(ans, j, ans.length-j));
    }
}