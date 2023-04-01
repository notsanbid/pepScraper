import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    pdi(n);
  }

  public static void pdi(int n) {
    if(n == 0){
      return;
    }
    
    System.out.println(n);
    pdi(n - 1);
    System.out.println(n);
  }

}