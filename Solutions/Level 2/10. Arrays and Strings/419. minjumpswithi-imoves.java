import java.util.*;

public class Main {
    // ~~~~~~~~~~~~User Section~~~~~~~~~~~
    public static int minJumps(int x) {
        int sum = 0;
        int i = 1;
        while(sum < x) {
            sum += i;
            i++;
        }

        if(sum == x) {
            return i - 1;
        } else if((sum - x) % 2 == 0) {
            return i - 1;
        } else if((sum + i - x) % 2 == 0) {
                return i;
        } else {
            return i + 1;
        }
    }

    //~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();

        int jumps = minJumps(x);
        System.out.println(jumps);
    }
}