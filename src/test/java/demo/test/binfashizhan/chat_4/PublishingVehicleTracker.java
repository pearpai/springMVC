package demo.test.binfashizhan.chat_4;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wuyunfeng on 16/9/24.
 */
public class PublishingVehicleTracker {

    private final Map<String, SafePoint> locations;
    private final Map<String, SafePoint> unmodifiableMap;

    public PublishingVehicleTracker(Map<String, SafePoint> locations) {
        this.locations = new ConcurrentHashMap<>(locations);
        this.unmodifiableMap = new ConcurrentHashMap<>(locations);
    }

    public Map<String, SafePoint> getLocations(){
        return unmodifiableMap;
    }

    public SafePoint getLocation(String id){
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y){
        if (!locations.containsKey(id))
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        locations.get(id).set(x, y);
    }
}
