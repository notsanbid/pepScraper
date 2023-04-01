import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted(int[] arr) {
        int count = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            
            if(i == max) 
                count++;
        }
        return count;    
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted(arr);
        System.out.println(res);
    }
}