import java.io.*;
import java.util.*;

public class Main {
    
    static int arr[][];
    static int tree[][];
    
    static void buildy(int nodex, int startx, int endx, int nodey, int starty, int endy){
        if(starty == endy){
            if(startx == endx){
                tree[nodex][nodey] = arr[startx][starty];
            }else{
                tree[nodex][nodey] = tree[nodex*2][nodey] + tree[nodex*2+1][nodey];
            }
        }else{
            int mid = (starty+endy)/2;
            buildy(nodex, startx, endx, nodey*2, starty, mid);
            buildy(nodex, startx, endx, nodey*2+1, mid+1, endy);
            tree[nodex][nodey] = tree[nodex][nodey*2] + tree[nodex][nodey*2+1];
        }
    }
    
    static void buildx(int nodex, int startx, int endx){
        if(startx == endx){
            buildy(nodex, startx, endx, 1, 1, arr[0].length-1);
        }else{
            int mid = (startx+endx)/2;
            buildx(nodex*2, startx, mid);
            buildx(nodex*2+1, mid+1, endx);
            buildy(nodex, startx, endx, 1, 1, arr[0].length-1);
        }
    }

    static void updatey(int nodex, int startx, int endx, int nodey, int starty,int  endy, int x, int y, int val){
        if(starty == endy){
            if(startx == endx){
                tree[nodex][nodey] += val;
            }else{
                tree[nodex][nodey] = tree[nodex*2][nodey] + tree[nodex*2+1][nodey];
            }
        }else{
            int mid = (starty + endy)/2;
            if(starty <= y && y <= mid){
                updatey(nodex, startx, endx, nodey*2, starty, mid, x,y,val);
            }else{
                updatey(nodex, startx, endx, nodey*2+1, mid+1, endy, x,y,val);
            }
            tree[nodex][nodey] = tree[nodex][nodey*2] + tree[nodex][nodey*2+1];
        }
    }
    
    static void updatex(int nodex, int startx, int endx, int x, int y, int val){
        if(startx == endx){
            updatey(nodex, startx, endx, 1, 1, arr[0].length-1, x, y, val);
        }else{
            int mid = (startx+endx)/2;
            if(startx <= x && x <= mid){
                updatex(nodex*2, startx, mid, x,y,val);
            }else{
                updatex(nodex*2+1, mid+1, endx, x,y,val);
            }
            updatey(nodex, startx, endx, 1, 1, arr[0].length-1, x, y, val);
        }
    }

    static int queryy(int nodex, int nodey, int starty, int endy, int y1, int y2){
        if(endy < y1 || y2 < starty)return 0;
        
        if(starty == endy){
            return tree[nodex][nodey];
        }else if(y1 <= starty && endy <= y2){
            return tree[nodex][nodey];
        }else{
            int mid = (starty+endy)/2;
            int la = queryy(nodex, nodey*2, starty, mid, y1,y2);
            int ra = queryy(nodex, nodey*2+1, mid+1, endy, y1,y2);
            return la+ra;
        }
        
    }

    static int queryx(int nodex, int startx, int endx, int x1, int x2, int y1, int y2){
        if(endx<x1 || x2 < startx)return 0;
        
        if(startx == endx){
            return queryy(nodex, 1, 1, arr[0].length-1, y1, y2);
        }else if(x1 <= startx && endx <= x2){
            return queryy(nodex, 1, 1, arr[0].length-1, y1, y2);
        }else{
            int mid = (startx+endx)/2;
            int la = queryx(nodex*2, startx, mid, x1,x2,y1,y2);
            int ra = queryx(nodex*2+1, mid+1, endx, x1,x2,y1,y2);
            return la+ra;
        }
        
    }

  public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        arr = new int[n+1][m+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        tree = new int[4*n][4*m];
        buildx(1, 1, n);
        
        int q = sc.nextInt();
        
        while(q-- > 0){
            String type = sc.next();
            if(type.equals("q")){
                int x1 = sc.nextInt();
                int y1 = sc.nextInt();
                int x2 = sc.nextInt();
                int y2 = sc.nextInt();
                int ans = queryx(1, 1, arr.length-1, x1,x2,y1,y2);
                System.out.println(ans);
            }else{
                int x = sc.nextInt();
                int y = sc.nextInt();
                int val = sc.nextInt();
                updatex(1, 1, arr.length-1, x,y,val);
            }
        }
  }
}