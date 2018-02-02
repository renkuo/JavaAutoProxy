package personal.renkuo.com.javaautoproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by renkuo on 2018/2/2.
 */

public class SayHelloProxy implements InvocationHandler{
    private Object target;

    /**
     * 绑定委托对象并返回一个【代理占位】
     * @param target 真实对象
     * @return  代理对象【占位】
     */
    public SayHelloService bind(SayHelloService sayHelloService){
        target = sayHelloService;

        return (SayHelloService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

    /**
     * 同过代理对象调用方法首先进入这个方法.
     * @param proxy --代理对象
     * @param method -- 方法,被调用方法.
     * @param args -- 方法的参数
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("############我是JDK动态代理################");
        Object result = null;
        System.out.println("在你之前代理要做的事情");
        System.out.println(proxy.getClass().getName());
//        proxy.getClass().getMethod("doProxy").invoke(null); //这么写会报错 不知道为什么 有待研究
        System.out.println(target.getClass().getName());
        result = method.invoke(target,args);
        System.out.println("在你之前代理要做的事情");
        return result;
    }

    public static void doProxy(){
        System.out.println("执行代理特有的方法");
    }

}
