import java.util.*;

public class eight {
  static boolean isPrime(long n) {
    // Corner cases
    if (n <= 1)
      return false;
    if (n <= 3)
      return true;

    // This is checked so that we can skip
    // middle five numbers in below loop
    if (n % 2 == 0 || n % 3 == 0)
      return false;

    for (int i = 5; i * i <= n; i = i + 6)
      if (n % i == 0 || n % (i + 2) == 0)
        return false;

    return true;
  }

  // Driver Program to test above function
  public static void main(String args[]) {
    Scanner scn = new Scanner(System.in);
    long n = scn.nextLong();
    if (n == 2) System.out.println(1);
    else if (n % 2 == 0) System.out.println(2);
    else if (isPrime(n))System.out.println(1);
    else if (isPrime(n - 2)) System.out.println(2);
    else System.out.println(3);

  }
}