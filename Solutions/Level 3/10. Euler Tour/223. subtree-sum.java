import java.io.*;
import java.util.*;

public class Main {
  static InputReader in = new InputReader(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  /*
  input_functions in.nextInt();     in.nextIntArray(n);      in.nextIntArray1(n);
  output_functions out.println();    out.print();
  */

    static int value[];
    static ArrayList<Integer>adj[];
    static int start[], end[], lt[], time;
    static long ftree[];

    static void dfs(int node, int p){
    	start[node] = ++time;
    	lt[time] = value[node];
    	for(int c: adj[node]){
    	    if(c != p ){
    		    dfs(c, node);
    	    }
    	}	
    	end[node] = time;
    }
    
    static void addFT(int i, long val){
        
        while(i < ftree.length){
            ftree[i] += val;
            i += i&(-i);
        }
        
    }
    
    static long sumFT(int i){
        long sum=0;
        
        while(i>0){
            sum += ftree[i];
            i -= i&(-i);
        }
        return sum;
    }

    static void buildFT(){
        for(int i=1;i<=time;i++){
            addFT(i, lt[i]);
        }
    }

  public static void main(String[] args) throws IOException {

    int n = in.nextInt();
    int q = in.nextInt();
    
    value = in.nextIntArray1(n);// 1...n
    adj = new ArrayList[n+1];
    for(int i=0;i<=n;i++)adj[i] = new ArrayList<>();
    
    for(int i=1;i<n;i++){
        int u = in.nextInt();
        int v = in.nextInt();
        
        adj[u].add(v);
        adj[v].add(u);
    }
    
    start = new int[n+1];
    end = new int[n+1];
    lt = new int[n+1];
    time = 0;
    
    dfs(1, 0);
    
    ftree = new long[lt.length];
    buildFT();
    
    while(q-- > 0){
        int t = in.nextInt();
        
        if(t == 1){
            int v = in.nextInt();
            int val = in.nextInt();
            
            long delta = val;
            delta -= value[v];
            
            value[v] = val;
            addFT(start[v], delta);
            // addFT(end[v], delta);
        }else{
            int v = in.nextInt();
            long sum = sumFT(end[v]) - sumFT(start[v]-1);
            sum = sum;
            out.println(sum);
        }
    }

    out.close();
  }

  private static class InputReader implements AutoCloseable {

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;


    private static final InputStream DEFAULT_STREAM = System.in;

    private static final int MAX_DECIMAL_PRECISION = 21;

    private int c;

    private final byte[] buf;
    private final int bufferSize;
    private int bufIndex;
    private int numBytesRead;

    private final InputStream stream;

    private static final byte EOF = -1;

    private static final byte NEW_LINE = 10;

    private static final byte SPACE = 32;

    private static final byte DASH = 45;

    private static final byte DOT = 46;
    private char[] charBuffer;
    private static final byte[] bytes = new byte[58];
    private static final int[] ints = new int[58];
    private static final char[] chars = new char[128];

    static {
      char ch = ' ';
      int value = 0;
      byte _byte = 0;
      for (int i = 48; i < 58; i++)
        bytes[i] = _byte++;
      for (int i = 48; i < 58; i++)
        ints[i] = value++;
      for (int i = 32; i < 128; i++)
        chars[i] = ch++;
    }

    public InputReader() {
      this(DEFAULT_STREAM, DEFAULT_BUFFER_SIZE);
    }
    public InputReader(int bufferSize) {
      this(DEFAULT_STREAM, bufferSize);
    }
    public InputReader(InputStream stream) {
      this(stream, DEFAULT_BUFFER_SIZE);
    }
    public InputReader(InputStream stream, int bufferSize) {
      if (stream == null || bufferSize <= 0)
        throw new IllegalArgumentException();
      buf = new byte[bufferSize];
      charBuffer = new char[128];
      this.bufferSize = bufferSize;
      this.stream = stream;
    }
    private byte read() throws IOException {

      if (numBytesRead == EOF)
        throw new IOException();

      if (bufIndex >= numBytesRead) {
        bufIndex = 0;
        numBytesRead = stream.read(buf);
        if (numBytesRead == EOF)
          return EOF;
      }

      return buf[bufIndex++];
    }
    private int readJunk(int token) throws IOException {

      if (numBytesRead == EOF)
        return EOF;
      do {

        while (bufIndex < numBytesRead) {
          if (buf[bufIndex] > token)
            return 0;
          bufIndex++;
        }
        numBytesRead = stream.read(buf);
        if (numBytesRead == EOF)
          return EOF;
        bufIndex = 0;

      } while (true);

    }
    public byte nextByte() throws IOException {
      return (byte) nextInt();
    }
    public int nextInt() throws IOException {

      if (readJunk(DASH - 1) == EOF)
        throw new IOException();
      int sgn = 1, res = 0;

      c = buf[bufIndex];
      if (c == DASH) {
        sgn = -1;
        bufIndex++;
      }

      do {

        while (bufIndex < numBytesRead) {
          if (buf[bufIndex] > SPACE) {
            res = (res << 3) + (res << 1);
            res += ints[buf[bufIndex++]];
          } else {
            bufIndex++;
            return res * sgn;
          }
        }
        numBytesRead = stream.read(buf);
        if (numBytesRead == EOF)
          return res * sgn;
        bufIndex = 0;

      } while (true);

    }
    public int[] nextIntArray(int n) throws IOException {
      int[] ar = new int[n];
      for (int i = 0; i < n; i++)
        ar[i] = nextInt();
      return ar;
    }
    public int[] nextIntArray1(int n) throws IOException {
      int[] ar = new int[n + 1];
      for (int i = 1; i <= n; i++)
        ar[i] = nextInt();
      return ar;
    }
    public void close() throws IOException {
      stream.close();
    }

  }
}