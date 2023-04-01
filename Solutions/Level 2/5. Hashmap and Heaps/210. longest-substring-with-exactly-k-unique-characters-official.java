import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

	public static int solution(String str, int k){
	    int maxLen = -1;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0, j = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			if (map.size() == k) {
				maxLen = Math.max(maxLen, i - j + 1);
			} else {
				while (map.size() > k) {
					char l = str.charAt(j);
					int count = map.get(l);
					if (count == 1) {
						map.remove(l);
					} else {
						map.put(l, map.get(l) - 1);
					}
					j++;
				}
			}
		}
		return maxLen;
	}

}