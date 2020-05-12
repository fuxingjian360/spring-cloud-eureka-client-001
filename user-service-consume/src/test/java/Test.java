import com.alibaba.fastjson.JSON;
import com.gupao.xing.jian.app1.userinfo.domain.User;
import org.springframework.boot.test.json.JsonbTester;

import java.lang.reflect.Constructor;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception{
        User user = new User();
        User user2 =  User.class.newInstance();
        Class clazz = Class.forName("com.gupao.xing.jian.app1.userinfo.domain.User");
        User user3 = (User) clazz.newInstance();
        Constructor constructor = clazz.getConstructor();
        User user4 = (User) constructor.newInstance();
        System.err.println(JSON.toJSON(user4));
    }

    private static void test001() {
        int h = 1000000;
        int r = h ^ (h >>> 16);
        System.err.println(h >>> 16);
        System.err.println(r);
        Set<String> set = new HashSet<String>();
        System.err.println(set.add("123"));
        System.err.println(set.add("123"));
        Map<String,String> maps = new HashMap<>();
        maps.put("123","123");
        List<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.remove("2");
        System.err.println(JSON.toJSON(arrayList));
        List<String> lists = new LinkedList<>();
        lists.add("1");
        lists.add("2");
        lists.add("3");
        System.err.println(lists.get(1));
    }
}
