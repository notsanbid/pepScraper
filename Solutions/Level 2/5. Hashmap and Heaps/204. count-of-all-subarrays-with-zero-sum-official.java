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

	public static int solution(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int psum = 0;
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			psum += arr[i];
			if (map.containsKey(psum)) {
				ans += map.get(psum);
			}
			map.put(psum, map.getOrDefault(psum, 0) + 1);
		}
		return ans;
	}

}