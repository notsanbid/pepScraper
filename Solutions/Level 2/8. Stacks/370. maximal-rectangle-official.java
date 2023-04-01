import java.io.*;
import java.util.*;

public class Main {

    public static int maximalRectangle(int[][] ar) {        
        
        int heights[] = Arrays.copyOf(ar[0], ar[0].length);

        int maxRec = largestRectangleArea(heights);
        
        int n=  ar.length;
        int m = ar[0].length;

        for(int r=1;r<n;r++){
            for(int i=0;i<m;i++){
                if(ar[r][i]==1){
                    heights[i]++;
                }else{
                    heights[i] = 0;
                }
            }
            maxRec = Math.max(maxRec, largestRectangleArea(heights));
        }
        return maxRec;
    }
    
    public static int largestRectangleArea(int[] heights) {
        
        Stack<Integer> st = new Stack<>();
        
        st.push(-1);
        int maxArea = 0;
        
        for(int i=0;i<=heights.length;i++){
            int val = i==heights.length?0:heights[i];
            
            while(st.peek() != -1 && heights[st.peek()] >= val){
                int rm = i;
                int h = heights[st.pop()];
                int lm = st.peek();
                maxArea = Math.max(maxArea, h*(rm-lm-1));
            }
            
            st.push(i);
        }
        
        return maxArea;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int row = Integer.parseInt(read.readLine());
        int col = Integer.parseInt(read.readLine());
        
        int bmat[][] = new int[row][col];

        for(int i=0;i<row;i++){
            String s = read.readLine();
            for(int j=0;j<col;j++){
                bmat[i][j] = s.charAt(j)-'0';
            }
        }

        int result = maximalRectangle(bmat);
        System.out.println(result);
        
    }
}