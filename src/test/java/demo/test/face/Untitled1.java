package demo.test.face;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wuyunfeng on 2016/9/29.
 */
public class Untitled1 {
    public static void writeFileChar() throws Exception {
        FileWriter f = new FileWriter("aa.txt");
        InputStream is = System.in;
        int c = is.read();
        while (((char) c) != 'x') {
            f.write(c);
            c = is.read();
        }
        f.close();
        is.close();
    }

    public static void main(String[] args) throws Exception {
        writeFileChar();
    }
}
