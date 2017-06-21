package demo.test.face;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wuyunfeng on 2016/9/29.
 */
public class ServerSocket_1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4001);
        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        PrintStream ps = new PrintStream(s.getOutputStream());
        String temp = br.readLine();
        while (true){
            System.out.println("客户端： " + temp);
            ps.print(temp);
            if (temp.equals("stop"))
                break;
            temp = br.readLine();
        }
        br.close();
        ps.close();
        ss.close();
    }
}
