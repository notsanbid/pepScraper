import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static long xpown(long x, long n, long p) {
		long res = 1;
		while (n > 0) {
			if (n % 2 != 0) {
				res = (res * x) % p;
				n--;
			} else {
				x = (x * x) % p;
				n = n / 2;
			}
		}
		return res % p;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scn = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
			int n = scn.nextInt();
			int p = scn.nextInt();

			if (n >= p) {
				System.out.println("0");
				return;
			}

			long ans = p - 1;
			for (int i = n + 1; i <= p - 1; i++) {
				ans = (ans * xpown(i, p - 2, p)) % p;
			}
			System.out.println(ans);
		}
}