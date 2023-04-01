import java.util.*;

public class Main {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int n = A.length;
		if (n == 0)
			return 0;

		int[] sum1 = new int[n * n];
		int[] sum2 = new int[n * n];
		int res = 0;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum1[i * n + j] = A[i] + B[j];
				map.put(sum1[i * n + j], map.getOrDefault(sum1[i * n + j], 0) + 1);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum2[i * n + j] = C[i] + D[j];
				if (map.containsKey(sum2[i * n + j] * -1)) {
					res += map.get(sum2[i * n + j] * -1);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		int[] arr3 = new int[n];
		int[] arr4 = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr2[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr3[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr4[i] = sc.nextInt();
		}
		System.out.println(fourSumCount(arr1, arr2, arr3, arr4));
	}

}