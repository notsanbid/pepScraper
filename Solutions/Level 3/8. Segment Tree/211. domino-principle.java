import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static PrintWriter out = new PrintWriter(System.out);
  /*
  use in for reading input
  use out for printing output
  */
  
  static class Pair{
        int minX;
        int maxX;
        int maxI;
        Pair(int minx, int maxx, int maxi){
            minX = minx;
            maxX = maxx;
            maxI = maxi;
        }
  }

    static Pair[]tree;
    static int sorted[][];
    static int arrToTree[];
    
    static void build(int node, int start, int end){
        if(start == end){
            tree[node] = new Pair(sorted[start][0], sorted[start][0], start);
            arrToTree[start] = node;
        }else{
            int mid = (start+end)/2;
            build(node*2, start, mid);
            build(node*2+1, mid+1, end);
            Pair l = tree[node*2];
            Pair r = tree[node*2+1];
            tree[node] = new Pair(l.minX, r.maxX, Math.max(l.maxI, r.maxI));
        }
    }

    static int query(int node, int l, int r){
        if(tree[node].maxX < l || r < tree[node].minX)return 0;
        
        if(l <= tree[node].minX && tree[node].maxX <= r){
            return tree[node].maxI;
        }else{
            int la = query(node*2, l, r);
            int ra = query(node*2+1, l, r);
            return Math.max(la, ra);
        }
        
    }

    static void update(int node, int val){
        tree[node].maxI = val;
        
        while(node != 1){
            node = node/2;
            tree[node].maxI = Math.max(tree[node*2].maxI, tree[node*2+1].maxI);
        }
        
    }

  public static void main(String[] args) throws IOException {

    // write your code here.
    int n = Integer.parseInt(in.readLine());
    
    sorted = new int[n][];// {x, h, i}

    for(int i=0;i<n;i++){
        String inp[] = in.readLine().split(" ");// x h
        int x = Integer.parseInt(inp[0]);
        int h = Integer.parseInt(inp[1]);
        sorted[i] = new int[]{x, h, i};
    }
    Arrays.sort(sorted, (a,b) -> a[0] - b[0]);

    int last[] = new int[n];
    for(int i=0;i<n;i++)last[i] = i;
    
    tree = new Pair[4*n];
    arrToTree = new int[n];
    build(1, 0, n-1);
    
    for(int i=n-1;i>=0;i--){
        int minR = sorted[i][0];
        int maxR = sorted[i][0] + sorted[i][1] - 1;
        
        // int maxI = i;
        // for(int j=i;j<n;j++){
        //     if(sorted[j][0] > maxR)break;
        //     maxI = Math.max(maxI, last[j]);
        // }
        int maxI = query(1, minR, maxR);
        last[i] = maxI;
        update(arrToTree[i], maxI);
    }
    
    int ans[] = new int[n];
    for(int i=0;i<n;i++){
        int count = last[i] - i + 1;
        ans[sorted[i][2]] = count;
    }
    
    for(int val: ans){
        out.print(val+" ");
    }
    out.println();

    out.close();
  }
}