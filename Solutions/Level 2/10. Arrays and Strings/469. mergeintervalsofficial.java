import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main{
    public static int[][] mergeIntervals(int Intervals[][]){
        Arrays.sort(Intervals, (a,b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> res = new ArrayList<>();

        for(int interval[] : Intervals){
            if(res.size() == 0){
                res.add(interval);
            }else{
                int prevInterval[] = res.get(res.size()-1);
                if(interval[0] < prevInterval[1]){
                    prevInterval[1] = Math.max(prevInterval[1],interval[1]);
                }else{
                    res.add(interval);
                }
            }
        }

        return res.toArray(new int[res.size()][]);
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
        int [][]output = mergeIntervals(input);

        System.out.print("[");
        for(int arr[] : output){
            System.out.print(Arrays.toString(arr));
        }
        System.out.println("]");
    }
}