import java.io.*;
import java.util.*;

public class Main {

  static InputReader scn = new InputReader(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  static class Node {
    int sum;
    Node left;
    Node right;
    Node(int data) {
      sum = data;
    }
    Node(Node l, Node r) {
      sum = l.sum + r.sum;
      left = l;
      right = r;
    }
  }

  static Node build(int start, int end) {
    if (start == end) {
      return new Node(0);
    } else {
      int mid = (start + end) / 2;
      return new Node(
               build(start, mid),
               build(mid + 1, end)
             );
    }
  }

  static Node update(Node node, int start, int end, int pos, int val) {
    if (start == end) {
      return new Node(val);
    } else {
      int mid = (start + end) / 2;
      if (start <= pos && pos <= mid) {
        return new Node(update(node.left, start, mid, pos, val), node.right);
      } else {
        return new Node(node.left, update(node.right, mid + 1, end, pos, val));
      }
    }
  }

  static int query(Node past, Node pres, int start, int end, int k) {
    if (start == end) {
      return start;
    } else {
      int mysegC = pres.left.sum - past.left.sum;
      if (k <= mysegC) {
        return query(past.left, pres.left, start, (start + end) / 2, k);
      } else {
        return query(past.right, pres.right, (start + end) / 2 + 1, end, k - mysegC);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    // Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    int arr[] = new int[n];
    for (int i = 0; i < n; i++)arr[i] = scn.nextInt();

    int [][]sorted = new int[n][2];

    for (int i = 0; i < n; i++) {
      sorted[i][0] = i;
      sorted[i][1] = arr[i];
    }
    Arrays.sort(sorted, (a, b)->a[1] - b[1]);
    int []indInTree = new int[n];
    for (int i = 0; i < n; i++) {
      indInTree[sorted[i][0]] = i;
    }

    ArrayList<Node> states = new ArrayList<Node>();
    states.add(build(0, n - 1));

    for (int i = 0; i < n; i++) {
      Node root = update(states.get(states.size() - 1), 0, n - 1, indInTree[i], 1);
      states.add(root);
    }

    while (m-- > 0) {
      int  l = scn.nextInt() - 1;
      int r = scn.nextInt() - 1;
      int k = scn.nextInt();
      int ans = query(states.get(l), states.get(r + 1), 0, n - 1, k);
      out.println(sorted[ans][1]);
    }

    out.close();

    // states.add(update(states.get(states.size()-1), 0, n-1, pos, val));
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