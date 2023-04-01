import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int res = 0;
		for (int d = 2; d <= n; d++) {
			while (n % d == 0) {
				res += d;
				n /= d;
			}
		}
		return res > 0 || n == 1 ? res : n;
	}

}