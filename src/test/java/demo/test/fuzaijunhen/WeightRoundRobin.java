package demo.test.fuzaijunhen;

import java.util.*;

/**
 * Created by wuyunfeng on 16/9/24.
 */
public class WeightRoundRobin {

    private static Integer pos;

    public static String getServer(){
        Map<String, Integer> serverMap = new HashMap<>(IpMap.serverWeightMap);

        Set<String> keySet = serverMap.keySet();

        Iterator<String> iterator = keySet.iterator();

        List<String> serverList = new ArrayList<>();

        while (iterator.hasNext()){
            String server = iterator.next();
            int weight = serverMap.get(server);
            for (int i = 0; i < weight; i++)
                serverList.add(server);
        }

        String server = null;
        synchronized (pos){
            if (pos > keySet.size())
                pos = 0;
            server = serverList.get(pos);
            pos ++;
        }
        return server;
    }

}
