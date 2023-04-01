import java.io.*;
import java.util.*;

public class Main {
  public static int getMaximumGold_(int[][] grid, int sr, int sc, int n, int m, int[][] dir) {

    grid[sr][sc] = -grid[sr][sc];

    int maxGold = 0;
    for (int d = 0; d < 4; d++) {
      int r = sr + dir[d][0];
      int c = sc + dir[d][1];

      if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] > 0) {
        maxGold = Math.max(maxGold, getMaximumGold_(grid, r, c, n, m, dir));
      }
    }

    grid[sr][sc] = -grid[sr][sc];
    return maxGold + grid[sr][sc];

  }


  public static int getMaxGold(int[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) return 0;
    int n = grid.length;
    int m = grid[0].length;
    int[][] dir = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};

    int maxGold = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] != 0) maxGold = Math.max(maxGold, getMaximumGold_(grid, i, j, n, m, dir));
      }
    }
    return maxGold;
  }


  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    int[][] arr = new int[m][n];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0 ; j  < arr[0].length; j++) {
        arr[i][j] = scn.nextInt();
      }
    }
    int max = getMaxGold(arr);
    System.out.println(max);
  }

}