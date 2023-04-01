import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    int xor = a ^ b;

    int ans = 0;

    while(xor != 0){
      xor &= (xor - 1);
      ans++;
    }
    System.out.println(ans);
  }

}