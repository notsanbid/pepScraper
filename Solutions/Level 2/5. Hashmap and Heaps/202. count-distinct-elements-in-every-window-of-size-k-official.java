import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
	}

	public static ArrayList<Integer> solution(int[] arr, int k) {
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int i;
		for( i = 0 ;i < k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		System.out.print(map.size() + " ");
		if(map.get(arr[0]) == 1) {
			map.remove(arr[0]);
		}else {
			map.put(arr[0], map.get(arr[0]) - 1);
		}
		
		for(int start = 1; i < arr.length ;i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			ans.add(map.size());
			if(map.get(arr[start]) == 1) {
				map.remove(arr[start]);
			}else {
				map.put(arr[start], map.get(arr[start]) - 1);
			}
			start++;
		}
		return ans;
	}

}