import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted2(int[] arr) {
        int[] rmin = new int[arr.length + 1];
        
        int val = Integer.MAX_VALUE;
        rmin[arr.length] = val;
        for(int i = arr.length - 1; i>= 0; i--) {
            val = Math.min(val, arr[i]);
            rmin[i] = val;
        }
        
        int lmax = arr[0];
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            lmax = Math.max(lmax, arr[i]);
            
            if(lmax <= rmin[i + 1])
                count++;
        }
        
        return count;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted2(arr);
        System.out.println(res);
    }
}