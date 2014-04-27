package CF;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Trie_ex {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int n = in.readInt();
        long[] A = new long[n];
        long pre = 0;
        for (int i = 0; i < n; i++)
            pre ^= A[i] = in.readLong();
        long suf = 0;
        long ans = pre;
        Trie T = new Trie();
        T.insert(0);
        for (int i = n - 1; i >= 0; i--) {
            suf ^= A[i];
            pre ^= A[i];
            T.insert(suf);
            long v = T.search(pre);
            ans = Math.max(ans, pre ^ v);
        }
        System.out.println(ans);
    }
}

class Trie {
    Trie[] next;

    public Trie() {
        next = new Trie[2];
    }

    public void insert(long x) {
        insert(x, 40);
    }

    private void insert(long x, int bit) {
        if (bit == -1)
            return;
        int current = (x & (1l << bit)) == 0 ? 0 : 1;
        if (next[current] == null)
            next[current] = new Trie();
        next[current].insert(x, bit - 1);
    }

    public long search(long x) {
        return search(x, 40);
    }

    private long search(long x, int bit) {
        if (bit == -1)
            return 0;
        int current = (x & (1l << bit)) == 0 ? 1 : 0;
        if (next[current] != null)
            return ((long) current << bit) | next[current].search(x, bit - 1);
        else
            return ((long) (1 - current) << bit)
                    | next[current ^ 1].search(x, bit - 1);
    }
}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1000];
    private int curChar, numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    private int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuffer res = new StringBuffer();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private String readLine0() {
        StringBuffer buf = new StringBuffer();
        int c = read();
        while (c != '\n' && c != -1) {
            buf.appendCodePoint(c);
            c = read();
        }
        return buf.toString();
    }

    public String readLine() {
        String s = readLine0();
        while (s.trim().length() == 0)
            s = readLine0();
        return s;
    }

    public String readLine(boolean ignoreEmptyLines) {
        if (ignoreEmptyLines)
            return readLine();
        else
            return readLine0();
    }

    public char readCharacter() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        return (char) c;
    }

    public double readDouble() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E')
                return res * Math.pow(10, readInt());
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, readInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }
}