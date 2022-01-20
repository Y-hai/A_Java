package 动态代理.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 1.调用目标方法
 * 2.功能增强
 */
public class mySellHand implements InvocationHandler {
    private Object target = null;

    // 传入一个目标对象
    public mySellHand(Object target) {
        this.target = target;
    }

    /**
     * @param proxy：JDK动态创建的对象，用户调用这个对象的sell方法
     * @param method：接口的sell方法
     * @param args：传入sell方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = null;
        res = method.invoke(target, args); // 执行目标方法
        if (res != null) {
            Float price = (Float) res;
            price += 25;
            res = price;
        }
        System.out.println("返回一个优惠券");
        return res;
    }
}
