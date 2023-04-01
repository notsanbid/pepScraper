import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0 ; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(solution(arr));
  }

  public static boolean solution(int[] stones) {
    HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
    map.put(0, new HashSet<Integer>());
    HashSet<Integer> s = map.get(0);
    s.add(1);
    map.put(0, s);
    for (int i = 1; i < stones.length ; i++) {
      map.put(stones[i], new HashSet<Integer>());
    }

    for (int i = 0 ;  i < stones.length - 1; i++) {
      int currstone = stones[i];
      for (int step : map.get(currstone)) {
        int reachedStone = currstone + step;
        if (reachedStone == stones[stones.length - 1]) {
          return true;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        if (map.containsKey(reachedStone)) {
          set = map.get(reachedStone);
          if (step > 1) {
            set.add(step - 1);
          }
          set.add(step);
          set.add(step + 1);
        }
        map.put(reachedStone, set);
      }
    }
    return false;
  }

}