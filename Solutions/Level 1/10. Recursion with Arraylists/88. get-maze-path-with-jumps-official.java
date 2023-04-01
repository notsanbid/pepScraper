import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<String> paths = getMazePaths(0, 0, n - 1, m - 1);
        System.out.println(paths);
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr > dr || sc > dc){
            return new ArrayList<>();
        }

        if(sr == dr && sc == dc){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> paths = new ArrayList<>();
        for(int move = 1; move <= dc - sc; move++){
            ArrayList<String> hpaths = getMazePaths(sr, sc + move, dr, dc);
            for(String hpath: hpaths){
                paths.add("h" + move + hpath);
            }
        }
        
        for(int move = 1; move <= dr - sr; move++){
            ArrayList<String> vpaths = getMazePaths(sr + move, sc, dr, dc);
            for(String vpath: vpaths){
                paths.add("v" + move + vpath);
            }
        }

        for(int move = 1; move <= dc - sc && move <= dr - sr; move++){
            ArrayList<String> dpaths = getMazePaths(sr + move, sc + move, dr, dc);
            for(String dpath: dpaths){
                paths.add("d" + move + dpath);
            }
        }

        return paths;
    }
}