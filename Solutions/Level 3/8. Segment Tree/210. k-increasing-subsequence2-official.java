import java.io.*;
import java.util.*;

public class Main {
    
    static class Pair{
        int minD;
        int maxD;
        long count[];
        Pair(int min, int max, long[]c){
            minD = min;
            maxD = max;
            count = c;
        }
    }
    
    static int sorted[][];
    static Pair tree[];
    static int k;
    static int arrToTree[];
    
    static void build(int node, int start, int end){
        
        if(start == end){
            arrToTree[sorted[start][1]] = node;
            tree[node] = new Pair(sorted[start][0], sorted[start][0], new long[k+1]);
        }else{
            int mid = (start+end)/2;
            build(node*2, start, mid);
            build(node*2+1, mid+1, end);
            Pair l = tree[node*2];
            Pair r = tree[node*2+1];
            tree[node] = new Pair(l.minD, r.maxD, new long[k+1]);
        }
        
    }

    static void sum(long la[], long []ra, long ans[]){
        for(int i=1;i<=k;i++){
            ans[i] = la[i] + ra[i];
        }
    }

    static long[] query(int node, int l, int r){
        if(tree[node].maxD < l || r < tree[node].minD)return new long[k+1];
        
        if(tree[node].minD == tree[node].maxD){
            return tree[node].count;
        }else if(l <= tree[node].minD && tree[node].maxD <= r){
            return tree[node].count;
        }else{
            long la[] = query(node*2, l, r);
            long ra[] = query(node*2+1, l, r);
            long ans[] = new long[k+1];
            sum(la, ra, ans);
            return ans;
        }
        
    }

    static void update(int node, long []ans){
        tree[node].count = ans;
        
        while(node != 1){
            node = node/2;
            sum(tree[node*2].count, tree[node*2+1].count, tree[node].count);
        }
    }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    String inp[] = read.readLine().split(" ");
    int n = Integer.parseInt(inp[0]);
    k = Integer.parseInt(inp[1]);

    int ar[] = new int[n];

    for (int i = 0; i < n; i++) {
      ar[i] = Integer.parseInt(read.readLine());
    }
    // write your code here

    // sorting
    {
        sorted = new int[n][];
        for(int i=0;i<n;i++){
            sorted[i] = new int[]{ar[i], i};
        }
        
        Arrays.sort(sorted, (a,b) -> a[0] - b[0] );
    }
    
    // tree build
    {   
        arrToTree = new int[4*n];
        tree = new Pair[4*n];
        build(1, 0, n-1);
    }  
    
    for(int i=0;i<n;i++){
        long ans[] = new long[k+1];
        if(ar[i] == 1){
            // ans = new long[k+1];
        }else{
            long []s = query(1, 1, ar[i]-1);
            for(int j=2;j<=k;j++){
                ans[j] = s[j-1];
            }
        }
        ans[1] = 1;
        update(arrToTree[i], ans);
    }
    
    long ans = tree[1].count[k];
    System.out.println(ans);

  }
}