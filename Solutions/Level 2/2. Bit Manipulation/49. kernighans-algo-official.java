import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int ans = 0;

    while(n != 0){
      n &= (n - 1);
      ans++;
    }
    System.out.println(ans);
  }

}