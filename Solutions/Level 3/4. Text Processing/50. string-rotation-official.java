import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String T = br.readLine();

		Solution(S, T);
	}

	private static void Solution(String s, String t) {
		if (s.length() != t.length()) {
			System.out.println(-1);
			return;
		}

		String fin = t + "#" + s + s;

		int[] lps = preprocess(fin);
		for (int i = t.length() + 1; i < lps.length; i++) {
			if (lps[i] == t.length()) {
				if (i == t.length() + 1 + s.length() - 1) {
					System.out.println(0);
					return;
				} else {
					System.out.println(lps.length - i - 1);
					return;
				}
			}
		}
		System.out.println(-1);
	}

	private static int[] preprocess(String p) {
		int[] lps = new int[p.length()];
		int i = 1;
		int len = 0;

		while (i < p.length()) {
			if (p.charAt(i) == p.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len > 0) {
					len = lps[len - 1];
				} else {
					i++;
				}
			}
		}
		return lps;
	}
}