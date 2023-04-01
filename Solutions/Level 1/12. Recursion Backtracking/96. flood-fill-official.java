import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }

      floodfill(arr, 0, 0, "", new boolean[n][m]);  
   }

   public static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited){
      if(row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || 
         maze[row][col] == 1 || visited[row][col] == true){
         return;
      } else if(row == maze.length - 1 && col == maze[0].length - 1){
         System.out.println(psf);
         return;
      }

      visited[row][col] = true;
      floodfill(maze, row - 1, col, psf + "t", visited);
      floodfill(maze, row, col - 1, psf + "l", visited);
      floodfill(maze, row + 1, col, psf + "d", visited);
      floodfill(maze, row, col + 1, psf + "r", visited);
      visited[row][col] = false;
   }

}