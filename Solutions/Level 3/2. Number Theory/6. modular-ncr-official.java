import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		long[][] ncr = ncrcoll(5005, 5005, 1000000007);
		while (t-- > 0) {
			String[] st = br.readLine().split(" ");
			int n = Integer.parseInt(st[0]);
			int r = Integer.parseInt(st[1]);
			sb.append(ncr[n][r] + "\n");
		}

		System.out.println(sb);
	}

	static long[][] ncrcoll(int n, int k, int p) {
		long[][] arr = new long[n + 1][k + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i][0] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= i && j < arr[0].length; j++) {
				if (i == 1 && j == 1) {
					arr[i][j] = 1;
				} else {
					arr[i][j] = (arr[i - 1][j] + arr[i - 1][j - 1]) % (p);
				}
			}
		}
		return arr;
	}
}