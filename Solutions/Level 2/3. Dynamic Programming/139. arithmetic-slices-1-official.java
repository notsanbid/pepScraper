import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

	public static int solution(int[] A) {
        int ans=0;
 	 	 
 	 	 // to store the count of slices including the element i in the last
 	 	 int[] dp=new int[A.length];
 	 	 for (int i = 2; i < A.length; i++) {
 	 	 	 if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
 	 	 	 	 // new count will be 1 more due to A[i-2],A[i-1],A[i]
 	 	 	 	 dp[i]=dp[i-1]+1;
 	 	 	 	 ans+=dp[i];
 	 	 	 }
 	 	 }
 	 	 return ans;
    }

}