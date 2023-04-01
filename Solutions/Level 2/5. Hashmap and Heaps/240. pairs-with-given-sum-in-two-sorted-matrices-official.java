import java.util.*;

public class Main {
    public static int solve(int[][] num1, int[][] num2, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int ans = 0;
		for(int i = 0 ; i < num1.length ;i++) {
			for(int j = 0; j < num1[0].length ;j++) {
				map.put(num1[i][j], map.getOrDefault(num1[i][j], 0) + 1);
			}
		}
		
		for(int i = 0 ;i < num2.length ;i++) {
			for(int j = 0 ;j < num2[0].length ;j++) {
				if(map.containsKey(k - num2[i][j])) {
					ans += map.get(k - num2[i][j]);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] mat1 = new int[N][N];
		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[0].length; j++) {
				mat1[i][j] = sc.nextInt();
			}
		}

		int[][] mat2 = new int[N][N];
		for (int i = 0; i < mat2.length; i++) {
			for (int j = 0; j < mat2[0].length; j++) {
				mat2[i][j] = sc.nextInt();
			}
		}
		int K = sc.nextInt();
		System.out.println(solve(mat1, mat2, K));

	}

}