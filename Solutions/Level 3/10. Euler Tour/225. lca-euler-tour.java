import java.io.*;
import java.util.*;

public class Main {
  static InputReader in = new InputReader(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  /*
  input_functions in.nextInt();     in.nextIntArray(n);      in.nextIntArray1(n);
  output_functions out.println();    out.print();
  */

    static ArrayList<Integer> childs[];
    static ArrayList<Integer> travel;
    static int depth[], start[];
    static int table[][];

    static void dfs(int node){
        start[node] = travel.size();
        travel.add(node);
        
        for(int v: childs[node]){
            depth[v] = depth[node]+1;
            dfs(v);
            travel.add(node);
        }
    }

    static void build(){
        
        int maxBIT = 0;// log2(travel.size())
        
        while((1<<maxBIT) <= travel.size())maxBIT++;
        maxBIT--;
        
        table = new int[maxBIT+1][travel.size()];
        for(int i=0;i<travel.size();i++){
            table[0][i] = travel.get(i);
        }
        
        for(int j=1;j<=maxBIT;j++){
            for(int i=0;i + (1<<j) <= travel.size();i++){
                int v = table[j-1][i];
                int u = table[j-1][i+(1<<(j-1))];
                table[j][i] = depth[v] < depth[u]?v:u;
            }
        }
        
    }
    
    static int rangeMin(int l, int r){
        int count = r-l+1;
        int k = (int)(Math.log(count)/Math.log(2));
        int v = table[k][l];// l......(l+2^k)
        int u = table[k][r - (1<<k) + 1];
        return depth[v] < depth[u]?v:u;
    }

  public static void solve() throws Exception {
        int n = in.nextInt();
        
        childs = new ArrayList[n+1];
        for(int i=0;i<=n;i++)childs[i] = new ArrayList<>();
        
        for(int i=1;i<=n;i++){
            int cl = in.nextInt();
            int child[] = in.nextIntArray(cl);
            for(int v: child){
                childs[i].add(v);
            }
        }
        travel = new ArrayList<>();
        depth = new int[n+1];
        start = new int[n+1];
        
        dfs(1);
        depth[0] = Integer.MAX_VALUE;
        
        build();
        int q = in.nextInt();
        
        while(q-- > 0){
            int v = in.nextInt();
            int u = in.nextInt();
            
            // int ans = 0;
            // for(int i=Math.min(start[v], start[u]); i<= Math.max(start[v], start[u]); i++){
            //     int node = travel.get(i);
            //     if(depth[node] < depth[ans]){
            //         ans = node;
            //     }
            // }
            int ans = rangeMin(Math.min(start[u], start[v]), Math.max(start[u], start[v]));
            out.println(ans);
        }
  }

  public static void main(String[] args) throws Exception {

    int t = in.nextInt();

    for (int T = 1; T <= t; T++) {
      out.println("Case " + T + ":");
      solve();
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