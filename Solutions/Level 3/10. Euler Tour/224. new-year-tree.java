import java.io.*;
import java.util.*;

public class Main {
  static InputReader in = new InputReader(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  /*
  input_functions in.nextInt();     in.nextIntArray(n);      in.nextIntArray1(n);
  output_functions out.println();    out.print();
  */

  static int color[];
  static ArrayList<Integer>adj[];
  static int lt[];// 1....n
  static int start[], end[], time;

  public static void dfs(int node, int p) {

    time++;
    lt[time] = color[node];
    start[node] = time;

    for (int v : adj[node]) {
      if (v != p) {
        dfs(v, node);
      }
    }

    end[node] = time;
  }

  public static void main(String[] args) throws Exception {

    int n = in.nextInt();// 1...n
    int m = in.nextInt();

    color = in.nextIntArray1(n);

    adj = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++)adj[i] = new ArrayList<>();

    for (int i = 1; i < n; i++) {
      int u = in.nextInt();
      int v = in.nextInt();
      adj[u].add(v);
      adj[v].add(u);
    }

    start = new int[n + 1];
    end = new int[n + 1];
    time = 0;
    lt = new int[n + 1];

    dfs(1, 0);
    stree = new long[4 * n];
    lazy = new int[4 * n];
    build(1, 1, n);

    while (m-- > 0) {
      int t = in.nextInt();
      int v = in.nextInt();

      if (t == 1) {
        int c = in.nextInt();
        update(1, 1, n, start[v], end[v], c);
      } else {

        long ans = query(1, 1, n, start[v], end[v]);// 010010110

        int count = 0;

        while (ans > 0) {
          count++;
          ans -= ans & (-ans); // ans&(ans-1)
        }

        out.println(count);
      }
    }

    out.close();
  }

  static long []stree;
  static int lazy[];
  final static long one = 1;

  public static void propagate(int node, int start, int end) {
    if (lazy[node] == 0)return;

    stree[node] = one << lazy[node];

    if (start != end) {
      lazy[node * 2] = lazy[node * 2 + 1] = lazy[node];
    }
    lazy[node] = 0;
  }

  public static long query(int node, int start, int end, int l, int r) {
    if (end < l || r < start)return 0;
    propagate(node, start, end);
    if (l <= start && end <= r) {
      return stree[node];
    } else {
      int mid = (start + end) / 2;
      return query(node * 2, start, mid, l, r) | query(node * 2 + 1, mid + 1, end, l, r);
    }
  }

  static void update(int node, int start, int end, int l, int r, int c) {
    propagate(node, start, end);
    if (end < l || r < start)return;

    if (start == end || (l <= start && end <= r)) {
      lazy[node] = c;
      propagate(node, start, end);
    } else {
      int mid = (start + end) / 2;
      update(node * 2, start, mid, l, r, c);
      update(node * 2 + 1, mid + 1, end, l, r, c);

      stree[node] = stree[node * 2] | stree[node * 2 + 1];
    }

  }

  public static void build(int node, int start, int end) {
    if (start == end) {
      stree[node] = one << lt[start]; // 1...60
    } else {
      int mid = (start + end) / 2;
      build(node * 2, start, mid);
      build(node * 2 + 1, mid + 1, end);
      stree[node] = stree[node * 2] | stree[node * 2 + 1];
    }
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