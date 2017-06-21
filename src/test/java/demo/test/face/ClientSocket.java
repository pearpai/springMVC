package demo.test.face;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by wuyunfeng on 2016/9/29.
 */
public class ClientSocket {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 4001);
        PrintStream ps = new PrintStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br_server = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String temp = br.readLine();
        while (true){
            ps.println(temp);
            if (temp.equals("stop"))
                break;
            temp = br.readLine();
        }
        s.close();
        br.close();
        br_server.close();
    }
}
