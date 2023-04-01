import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();
    System.out.println(solution(n,k));
  }

  public static int solution(int n, int k){
    if(n == 1){
      return 0;
    }else{
      return (solution(n - 1, k) + k) % n;
    }
  }
  

}