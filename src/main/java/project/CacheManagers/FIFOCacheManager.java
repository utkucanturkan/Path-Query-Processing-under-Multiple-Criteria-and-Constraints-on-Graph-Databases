package project.CacheManagers;

import scala.Int;

import java.util.Map;

public class FIFOCacheManager extends CacheManager {
    private final String NAME = "FIFOCacheManager";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public void push(long element) {
        incrementIndexByOne();
        if (!elements.containsKey(element)) {
            elements.put(element, index);
        }
    }

    @Override
    public Long peek() {
        long leastRecentlyUsedElement = -1;
        int theLeastIndex = Integer.MAX_VALUE;
        for(Map.Entry<Long, Integer> entry: elements.entrySet()){
            if (entry.getValue() < theLeastIndex) {
                theLeastIndex = entry.getValue();
                leastRecentlyUsedElement = entry.getKey();
            }
        }

        if (leastRecentlyUsedElement < 0) {
            return null;
        }

        elements.remove(leastRecentlyUsedElement);

        return leastRecentlyUsedElement;
    }
}
