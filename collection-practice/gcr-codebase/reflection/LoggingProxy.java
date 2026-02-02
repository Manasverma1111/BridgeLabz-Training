package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello!");
    }
}

public class LoggingProxy {

    public static Object createProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Calling method: " + method.getName());
                        return method.invoke(target, args);
                    }
                }
        );
    }

    public static void main(String[] args) {
        Greeting greeting = (Greeting) LoggingProxy.createProxy(new GreetingImpl());
        greeting.sayHello();

    }
}
