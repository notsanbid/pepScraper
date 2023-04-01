import java.util.*;

public class Main {

  // ~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
  public static ArrayList<Integer> pascalRow(int r) {
    ArrayList<Integer> list = new ArrayList<>();
    int val = 1;
    for (int c = 0; c <= r; c++) {
      list.add(val);
      val = val * (r - c) / (c + 1);
    }

    return list;
  }

  // ~~~~~~~~~~~Input management~~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    ArrayList<Integer> res = pascalRow(n);
    for (int val : res) {
      System.out.print(val + " ");
    }
    System.out.println();
  }
}