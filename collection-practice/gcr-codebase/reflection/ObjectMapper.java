package reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class User {
    String name;
    int age;
}

class ObjectMapperUtil {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(obj, entry.getValue());
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

public class ObjectMapper {

    public static void main(String[] args) {

        Map<String, Object> data = new HashMap<>();
        data.put("name", "Steve");
        data.put("age", 22);

        User user = ObjectMapperUtil.toObject(User.class, data);
        System.out.println(user.name + " : " + user.age);
    }
}
