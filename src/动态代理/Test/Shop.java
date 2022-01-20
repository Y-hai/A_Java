package 动态代理.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Shop {
    public static void main(String[] args) {
        // 1.创建目标对象
        usbSell factory = new usbKingFactory();
        // 2.创建InvocationHandler对象
        InvocationHandler handler = new mySellHand(factory);
        /** 3.创建代理对象（3个参数依次是：类加载器，目标类参数列表，Handler对象）
         *  JVM会创建一个代理类，proxy对象是代理类的实例
         */
        usbSell proxy = (usbSell) Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(), handler);
        // 4.通过代理执行方法
        float price = proxy.sell(1); // 执行handler对象里的invoke方法
        System.out.println("通过动态代理对象，调用方法：" + price);
    }
}
