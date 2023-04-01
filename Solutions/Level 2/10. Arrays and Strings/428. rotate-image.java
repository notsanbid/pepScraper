import java.util.*;

public class Main {

  // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~~
  public static void transpose(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
  }

  public static void reverseRow(int[][] matrix) {
    for (int r = 0; r < matrix.length; r++) {
      int left = 0;
      int right = matrix.length - 1;

      while (left < right) {
        int temp = matrix[r][left];
        matrix[r][left] = matrix[r][right];
        matrix[r][right] = temp;

        left++;
        right--;
      }
    }
  }

  public static void rotate(int[][] matrix) {
    transpose(matrix);
    reverseRow(matrix);
  }

  // ~~~~~~~~~~~Input Management~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[][] matrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = scn.nextInt();
      }
    }
    rotate(matrix);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}