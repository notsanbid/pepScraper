import java.io.*;
import java.util.*;

public class Main {

    public static void solution(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> ans = new ArrayList<>();
        int min = arr[0] ^ arr[1];
        ans.add(arr[0]);
        ans.add(arr[1]);
        for(int i = 1; i < arr.length - 1; i++){
            if((arr[i] ^ arr[i + 1]) < min){
                min = (arr[i] ^ arr[i + 1]);
                ans = new ArrayList<>();
                ans.add(arr[i]);
                ans.add(arr[i + 1]);
            }else if((arr[i] ^ arr[i + 1]) == min){
                ans.add(arr[i]);
                ans.add(arr[i + 1]);
            }
        }
        
        for(int i = 0 ; i < ans.size() - 1; i+= 2){
            System.out.println(ans.get(i) + ", " + ans.get(i + 1));
        }
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }
    
    
}