import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] farr;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int m = Integer.parseInt(st[0]);
		int n = Integer.parseInt(st[1]);

		arr = new int[m + 1][n + 1];
		farr = new int[m + 1][n + 1];
		for (int i = 1; i < arr.length; i++) {
			st = br.readLine().split(" ");
			for (int j = 1; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(st[j - 1]);
			}
		}

		preprocess();

		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			st = br.readLine().split(" ");
			if(st[0].equals("q")){
			int x1 = Integer.parseInt(st[1]);
			int y1 = Integer.parseInt(st[2]);
			int x2 = Integer.parseInt(st[3]);
			int y2 = Integer.parseInt(st[4]);

			System.out.println(query(x1, y1, x2, y2));
		}else{
			int x1 = Integer.parseInt(st[1]);
			int y1 = Integer.parseInt(st[2]);
			int val = Integer.parseInt(st[3]);
			update(x1,y1,val);
		}
	}
}

	public static void preprocess() {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				update(i, j, arr[i][j]);
			}
		}
	}

	public static void update(int x, int y, int val) {
		int xdash = x;
		while (xdash < arr.length) {
			int ydash = y;

			while (ydash < arr[0].length) {
				farr[xdash][ydash] += val;
				ydash = ydash + (ydash & -ydash);
			}

			xdash = xdash + (xdash & -xdash);
		}
	}

	public static int query(int x1, int y1, int x2, int y2) {
		return (prefixsum(x2, y2) - prefixsum(x1 - 1, y2) - prefixsum(x2, y1 - 1) + prefixsum(x1 - 1, y1 - 1));
	}

	public static int prefixsum(int x, int y) {
		int sum = 0;

		int xdash = x;
		while (xdash > 0) {
			int ydash = y;
			while (ydash > 0) {
				sum += farr[xdash][ydash];
				ydash = ydash - (ydash & -ydash);
			}

			xdash = xdash - (xdash & -xdash);
		}
		return sum;
	}
}