import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

	private static int solution(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0 ;i < arr.length ;i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		
		ArrayList<Integer> keys = new ArrayList<Integer>(map.keySet());
		ArrayList<Integer> values = new ArrayList<Integer>(map.values());
		int ans = 0;
		for(int i = 0 ;i < keys.size() ; i++) {
			int key = keys.get(i);
			int val = values.get(i);
			if(key >= val) {
				ans += (key + 1);
			}else {
				if(val % (key + 1) == 0) {
					ans += ((val / (key + 1)) * (key + 1));
				}else {
					ans += (((val / (key + 1)) + 1) * (key + 1));
				}
			}
		}
		
		return ans;
	}

}