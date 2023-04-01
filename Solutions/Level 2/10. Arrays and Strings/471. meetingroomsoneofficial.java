import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Solution{
    public static boolean meetingRooms(int intervals[][]){
        if(intervals.length == 0 || intervals.length == 1) return true;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        
        for(int idx = 1 ; idx < intervals.length ; idx++){
            if(intervals[idx][0] < intervals[idx-1][1]){
                return false;
            }
        }
        
        return true;
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        // Input Format
        int n = scn.nextInt();
        int input[][] = new int[n][2];

        for(int i = 0 ; i <  n ; i++){
            int sp = scn.nextInt();
            int ep = scn.nextInt();

            input[i][0] = sp;
            input[i][1] = ep;
        }

        // Output Format
        boolean res = meetingRooms(input);
        System.out.println(res);
    }
}