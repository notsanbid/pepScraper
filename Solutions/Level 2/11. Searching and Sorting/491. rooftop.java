import java.util.*;

public class Main {

    public static int findMaxSteps(int[]arr) {
        //write your code here
        int ans = 0;
        int count = 0;
        
        for(int i=0; i < arr.length-1;i++) {
            if(arr[i] < arr[i+1]) {
                count++;
            }
            else {
                ans = Math.max(ans,count);
                count = 0;
            }
        }
        
        ans = Math.max(ans,count);
        return ans;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findMaxSteps(arr);
        System.out.println(ans);
    }
}