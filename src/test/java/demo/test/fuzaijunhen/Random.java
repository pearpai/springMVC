package demo.test.fuzaijunhen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by wuyunfeng on 16/9/23.
 */
public class Random {

    public static String getServer() {
        Map<String, Integer> serverMap = new HashMap<>();
        serverMap.putAll(IpMap.serverWeightMap);

        Set<String> keySet = serverMap.keySet();
        ArrayList<String> keyList = new ArrayList<>(keySet);
        java.util.Random random = new java.util.Random();
        int randomPos = random.nextInt(keyList.size());
        return keyList.get(randomPos);
    }


    public static void main(String[] args) {
        for (int a = 0; a < 10; a++)
            System.out.println(Random.getServer());

    }

//    整体代码思路和轮询法一致，先重建serverMap，再获取到server列表。
//    在选取server的时候，通过Random的nextInt方法取0~keyList.size()区间的一个随机值，
//    从而从服务器列表中随机获取到一台服务器地址进行返回。基于概率统计的理论，吞吐量越大，随机算法的效果越接近于轮询算法的效果。
}
