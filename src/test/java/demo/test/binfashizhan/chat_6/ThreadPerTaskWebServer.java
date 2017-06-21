package demo.test.binfashizhan.chat_6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wuyunfeng on 2016/9/26.
 */
public class ThreadPerTaskWebServer {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true){
            final Socket connection = socket.accept();
//            Runnable task = () -> handleRequest(connection);
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    handleRequest(connection);
                }
            };
            new Thread(task).start();
        }
    }
    private static void handleRequest(Socket connection) {
        // request-handling logic here
    }

}
