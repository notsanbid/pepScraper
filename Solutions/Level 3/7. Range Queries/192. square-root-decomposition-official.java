import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] st = br.readLine().split(" ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st[i]);
		}
		int len = (int) Math.ceil(Math.sqrt(arr.length));
		int[] sqrt = preprocess(arr, len);
		int q = Integer.parseInt(br.readLine());

		for (int i = 0; i < q; i++) {
			String[] st1 = br.readLine().split(" ");
			int l = Integer.parseInt(st1[0]);
			int r = Integer.parseInt(st1[1]);

			int val = Integer.MAX_VALUE;
			while (l <= r) {
				if (l % len == 0 && l + len - 1 <= r) {
					val = Math.min(val, sqrt[l / len]);
					l += len;
				} else {
					val = Math.min(val, arr[l]);
					l++;
				}
			}
			System.out.println(val);
		}
	}

	public static int[] preprocess(int[] arr, int len) {

		int[] sqrt = new int[len];
		Arrays.fill(sqrt, Integer.MAX_VALUE);

		for (int i = 0; i < arr.length; i++) {
			sqrt[i / len] = Math.min(sqrt[i / len], arr[i]);
		}
		return sqrt;
	}
}