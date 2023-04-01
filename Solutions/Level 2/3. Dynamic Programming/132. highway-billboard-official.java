import java.util.Scanner;
public class Main{
    public static int solution(int m , int[] x, int[] rev, int t) {
		int[] dp = new int[m + 1];
		int j = 0;
		for(int i = 1; i <= m; i++) {
            // System.out.println(i+"  "+j);
			if( j < x.length && x[j] == i) {
				dp[i] = Math.max(dp[i - 1],(i - t - 1 >= 0 ? dp[i - t - 1] : 0) + rev[j]);
				j++;
			}else {
				dp[i] = dp[ i - 1];
			}
        }
        return dp[m];
    }
    public static void input(int []arr,Scanner scn){
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);   
        int m = scn.nextInt();
        int n = scn.nextInt();
        
        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue,scn);

        int t = scn.nextInt();

        System.out.println(solution(m, x, revenue, t));
        scn.close();
    }
}