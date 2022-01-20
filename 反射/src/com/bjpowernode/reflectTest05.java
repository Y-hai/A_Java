package com.bjpowernode;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflectTest05 {
    public reflectTest05() {
    }

    public static void f(int... args) {
        /**
         * 可变长参数个数0~n
         * 可变长参数只能出现在最后一个位置
         * 可变长参数可以当作一个数组来看待
         */

    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class c = Class.forName("com.java.Student");
//        System.out.println(c.getName());
//        System.out.println(c.getSimpleName());
        // 获取所有的公开Field
//        Field[] f = c.getFields();
//        String fieldName = f[0].getName();
//        System.out.println(fieldName);
        // 获取所有Field
//        Field[] fs = c.getDeclaredFields();
//        System.out.println(fs.length);
//        for (Field s:fs){
//            System.out.println(s.getType());
//        }
        // 获取对象
        Object o = c.newInstance();
        // 获取属性
        Field ff = c.getDeclaredField("name");
        // 打破封装（可能有安全问题）
        ff.setAccessible(true);
        // 赋值
        ff.set(o, "封装已打破");
        // 读取
        System.out.println(ff.get(o));
        // 通过反射调用方法
        Method method = c.getDeclaredMethod("setName", String.class);
        method.invoke(o, "yh");
        System.out.println(ff.get(o));
        // 通过反射调用构造方法
        Constructor con = c.getDeclaredConstructor(int.class, String.class, int.class, boolean.class);
        o = con.newInstance(110, "yhh", 20, true);
        System.out.println(ff.get(o));
    }
}
