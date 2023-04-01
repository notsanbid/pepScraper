import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String A = scn.next();
		String B = scn.next();
		System.out.print(isIsomorphic(A, B));
	}

	public static boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> map1 = new HashMap<Character, Character>();
		HashMap<Character, Character> map2 = new HashMap<Character, Character>();
		for(int i = 0 ; i < s.length() ;i++) {
			char ch1 = s.charAt(i);
			char ch2 = t.charAt(i);
			if(!map1.containsKey(ch1)) {
				map1.put(ch1, ch2);
			}else {
				if(map1.get(ch1) != ch2) {
					return false;
				}
			}
		}
		for(int i = 0 ; i < t.length() ;i++) {
			char ch1 = t.charAt(i);
			char ch2 = s.charAt(i);
			if(!map2.containsKey(ch1)) {
				map2.put(ch1, ch2);
			}else {
				if(map2.get(ch1) != ch2) {
					return false;
				}
			}
		}
		return true;
	}

}