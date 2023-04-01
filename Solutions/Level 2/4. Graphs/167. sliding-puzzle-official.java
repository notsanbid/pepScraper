import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[][] arr = new int[2][3];

    for (int i = 0; i < 2; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < 3; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(slidingPuzzle(arr));
  }

  public static int slidingPuzzle(int[][] board) {
    String target = "123450";
    String start = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        start += board[i][j];
      }
    }
    HashSet<String> visited = new HashSet<>();
    int[][] dirs = new int[][] { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
    Queue<String> queue = new LinkedList<>();
    queue.offer(start);
    visited.add(start);
    int res = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String cur = queue.poll();
        if (cur.equals(target)) {
          return res;
        }
        int zero = cur.indexOf('0');
        for (int dir : dirs[zero]) {
          String next = swap(cur, zero, dir);
          if (visited.contains(next)) {
            continue;
          }
          visited.add(next);
          queue.offer(next);

        }
      }
      res++;
    }
    return -1;
  }

  private static String swap(String str, int i, int j) {
    StringBuilder sb = new StringBuilder(str);
    sb.setCharAt(i, str.charAt(j));
    sb.setCharAt(j, str.charAt(i));
    return sb.toString();
  }
}