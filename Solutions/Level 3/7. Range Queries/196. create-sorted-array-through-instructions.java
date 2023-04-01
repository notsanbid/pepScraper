import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] farr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] st = br.readLine().split(" ");

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st[i]);
		}
		System.out.println(createSortedArray(arr));
	}

	public static int createSortedArray(int[] A) {
		int res = 0, n = A.length;
		farr = new int[100001];
		for (int i = 0; i < n; ++i) {
			res = res + Math.min(get(A[i] - 1), i - get(A[i]));
			update(A[i]);
		}
		return res;
	}

	public static void update(int x) {
		while (x < 100001) {
			farr[x]++;
			x += x & -x;
		}
	}

	public static int get(int x) {
		int res = 0;
		while (x > 0) {
			res += farr[x];
			x -= x & -x;
		}
		return res;
	}
}