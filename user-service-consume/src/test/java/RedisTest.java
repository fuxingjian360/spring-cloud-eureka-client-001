import redis.clients.jedis.Jedis;

public class RedisTest {


    private static Jedis jedis = new Jedis("114.67.178.177", 6379);;

    public static void main(String[] args) {
        stringSetAndGet();

    }

    private static void stringSetAndGet() {
        jedis.set("str_name_key", "value001");
        jedis.setex("str_name_ex_key",10,"str_name_ex_value001");
        jedis.mset("skey001","value001","skey002","value003");
        String value = jedis.get("str_name_key");
        System.out.println(value);
        String value2 = jedis.get("str_name_ex_key");
        System.out.println(value2);
    }


}
