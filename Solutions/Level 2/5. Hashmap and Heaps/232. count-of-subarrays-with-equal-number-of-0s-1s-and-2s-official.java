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
        int zcount = 0 ;
		int ocount = 0;
		int tcount = 0;
		int ans = 0;
		HashMap<String, Integer> map = new HashMap<>();
		map.put(0 + "*" + 0, 1);
		for(int i = 0 ; i  < arr.length ;i++) {
			if(arr[i] == 1) {
				ocount++;
			}else if(arr[i] == 0) {
				zcount++;
			}else {
				tcount++;
			}
			String s = (ocount - zcount) + "*" + (tcount - zcount);
			if(map.containsKey(s)) {
				ans += map.get(s);
				map.put(s, map.get(s) + 1);
			}else {
				map.put(s, 1);
			}
		}
		return ans;
    }

}