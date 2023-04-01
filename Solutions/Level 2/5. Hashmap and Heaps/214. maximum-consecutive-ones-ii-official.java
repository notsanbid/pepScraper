import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr,k));
	}

	public static int solution(int[] arr, int k){
        int zeroes = 0;
        int ans = 1;
        for(int i = 0 ,j = 0 ;i < arr.length; i++){
            if(arr[i] == 0){
                zeroes++;
                while(zeroes > k){
                    if(arr[j] == 0){
                        zeroes--;
                    }
                    j++;
                }
            }
            ans = Math.max(ans,i - j + 1);
        }
        return ans;
    }

}