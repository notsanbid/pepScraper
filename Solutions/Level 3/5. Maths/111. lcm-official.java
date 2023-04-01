import java.util.HashSet;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long b = sc.nextLong();

    HashSet<Long> factor = new HashSet<>();

    for (long i = 1; i * i <= b; i++) {
      if (b % i == 0) {
        factor.add(i);
        factor.add(b / i);
      }
    }

    System.out.println(factor.size());
  }
}