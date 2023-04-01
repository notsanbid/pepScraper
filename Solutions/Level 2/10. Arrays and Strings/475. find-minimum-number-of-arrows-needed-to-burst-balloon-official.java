import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static int minArrows(int coordinates[][]) {
    Arrays.sort(coordinates, (a, b) -> Integer.compare(a[1], b[1]));

    int end = coordinates[0][1], arrow = 1;

    for (int i = 1; i < coordinates.length ; i++) {
      if (coordinates[i][0] > end) {
        end = coordinates[i][1];
        arrow++;
      }
    }

    return arrow;
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt(); // number of balloons
    int coordinates[][] = new int[n][2];
    for (int i = 0 ; i < n ; i++) {
      coordinates[i][0] = scn.nextInt();
      coordinates[i][1] = scn.nextInt();
    }

    System.out.println(minArrows(coordinates));
  }
}