import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int[] best = new int[n + 1];
        for (int k = 1; k <= n; ++k) {
            best[k] = best[k - 1] + 1;
            for (int x = 0; x < k - 1; x++)
                best[k] = Math.max(best[k], best[x] * (k-x-1));
        }
        return best[n];
	}

}