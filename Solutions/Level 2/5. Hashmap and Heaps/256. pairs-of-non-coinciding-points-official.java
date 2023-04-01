import java.io.*;
import java.util.*;

public class Main {
  public static int numOfPairs(int[] X, int[] Y, int N) {
    HashMap<Integer, Integer> xmap = new HashMap<>();
    HashMap<Integer, Integer> ymap = new HashMap<>();
    HashMap<String, Integer> xymap = new HashMap<>();

    int sum = 0;
    for (int i = 0; i < X.length; i++) {
      int x = X[i];
      int y = Y[i];
      String xy = "" + x + "*" + y;

      int xfre = xmap.getOrDefault(x, 0);
      int yfre = ymap.getOrDefault(y, 0);
      int xyfre = xymap.getOrDefault(xy, 0);

      sum += xfre + yfre - 2 * xyfre;

      xmap.put(x, xfre + 1);
      ymap.put(y, yfre + 1);
      xymap.put(xy, xyfre + 1);
    }
    return sum;
  }

  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      int N = Integer.parseInt(read.readLine());

      String S1[] = read.readLine().split(" ");
      String S2[] = read.readLine().split(" ");

      int[] X = new int[N];
      int[] Y = new int[N];

      for (int i = 0; i < N; i++)
      {
        X[i] = Integer.parseInt(S1[i]);
        Y[i] = Integer.parseInt(S2[i]);
      }

      System.out.println(numOfPairs(X, Y, N));
    }
  }
}