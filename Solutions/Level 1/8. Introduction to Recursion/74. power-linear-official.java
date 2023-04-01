import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());
    int n = Integer.parseInt(br.readLine());
    int p = power(x, n);
    System.out.println(p);
  }

  public static int power(int x, int n) {
    if(n == 0){
      return 1;
    }
    int xpnm1 = power(x, n - 1);
    int xpn = xpnm1 * x;
    return xpn;
  }

}