import java.util.*;

public class four {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int t = scn.nextInt();
    while (t-- > 0) {
      int step = 1;
      int x = scn.nextInt();
      while (step * (step + 1) / 2 < x) step++;
      int diff = step * (step + 1) / 2 - x;
      if (diff == 1) step++;
      System.out.println(step);
    }
  }
}