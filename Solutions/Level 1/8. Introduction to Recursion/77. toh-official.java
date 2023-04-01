import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int n1 = Integer.parseInt(br.readLine());
    int n2 = Integer.parseInt(br.readLine());
    int n3 = Integer.parseInt(br.readLine());

    toh(n, n1, n2, n3);
  }

  public static void toh(int n, int t1id, int t2id, int t3id){
    if(n == 0){
      return;
    }
    
    toh(n - 1, t1id, t3id, t2id);
    System.out.println(n + "[" + t1id + " -> " + t2id + "]");
    toh(n - 1, t3id, t2id, t1id);
  }

}