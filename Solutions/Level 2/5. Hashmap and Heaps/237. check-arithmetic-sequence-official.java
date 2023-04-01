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

	public static boolean solution(int[] arr) {
		if(arr.length == 1) {
			return true;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		int min =  Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0 ;i < arr.length; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
			set.add(arr[i]);
		}
		int diff = (max - min) / (arr.length - 1);
		for(int i = 0 ; i < arr.length; i++) {
			if(arr[i] == min || arr[i] == max) {
			}else {
				if(!set.contains(arr[i] - diff) || !set.contains(arr[i] + diff)) {
					return false;
				}
			}
		}
		
		return true;
	}

}