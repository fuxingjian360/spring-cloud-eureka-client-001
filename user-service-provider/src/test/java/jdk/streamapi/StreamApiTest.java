package jdk.streamapi;

import com.alibaba.fastjson.JSON;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.json.JsonbTester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApiTest {

    public static void main(String[] args) {
        sortedStream();
    }

    public static void sortedStream(){
        List<UserObject> list = new ArrayList<UserObject>();
        UserObject userObject = null;
        for (int i = 0; i < 30; i++) {
            userObject = new UserObject();
            userObject.setName("张三00" + i);
            list.add(userObject);
        }
        List<UserObject> resultList = list.stream()
                //.sorted()//默认使用自然排序,UserObject必须实现comparable接口
                .sorted((obj1,obj2)->{//lambda表达式写发,UserObject可以不用实现comparable接口
                    return -(obj1.getName().compareTo(obj2.getName()));
                })
                .collect(Collectors.toList());
        System.err.println(JSON.toJSON(resultList));
    }

    public static void mapStream() {
        List<UserObject> list = new ArrayList<UserObject>();
        UserObject userObject = null;
        for (int i = 0; i < 30; i++) {
            userObject = new UserObject();
            userObject.setName("张三00" + i);
            list.add(userObject);
        }

        Set<UserObject2> sets =list.stream().filter(obj -> {//filter:true:过滤满足条件UserObject,false:剔除
            boolean flag = false;
            if (StringUtils.isNotBlank(obj.getName()) && obj.getName().contains("1")) {
                flag = true;
            }
            return flag;
        }).map(obj->{//从一个对象转换为另外一个对象,返回转换后对象
            UserObject2 userObject2 = new UserObject2();
            userObject2.setName(obj.getName());
            return userObject2;
        }).collect(Collectors.toSet());
        System.err.println(JSON.toJSON(sets));
        System.err.println(JSON.toJSON(list));
    }

    private static void test001() {
        List<String> strList = Arrays.asList("a", "b", "c");
        Arrays.asList("a", "b", "c")
                .stream()
                .findFirst()
                .ifPresent(System.err::println);
//        Optional<String> result = strList.stream().findFirst();
//        result.ifPresent(System.out::print);

        Set<String> list2;
        list2 = Arrays.asList("aaaa1", "aaaa2", "aaaa1", "aaaaaa1", "aaaaa1", "aaaa1", "aaa1")
                .stream()
                .map(e -> {
                    return e.substring(1);
                }).collect(Collectors.toSet());
        System.err.println(list2);

        list2 = Arrays.asList("aaaa1", "aaaa2", "aaaa1", "aaaaaa1", "aaaaa1", "aaaa1", "aaa1")
                .stream()
                .filter(e -> {
                    return e.contains("aaa");
                }).collect(Collectors.toSet());
        System.err.println(list2);
    }
}
