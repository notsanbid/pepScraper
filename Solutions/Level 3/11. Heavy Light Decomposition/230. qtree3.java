import java.io.*;
import java.util.*;

public class Main {

  static InputReader in = new InputReader(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  static ArrayList<Integer> adj[];
  static int[] depth, heavy, parent, size;
  static int[] head, lt, pos;
  static int idx;
  static boolean isBlack[];

  static void dfs(int node) {

    for (int c : adj[node]) {
      if (c != parent[node]) {
        parent[c] = node;
        depth[c] = depth[node] + 1;

        dfs(c);
        size[node] += size[c];
        if (size[c] > size[heavy[node]])heavy[node] = c;
      }
    }
    size[node]++;
  }

  static void hld(int node, int h) {
    head[node] = h;
    lt[idx] = node;
    pos[node] = idx++;

    if (heavy[node] != 0)hld(heavy[node], h);

    for (int c : adj[node]) {
      if (c != parent[node] && c != heavy[node]) {
        hld(c, c);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    int n = in.nextInt();
    int q = in.nextInt();

    adj = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++)adj[i] = new ArrayList<>();

    for (int i = 1; i < n; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      adj[a].add(b);
      adj[b].add(a);
    }

    depth = new int[n + 1];
    heavy = new int[n + 1];
    parent = new int[n + 1];
    size = new int[n + 1];

    dfs(1);

    head = new int[n + 1];
    pos = new int[n + 1];
    lt = new int[n + 1];
    idx = 0;

    hld(1, 1);

    tree = new int[4 * n]; // default 0 no black node

    isBlack = new boolean[n + 1]; // default is false
    while (q-- > 0) {
      int t = in.nextInt();
      int v = in.nextInt();

      if (t == 0) {
        update(1, 0, n - 1, pos[v]);
      } else {
        int res = lcaQuery(v, n);
        out.println(res == 0 ? -1 : res);
      }
    }
    out.close();
  }

  static int tree[];

  static void update(int node, int start, int end, int p) {

    if (start == end) {
      if (tree[node] == 0) {
        tree[node] = lt[start];
      } else {
        tree[node] = 0;
      }
    } else {
      int mid = (start + end) / 2;
      if (p <= mid) {
        update(node * 2, start, mid, p);
      } else {
        update(node * 2 + 1, mid + 1, end, p);
      }

      tree[node] = tree[node * 2 + 1];

      if (tree[node] != 0)return;
      tree[node] = tree[node * 2];
    }

  }

  static int query(int node, int start, int end, int l, int r) {
    if (end < l || r < start)return 0;

    if (l <= start && end <= r) {
      return tree[node];
    } else {
      int mid = (start + end) / 2;
      int ra = query(node * 2 + 1, mid + 1, end, l, r);
      if (ra != 0)return ra;
      return query(node * 2, start, mid, l, r);
    }
  }

  static int lcaQuery(int v, int n) {
    int ans = 0;

    while ( v != 0) {
      ans = query(1, 0, n - 1, pos[head[v]], pos[v]);
      v = parent[head[v]];
      if (ans != 0)return ans;
    }
    return ans;
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