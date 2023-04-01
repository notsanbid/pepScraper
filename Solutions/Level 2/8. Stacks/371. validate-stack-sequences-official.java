import java.io.*;
import java.util.*;

public class Main {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        
        int i=0;
        int j=0;
        
        while(j<popped.length){
            if(st.size() > 0 && st.peek() == popped[j]){
                j++;
                st.pop();
            }else{
                if(i<pushed.length){
                    st.push(pushed[i++]);
                }else{
                    return false;
                }
            }
        }
        
        return true;
    }

    public static int[] getArr(String s){
        String nums[] = s.split(" ");
        int n = nums.length;
        int ar[] = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = Integer.parseInt(nums[i]);
        }
        return ar;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int pushed [] = getArr(read.readLine());
        int popped [] = getArr(read.readLine());
        
        boolean result = validateStackSequences(pushed, popped);

        System.out.println(result);
    }
}