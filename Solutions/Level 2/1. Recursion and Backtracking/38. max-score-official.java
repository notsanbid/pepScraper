import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int nofWords = scn.nextInt();
		String[] words = new String[nofWords];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}
		int nofLetters = scn.nextInt();
		char[] letters = new char[nofLetters];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = scn.next().charAt(0);
		}
		int[] score = new int[26];
		for (int i = 0; i < score.length; i++) {
			score[i] = scn.nextInt();
		}
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
				|| score.length == 0) {
			System.out.println(0);
			return;
		}
		int[] farr = new int[score.length];
		for (char ch : letters) {
			farr[ch - 'a']++;
		}
		System.out.println(solution2(words, farr, score, 0));

	}

	public static int solution2(String[] words, int[] farr, int[] score, int idx) {
		if (idx == words.length) {
			return 0;
		}

		int max1 = solution2(words, farr, score, idx + 1);
		int max2 = 0;

		boolean isValid = true;
		int scoreofCW = 0;
		for (char ch : words[idx].toCharArray()) {
			farr[ch - 'a']--;
			if (farr[ch - 'a'] < 0) {
				isValid = false;
			}
			scoreofCW += score[ch - 'a'];
		}
		if (isValid) {
			max2 = solution2(words, farr, score, idx + 1);
			max2 += scoreofCW;
		}
		for (char ch : words[idx].toCharArray()) {
			farr[ch - 'a']++;
		}
		return Math.max(max1, max2);
	}
}