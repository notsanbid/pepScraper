import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dictionary = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			dictionary.add(scn.next());
		}
		String sentence = scn.next();
		System.out.println(solution(sentence, dictionary));
	}

	public static boolean solution(String sentence, HashSet<String> dictionary) {
		boolean[] dp = new boolean[sentence.length() + 1];
		dp[0] = true;
		for (int i = 1; i < dp.length; i++) {
			char ch = sentence.charAt(i - 1);
			if (i == 1 && dictionary.contains(ch + "")) {
				dp[i] = true;
				continue;
			}
			for (int j = i - 1; j >= 0; j--) {
				if (dp[j] == true) {
					String strtobechecked = sentence.substring(j, i);
					if (dictionary.contains(strtobechecked)) {
						dp[i] = true;
					}
				}
			}
		}

		return dp[dp.length - 1];
	}

}