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

			if (st1[0].equals("f")) {
				int l = Integer.parseInt(st1[1]);
				int r = Integer.parseInt(st1[2]);
				int val = 0;
				while (l <= r) {
					if (l % len == 0 && l + len - 1 <= r) {
						val += sqrt[l / len];
						l += len;
					} else {
						val += arr[l];
						l++;
					}
				}
				System.out.println(val);
			} else {
				int idx = Integer.parseInt(st1[1]);
				int delta = Integer.parseInt(st1[2]);
				arr[idx] += delta;
				sqrt[idx / len] += delta;
			}
		}
	}

	public static int[] preprocess(int[] arr, int len) {

		int[] sqrt = new int[len];

		for (int i = 0; i < arr.length; i++) {
			sqrt[i / len] += arr[i];
		}
		return sqrt;
	}


}