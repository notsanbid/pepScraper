import java.util.*;

public class Main {
    
    //~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
    public int[] productExceptSelf(int[] arr) {
        // write your code here
        int[] left = new int[arr.length];
        
        int mul = 1;
        for(int i = 0; i < left.length; i++) {
            mul *= arr[i];
            left[i] = mul;
        }
        
        int[] res = new int[arr.length];
        mul = 1;
        for(int i = arr.length - 1; i > 0; i--) {
            res[i] = left[i - 1] * mul;
            mul *= arr[i];
        }
        res[0] = mul;
        
        return res;
    }

    //~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] res = productExceptSelf(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}