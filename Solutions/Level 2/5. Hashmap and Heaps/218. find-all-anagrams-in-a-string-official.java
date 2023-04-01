import java.util.*;

public class Main {
	public static void findAnagrams(String s, String p) {
		int[] pfq = new int[26];
		int[] sfq = new int[26];
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int i;
		for (i = 0; i < p.length(); i++) {
			char ch = p.charAt(i);
			pfq[ch - 'a']++;
			sfq[s.charAt(i) - 'a']++;
		}
		if(isAnagrams(pfq, sfq)) {
			ans.add(0);
		}
		sfq[s.charAt(0) - 'a']--;
		int start = 1;
		for (; i < s.length(); i++) {
			char ch = s.charAt(i);
			sfq[ch - 'a']++;
			if(isAnagrams(pfq, sfq)) {
				ans.add(start);
			}
			sfq[s.charAt(start) - 'a']--;
			start++;
		}
		
        System.out.println(ans.size());
        for(int a : ans){
            System.out.print(a + " ");
        }

	}

	private static boolean isAnagrams(int[] pfq, int[] sfq) {
		for (int i = 0; i < 26; i++) {
			if (pfq[i] != sfq[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String p = scn.next();
		findAnagrams(s, p);
	}

}