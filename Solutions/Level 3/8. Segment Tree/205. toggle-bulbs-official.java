import java.io.*;
import java.util.*;

public class Main {


    static int []tree;
    static boolean []lazyT;
    
    static void propagate(int node,int start, int end){
        if(lazyT[node] == false)return;
        if(start == end){
            if(tree[node] == 0)tree[node] = 1;
            else tree[node] = 0;
        }else{
            int count = (end-start+1);
            tree[node] = count - tree[node];
            lazyT[node*2] = !lazyT[node*2];
            lazyT[node*2+1] = !lazyT[node*2+1];
        }
        lazyT[node] = false;
    }
    
    static void update(int node, int start, int end, int l, int r){
        propagate(node, start, end);
        if(end < l || r < start)return;
        
        if(start == end){
            if(tree[node] == 0)tree[node] = 1;
            else tree[node] = 0;
        }else if( l <= start && end <= r ){
            lazyT[node] = !lazyT[node];
            propagate(node, start, end);
        }else{
            int mid = (start+end)/2;
            update(node*2, start, mid, l, r);
            update(node*2+1, mid+1, end, l, r);
            tree[node] = tree[node*2] + tree[node*2+1];
        }
        
    }
    
    static int query(int node, int start, int end, int l, int r){
        if(end < l || r < start)return 0;
        propagate(node, start, end);
        
        if(start == end){
            return tree[node];
        }else if( l <= start && end <= r ){
            return tree[node];
        }else{
            int mid = (start+end)/2;
            return query(node*2, start, mid, l, r) + query(node*2+1, mid+1, end, l, r);
        }
    }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    String inps[] = read.readLine().split(" ");
    int n = Integer.parseInt(inps[0]);
    int q = Integer.parseInt(inps[1]);

    // write your code here
    tree = new int[n*4];
    lazyT = new boolean[4*n];
    
    while(q-- > 0){
        String in[] = read.readLine().split(" ");
        int t = Integer.parseInt(in[0]);
        int a = Integer.parseInt(in[1]);
        int b = Integer.parseInt(in[2]);
        
        if(t == 1){
            // toggle a -- b
            update(1, 1, n, a, b);
        }else{
            int ans = query(1, 1, n, a, b);
            System.out.println(ans);
        }
    }

  }

}