import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int mostWater(int[] height) {
        // write your code here
        int i = 0;
        int j = height.length - 1;
        
        int mostWater = 0;
        while(i < j) {
            int base = j - i;
            int h1 = height[i];
            int h2 = height[j];
            int water = base * Math.min(h1, h2);;
            if(water > mostWater) {
                mostWater = water;
            }
            if(h1 == h2) {
                i++;
                j--;
            } else if(h1 > h2) {
                j--;
            } else {
                i++;
            }
        }
        
        return mostWater;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        // Write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] heights = new int[n];
        for(int i = 0; i < n; i++) {
            heights[i] = scn.nextInt();
        }

        int res = mostWater(heights);
        System.out.println(res);
    }
}