import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static int xpown(long x, long n, long p) {
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
		return (int)res;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scn = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
			int x = scn.nextInt();
			int n = scn.nextInt();

            int ans = xpown(x,n,1000000007);
			System.out.println(ans);
		}
}