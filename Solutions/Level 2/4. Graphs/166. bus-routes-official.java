import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    String[] st1 = br.readLine().split(" ");
    int src = Integer.parseInt(st1[0]);
    int dest = Integer.parseInt(st1[1]);
    System.out.println(numBusesToDestination(arr, src, dest));

  }

  public static int numBusesToDestination(int[][] routes, int S, int T) {
    int n = routes.length;
    HashMap<Integer, ArrayList<Integer>> stopmap = new HashMap<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < routes[i].length; j++) {
        int busstop = routes[i][j];

        ArrayList<Integer> busno = stopmap.getOrDefault(busstop, new ArrayList<>());
        busno.add(i);
        stopmap.put(busstop, busno);
      }
    }

    LinkedList<Integer> queue = new LinkedList<>();
    HashSet<Integer> stopvis = new HashSet<>();
    HashSet<Integer> busnovis = new HashSet<>();

    queue.addLast(S);
    stopvis.add(S);
    int level = 0;
    while (queue.size() > 0) {
      int size = queue.size();
      while (size-- > 0) {
        Integer rem = queue.removeFirst();
        if (rem == T) {
          return level;
        }

        ArrayList<Integer> buses = stopmap.get(rem);
        for (int bus : buses) {
          if (busnovis.contains(bus) == true) {
            continue;
          }

          int[] arr = routes[bus];
          for (int stop : arr) {
            if (stopvis.contains(stop) == true) {
              continue;
            }
            queue.addLast(stop);
            stopvis.add(stop);
          }
          busnovis.add(bus);
        }
      }
      level++;
    }
    return -1;
  }
}