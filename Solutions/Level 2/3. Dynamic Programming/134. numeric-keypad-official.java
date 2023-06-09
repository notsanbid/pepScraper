import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int n) {
		ArrayList<Integer>[] nextkeys = new ArrayList[10];
		for(int i = 0; i < 10; i++){
		    nextkeys[i] = new ArrayList<>();
		}
		
		nextkeys[0].add(0);
		nextkeys[0].add(8);
		nextkeys[1].add(1);
		nextkeys[1].add(2);
		nextkeys[1].add(4);
		nextkeys[2].add(1);
		nextkeys[2].add(2);
		nextkeys[2].add(3);
		nextkeys[2].add(5);
		nextkeys[3].add(2);
		nextkeys[3].add(3);
		nextkeys[3].add(6);
		nextkeys[4].add(1);
		nextkeys[4].add(4);
		nextkeys[4].add(5);
		nextkeys[4].add(7);
		nextkeys[5].add(2);
		nextkeys[5].add(4);
		nextkeys[5].add(5);
		nextkeys[5].add(6);
		nextkeys[5].add(8);
		nextkeys[6].add(3);
		nextkeys[6].add(5);
		nextkeys[6].add(6);
		nextkeys[6].add(9);
		nextkeys[7].add(4);
		nextkeys[7].add(7);
		nextkeys[7].add(8);
		nextkeys[8].add(0);
		nextkeys[8].add(5);
		nextkeys[8].add(7);
		nextkeys[8].add(8);
		nextkeys[8].add(9);
		nextkeys[9].add(6);
		nextkeys[9].add(8);
		nextkeys[9].add(9);
		
		int[][] dp = new int[n + 1][10];
		for(int i = 0 ; i < 10; i++){
		    dp[1][i] = 1;
		}
		
		for(int i = 2; i <= n; i++){
		    for(int j = 0; j < 10; j++){
		        for(int key = 0 ; key < nextkeys[j].size();key++){
		            dp[i][j] += dp[i - 1][nextkeys[j].get(key)]; 
		        }
		    }
		}
		
		int ans = 0;
		for(int j = 0 ; j < 10; j++){
		    ans += dp[n][j];
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println(solution(scn.nextInt()));
	}

}