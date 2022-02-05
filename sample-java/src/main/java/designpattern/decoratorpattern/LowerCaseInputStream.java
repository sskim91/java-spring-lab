package designpattern.decoratorpattern;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by sskim on 2022/02/04
 * Github : http://github.com/sskim91
 */
public class LowerCaseInputStream extends FilterInputStream implements AutoCloseable{
    public LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result =  super.read(b, off, len);
        for (int i = off; i <off+result ; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }
}
