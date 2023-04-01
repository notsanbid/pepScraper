import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        Item[] items = new Item[n];
        for(int i = 0; i < n; i++){
            items[i] = new Item();
            items[i].wt = wts[i];
            items[i].val = values[i];
            items[i].vwratio = items[i].val * 1.0 / items[i].wt;
        }

        Arrays.sort(items);
        double vib = 0;
        int rc = cap;

        int i = items.length - 1;
        while(i >= 0){
            if(items[i].wt <= rc){
                vib += items[i].val;
                rc -= items[i].wt;
            } else {
                vib += items[i].val * rc / items[i].wt;
                rc = 0;
                break;
            }

            i--;
        }

        System.out.println(vib);
    }

    public static class Item implements Comparable<Item> {
        int wt;
        int val;
        double vwratio;

        public int compareTo(Item o){
            if(this.vwratio == o.vwratio){
                return 0;
            } else if(this.vwratio > o.vwratio){
                return +1;
            } else {
                return -1;
            }
        }
    }
}