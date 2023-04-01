import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		int x = scn.nextInt();
		int y = scn.nextInt();
		System.out.println(solution(arr,x,y));
	}

	public static int solution(int[] arr, int x, int y){
		int n = arr.length;
		int[] prefixSum = new int[n + 1];
		for(int i = 1; i <= n; i++){
			prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
		}
		int xmax = prefixSum[x];
		int ymax = prefixSum[y];
		int ans = prefixSum[x + y];
		for(int i = x + y; i<= n; i++){
			xmax = Math.max(xmax, prefixSum[i - y] - prefixSum[i - (x + y)]);
			ymax = Math.max(ymax, prefixSum[i - x] - prefixSum[i - (x + y)]);
			ans = Math.max(ans, Math.max(xmax + prefixSum[i] - prefixSum[i - y], ymax + prefixSum[i] - prefixSum[i - x]));
		}
		return ans;
	}

}