import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
        int k = scn.nextInt();
        
		Pair ans = euclids(a, b);
        ans.x *= k;
        ans.y *= k;

		System.out.println(ans.x + " " + ans.y);
	}

    public static class Pair {
		long x;
		long y;
		long gcd;

		public Pair(long x, long y, long gcd) {
			this.x = x;
			this.y = y;
			this.gcd = gcd;
		}
	}

	public static Pair euclids(long a, long b) {
		if (b == 0) {
			return new Pair(1, 0, a);
		}
		Pair dash = euclids(b, a % b);

		return new Pair(dash.y, dash.x - ((a / b) * dash.y), dash.gcd);
	}
}