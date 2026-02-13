package concurrentMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCache {

    private static final Map<String, String> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            final int threadNum = i;
            new Thread(() -> {
                String key = "#Key @: "+threadNum;
                for(int j=0;j<3;j++){
                    String value = getCachedValue(key);
                    System.out.println("Thread: "+ Thread.currentThread().getName()+": "+ "Key = "+ key+" value = "+value);
                }
            }).start();
        }
    }

    public static String getCachedValue(String key) {
        String value = cache.get(key);
        if (value != null) {
            value  = compute(key);
            cache.put(key, value);
        }
        return value;
    }


    public static String compute(final String key) {
        System.out.println("Key" + key + "is not present in cache so computing...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return key;
    }

}
