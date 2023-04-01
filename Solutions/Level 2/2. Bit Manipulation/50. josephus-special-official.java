import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(solution(n));
  }

  public static int solution(int n){
    int x = nearestPowerOf2(n);
    int l = n - x;
    return (2*l) + 1;
  }

  public static int nearestPowerOf2(int n){
    int ans = 0;
    while((1 << ans) <= n){
      ans++;
    }
    return 1 << (ans - 1);
  }
  

}