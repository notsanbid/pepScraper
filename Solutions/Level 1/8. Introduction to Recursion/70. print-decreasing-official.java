import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    printDecreasing(n);
  }

  public static void printDecreasing(int n) {
    if(n == 0){
      return;
    }
    
    System.out.println(n);
    printDecreasing(n - 1);
  }

}