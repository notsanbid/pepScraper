import java.io.*;
import java.util.*;

public class Main {
    public static int[] nextGreaterElementII(int[] nums) {
        Stack<Integer> st = new Stack<>();
        
        int n = nums.length;
        int ans[] = new int[n];
        
        for(int i=n-1;i>=0;i--){
            
            while(st.size()>0&&nums[i]>st.peek())
                st.pop();
            st.push(nums[i]);
        }
        
        for(int i=n-1;i>=0;i--){
            while(st.size()>0&&st.peek()<=nums[i])st.pop();
            
            if(st.isEmpty())
                ans[i] = -1;
            else ans[i] = st.peek();
            
            st.add(nums[i]);
        }
        return ans;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int nums[] = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(read.readLine());
        }
        
        int ans[] = nextGreaterElementII(nums);

        n = ans.length;

        System.out.println(n);
        for(int e: ans){
            System.out.println(e);
        }
        
    }
}