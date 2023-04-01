import java.util.*;

public class Main {
    
    //~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
    public static String nextGreaterElement(String str) {
        char[] num = str.toCharArray();
        
        int i = num.length - 2;
        while(i >= 0 && num[i] >= num[i + 1]) {
            i--;
        }
        
        if(i >= 0) {
            int k = num.length - 1;
            while(num[k] <= num[i]) {
                k--;
            }
            char temp = num[i];
            num[i] = num[k];
            num[k] = temp;
        } else {
            return "-1";
        }
        
        String res = "";
        for(int j = 0; j <= i; j++) {
            res += num[j];
        }
        
        for(int j = num.length - 1; j > i; j--) {
            res += num[j];
        }
        
        return res;
    }

    //~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String num = scn.next();
        String res = nextGreaterElement(num);

        System.out.println(res);
    }
}