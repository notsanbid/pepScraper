import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
            sum += arr[i];
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k, sum));
    }

    public static long solution(int[] arr, int k, long sum){
        if(k == 1){
            return kadanesForOne(arr);
        }
        if(sum > 0){
            return  kadanesForTwo(arr) + ((k - 2) * (sum));
        }else{
            return kadanesForTwo(arr);
        }
    }

    public static long kadanesForOne(int[] arr) {
        long finalans = arr[0];
        long curr = arr[0];
        for(int i = 1 ; i < arr.length; i++){
            curr = Math.max(arr[i], arr[i] + curr);
            finalans = Math.max(finalans, curr);
        }
        return finalans; 
    }

    public static long kadanesForTwo(int[] arr) {
        long finalans = arr[0];
        long curr = arr[0];
        for(int i = 1 ; i < 2 * arr.length; i++){
            curr = Math.max(arr[i % arr.length], arr[i % arr.length] + curr);
            finalans = Math.max(finalans, curr);
        }
        return finalans; 
    }
}