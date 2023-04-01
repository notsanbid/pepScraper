import java.io.*;
import java.util.*;

public class Main {
    
    static int MAX = 17;
    
    static int table[][];
    
    static void build(int p[]){
        int n = p.length;
        table = new int[MAX][n];
        for(int i=0;i<n;i++){
            table[0][i] = p[i];
        }
        
        for(int i=1;i<MAX;i++){
            for(int j=0;j<n;j++){
                table[i][j] = table[i-1][table[i-1][j]];
            }
        }
    }
    
    static int query(int a, int k){
        
        for(int i=0;i<MAX;i++){
            int mask = (1<<i);
            if((k&mask)>0){
                a = table[i][a];
            }
        }
        return a;
    }
        
  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());

    int[] parent = new int[n];

    for (int i = 0; i < n; i++) {
      parent[i] = Integer.parseInt(read.readLine());
    }
    int q = Integer.parseInt(read.readLine());
    // write your code here

    build(parent);
    
    while(q-- > 0){
        String inp[] = read.readLine().split(" ");
        int a = Integer.parseInt(inp[0]);
        int k = Integer.parseInt(inp[1]);
        
        int ans = query(a, k);
        System.out.println(ans);
    }

  }
}