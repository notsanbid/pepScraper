import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    solution(arr);
  }

  public static void solution(int[] arr){
    int xor = 0;
    for(int i = 0 ; i < arr.length; i++){
      xor ^= arr[i];
    }
    int rsb = xor & ~(xor - 1);
    int x = 0;
    int y = 0;
    for(int i = 0 ; i < arr.length; i++){
      if((arr[i] & rsb) == 0){
        x ^= arr[i];
      }else{
        y ^= arr[i];
      }
    }
    if(x < y){
      System.out.println(x);
      System.out.println(y);
    }else{
      System.out.println(y);
      System.out.println(x);
    }
  }

}