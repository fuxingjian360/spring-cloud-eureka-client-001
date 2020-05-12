import redis.clients.jedis.*;

import java.util.LinkedList;
import java.util.List;

public class RedisTest {


    public static void main(String[] args) {
        test001();

    }

    public static void test001(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(200);
        jedisPoolConfig.setMaxWaitMillis(10000);
        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        jedisPoolConfig.setBlockWhenExhausted(true);
        // 是否启用pool的jmx管理功能, 默认true
        jedisPoolConfig.setJmxEnabled(true);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "114.67.178.177", 6379, 10000, "123456");
        Jedis jedis = jedisPool.getResource();
        jedis.set("keyfXJ0011", "valueFXJ001");
        jedis.select(0);

        String str = jedis.get("keyfXJ0011");
        System.err.println(str);
    }

    private static void stringSetAndGet() {
        JedisShardInfo jedisShardInfo = new JedisShardInfo("redis://114.67.178.177:6379/1");
        jedisShardInfo.setPassword("123456");
        Jedis jedis = new Jedis(jedisShardInfo);//new Jedis("114.67.178.177", 6379);
        jedis.set("str_name_key", "value001");
        jedis.setex("str_name_ex_key",10,"str_name_ex_value001");
        jedis.mset("skey001","value001","skey002","value003");
        String value = jedis.get("str_name_key");
        System.out.println(value);
        String value2 = jedis.get("str_name_ex_key");
        System.out.println(value2);
    }


}
