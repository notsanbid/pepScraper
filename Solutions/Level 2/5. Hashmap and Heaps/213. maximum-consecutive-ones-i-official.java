import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
	}

	public static int solution(int[] arr){
        int zeroes = 0;
        int ans = 1;
        for(int i = 0 ,j = 0 ;i < arr.length; i++){
            if(arr[i] == 0){
                zeroes++;
                while(zeroes > 1){
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