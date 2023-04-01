import java.util.*;

public class Main {

    public static int maximise(int[]arr) {
        //write your code here
        int n = arr.length;

        int sum = 0;
	    int S0 = 0;
	    for(int i=0; i < n;i++) {
	        sum += arr[i];
	        S0 += arr[i]*i;
	    }
	    
	    int max = S0;
	    int Si = S0;
	    
	    for(int i=0; i < n-1 ;i++) {
	        int temp = Si + sum - n*arr[n-i-1];
	        Si = temp;
	        
	        if(temp > max) {
	            max = temp;
	        }
	    }
	    
	    return max;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = maximise(arr);
        System.out.println(ans);
    }
}