package demo.test.fuzaijunhen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuyunfeng on 16/9/24.
 */
public class Hash {

    public static String getServer(String remoteIp){
        Map<String, Integer> serverMap = new HashMap<>(IpMap.serverWeightMap);

        ArrayList<String> keyList = new ArrayList<>(serverMap.keySet());

        int hashCode = remoteIp.hashCode();

        int serverPos = hashCode % keyList.size();

        return keyList.get(serverPos);

    }

    public static void main(String[] args) {
        System.out.println(Hash.getServer("127.0.0.1"));
        System.out.println(Hash.getServer("192.168.1.1"));
        System.out.println(Hash.getServer("192.168.1.2"));
        System.out.println(Hash.getServer("192.168.1.3"));
        System.out.println(Hash.getServer("192.168.1.chat_4"));
    }

}
