import java.io.*;
import java.util.*;

public class Main {
    
    public static class Node{
        Node left;
        Node right;
        int count;
    }
    
    public static int getCount(Node root){
        return (root == null)?0: root.count;
    }
    
    final static int MAX_BIT = 14;
    
    public static int query(Node root, int high, int val, int index){
        if(root == null){
            return 0;
        }
        if(index == -1){
            return getCount(root);
        }
        
        int bitV = (val&(1<<index))>0?1:0;
        int bitH = (high&(1<<index))>0?1:0;
        
        if(bitV == 0){
            if(bitH==0){
                return query(root.left, high, val, index-1);
            }else{
                return getCount(root.left) + query(root.right, high, val, index-1);
            }
        }else{
            if(bitH == 0){
                return query(root.right, high, val, index-1);
            }else{
                return query(root.left, high, val, index-1) + getCount(root.right);
            }
        }
        
    }
    
    public static void insert(Node root, int val){
        for(int i=14;i>=0;i--){
            int mask = 1<<i;
            int bit = (val&mask)>0?1:0;
            
            if(bit == 0){
                if(root.left == null)root.left = new Node();
                root = root.left;
            }else{
                if(root.right == null)root.right = new Node();
                root = root.right;
            }
            root.count++;
        }
    }
    
    public static int countPairs(int[] nums, int low, int high) {
        
        Node root = new Node();
        
        int count=0;
        
        for(int val: nums){
            count += query(root, high, val, MAX_BIT);
            count -= query(root, low-1, val, MAX_BIT);
            insert(root, val);
        }
        
        return count;
    }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());

    int[]nums = new int[n];

    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(read.readLine());
    }
    int low = Integer.parseInt(read.readLine());
    int high = Integer.parseInt(read.readLine());

    int result = countPairs(nums, low, high);
    System.out.println(result);

  }
}