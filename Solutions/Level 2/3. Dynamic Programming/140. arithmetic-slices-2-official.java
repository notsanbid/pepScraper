import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

	public static int solution(int[] A) {
		if (A.length < 3) {
			return 0;
		}
		int res = 0;
		HashMap<Integer, Integer>[] map = new HashMap[A.length];

		for (int i = 0; i < A.length; i++) {
			map[i] = new HashMap<>(i);

			for (int j = 0; j < i; j++) {
				long diff = (long) A[i] - A[j];
				if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE)
					continue;

				int d = (int) diff;
				int c1 = map[i].getOrDefault(d, 0);
				int c2 = map[j].getOrDefault(d, 0);
				res += c2;
				map[i].put(d, c1 + c2 + 1);
			}
		}

		return res;
	}

}