import java.util.*;


public class five {
  public static boolean containsAllDiv(ArrayList<Long> divs, long ans) {
    long cdiv = 2;
    ArrayList<Long> ori = new ArrayList<Long>();
    while (cdiv * cdiv <= ans) {
      if (ans % cdiv == 0) {
        ori.add(cdiv);
        if (ans / cdiv != cdiv) ori.add(ans / cdiv);
      }
      cdiv++;
    }
    // System.out.println(ori.size());
    // if(ans>1){
    //     ori.add(ans);
    // }
    // for(long x: ori) System.out.print(x + " ");
    // System.out.println();
    Collections.sort(ori);
    if (ori.size() != divs.size()) return false;
    // System.out.println("as");
    // for(int i = 0;i<divs.size();i++){
    //     // System.out.println(divs.get(i)+" = "+ori.get(i));
    //     if(divs.get(i) != ori.get(i)){
    //         return false;
    //     }
    // }
    return divs.equals(ori);
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int T = scn.nextInt();
    while (T-- > 0) {
      int n = scn.nextInt();
      ArrayList<Long> arr = new ArrayList<Long>();
      for (int i = 0; i < n; i++) {
        Long x = scn.nextLong();
        arr.add(x);
      }
      Collections.sort(arr);
      long ans = arr.get(0) * arr.get(arr.size() - 1);
      boolean bad = false;
      for (long x : arr) {
        if (ans % x > 0) {
          bad = true;
          break;
        }
      }
      // if(bad)System.out.println("asd");
      if (bad || !containsAllDiv(arr, ans)) System.out.println(-1);
      else System.out.println(ans);
    }
  }
}