import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

	public static int solution(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int max_length = 0;

		int[] prefixarr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				prefixarr[i] = arr[i];
			} else {
				prefixarr[i] = arr[i] + prefixarr[i - 1];
			}
			if (!map.containsKey(prefixarr[i])) {
				map.put(prefixarr[i], i);
			} else {
				max_length = Math.max(max_length, i - map.get(prefixarr[i]));
			}
		}

		return max_length;
	}

}