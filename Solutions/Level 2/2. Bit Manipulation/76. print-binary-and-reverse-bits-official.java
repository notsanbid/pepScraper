import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean flag = false;
    for(int i = (1 << 30); i > 0; i = i >> 1){
      if((n & i) != 0){
        System.out.print(1);
        flag = true;
      }else if(((n & i) == 0) && flag){
        System.out.print(0);
      }
    }
    System.out.println();
    int rev = 0;
    while(n > 0){
       int m = (n & 1);
       rev |= m;
       n = n >> 1;
       rev = rev << 1;
    }
    System.out.println(rev >> 1);
  }

}