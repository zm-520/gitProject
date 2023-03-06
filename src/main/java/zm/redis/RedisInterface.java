package zm.redis;


import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface RedisInterface {
    void set(String key, String value, long seconds);

    void set(String key, String value);

    Object get(String key);

    Object getObject(String key);

    void delete(String key);

    void deleteHash(String key, String field);


    boolean hasKey(String key);

    Double incrScore(String key, String value, double score);

    Set rangeWithScore(String key, long start, long end);

    void zRemove(String key, String value);

}
