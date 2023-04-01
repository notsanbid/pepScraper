import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
		solution(s1, s2);
	}

	public static void solution(String txt, String pat) {
		int[] lps = preprocess(pat);

		int i = 0;
		int j = 0;
		while (i < txt.length()) {
			if (txt.charAt(i) == pat.charAt(j)) {
				i++;
				j++;

				if (j == pat.length()) {
					System.out.println(i - j);
					j = lps[j - 1];
				}
			} else {
				if (j > 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
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