import java.io.*;
import java.util.*;

public class Main {
  static InputReader in = new InputReader(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  /*
  input functions in.nextInt();     in.nextIntArray(n);      in.nextIntArray1();
  output fnctions out.println();    out.print();

  use in for reading input
  use out for printing output
  */
  
    static class Pair{
        int nbr;
        int w;
        Pair(int n, int w){
            nbr = n;
            this.w = w;
        }
    }

    static ArrayList<Pair>adj[];
    static long Node2RootW[];
    static int table[][];
    static int MAXBIT=17;
    static long maxChild[];
    static int depth[];

    static long dfs(int node, long sum, int p){
        Node2RootW[node] = sum;
        table[0][node] = p;
        
        long max=0;
        for(Pair edge: adj[node]){
            if(edge.nbr != p){
                depth[edge.nbr] = depth[node]+1;
                long m = dfs(edge.nbr, sum+edge.w, node);
                max = Math.max(max, Math.max(m+edge.w, edge.w));
            }
        }
        
        maxChild[node] = max;
        return max;
    }
    
    static void build(int n){
        for(int j=1;j<=MAXBIT;j++){
            for(int i=1;i<=n;i++){
                int par = table[j-1][i];
                table[j][i] = table[j-1][par];
            }
        }
    }
    
    static int lca(int a, int b){
        // depth[a] < depth[b]
        if(depth[a] > depth[b]){
            int t = a;
            a=b;
            b=t;
        }
        
        int k= - depth[a] + depth[b];
        
        for(int i=MAXBIT;i>=0;i--){
            int mask=1<<i;
            if((k & mask) > 0){
                b = table[i][b];
            }
        }
        if(a==b)return a;
        
        for(int i=MAXBIT;i>=0;i--){
            int ap = table[i][a];
            int bp = table[i][b];
            
            if(ap != bp){
                a = ap;
                b = bp;
            }
        }
        
        return table[0][a];
    }

    static void solve() throws Exception {
        
        int n = in.nextInt();
        int q = in.nextInt();
        
        adj = new ArrayList[n+1];// 1.... n
        for(int i=0;i<=n;i++)adj[i] = new ArrayList<>();
        for(int i=1;i<n;i++){
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            adj[u].add(new Pair(v, w));
            adj[v].add(new Pair(u, w));
        }
        
        Node2RootW = new long[n+1];
        table = new int[MAXBIT+1][n+1];
        maxChild = new long[n+1];
        depth = new int[n+1];
        
        dfs(1, 0, 0);
        
        build(n);
        while(q-- > 0){
            int u = in.nextInt();
            int v = in.nextInt();
            int x = in.nextInt();
            
            int lca = lca(u, v);
            long lcaSum = Node2RootW[u] - Node2RootW[lca] + Node2RootW[v] - Node2RootW[lca];
            long esum = maxChild[u] + maxChild[v] + x;
            
            out.println(Math.max(lcaSum, esum));
        }
        
    }

  public static void main(String[] args) throws Exception {

    int t = in.nextInt();
    
    while(t-- > 0){
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