import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k) - solution(str,k-1));
	}

	public static int solution(String str, int K){
	    int j = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.getOrDefault(ch, 0) == 0) K--;
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (K < 0) {
                char chj = str.charAt(j);
                map.put(chj, map.get(chj) - 1);
                if (map.get(chj) == 0) K++;
                j++;
            }
            res += i - j + 1;
        }
        return res;
	}

}