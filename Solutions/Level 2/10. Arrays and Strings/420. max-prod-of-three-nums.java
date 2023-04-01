import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~
    public static int maximumProduct(int[] arr) {
        int min = (int)1e9;
        int smin = (int)1e9;
        
        int max = -(int)1e9;
        int smax = max;
        int tmax = max;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                tmax = smax;
                smax = max;
                max = arr[i];
            } else if(arr[i] > smax) {
                tmax = smax;
                smax = arr[i];
            } else if(arr[i] > tmax) {
                tmax = arr[i];
            }
            
            
            if(arr[i] < min) {
                smin = min;
                min = arr[i];
            } else if(arr[i] < smin) {
                smin = arr[i];
            }
        }
        
        return Math.max(max * smax * tmax, max * min * smin);
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int prod = maximumProduct(arr);
        System.out.println(prod);
    }
}