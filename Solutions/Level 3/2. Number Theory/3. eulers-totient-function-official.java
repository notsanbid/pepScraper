import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(euler(n));
	}

	public static int euler(int n) {
		int count = n;
		for (int i = 2; i * i <= n; i++) {

			if (n % i == 0) {
				while (n % i == 0) {
					n = n / i;
				}
				count = count - count / i;
			}
		}

		if (n > 1) {
			count = count - count / n;
		}

		return count;
	}
}