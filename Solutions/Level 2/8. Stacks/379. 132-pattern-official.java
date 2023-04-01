import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nums[] = new int[n];
        for(int i=0;i<n;i++)nums[i] = scn.nextInt();

        Stack<Integer> st = new Stack<>();
        
        int min[] = new int[n];
        min[0] = nums[0];
        
        for(int i=1;i<n;i++)min[i] = Math.min(min[i-1], nums[i]);
        
        boolean found = false;
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && st.peek() <= min[i])st.pop();
            if(st.size() > 0 && st.peek() < nums[i]){
                found = true;
                break;
            }
            st.push(nums[i]);
        }

        System.out.println(found);

    }
}