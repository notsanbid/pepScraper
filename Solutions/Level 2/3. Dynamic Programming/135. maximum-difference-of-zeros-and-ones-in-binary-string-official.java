import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

	public static int solution(String str) {
		int ans = 0;
		int currSum = 0;
		for (int i = 0; i < str.length(); i++) {
			currSum += str.charAt(i) == '0' ? 1 : -1;
			if (currSum < 0) {
				currSum = 0;
			}
			ans = Math.max(ans, currSum);
		}
		return ans == 0 ? -1 : ans;
	}

}