package com.bjpowernode;

public class reflectTest04 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class c1 = My_class.class; // 不加载类
        Class c2 = Class.forName("com.bjpowernode.My_class");
//        Object o = c1.newInstance();
//        System.out.println(o);
        /***
         * 聊聊类加载器
         * 什么是类加载器：专门负责加载类的命令/工具。 ClassLoader
         *
         * JDK中自带了三个类加载器
         * 启动类加载器（父加载器）
         * 扩展类加载器（母加载器）
         * 应用类加载器
         *
         * String s = "123";
         * 代码在开始执行之前，会将所需要的全部类加载到JVM中
         * 通过类加载器加载，看到以上代码，类加载器会找String.class文件，找到就加载
         * 1.首先通过启动类加载器加载，注意启动类加载器专门加载：rt.jar（Java核心jar包）
         * 2.启动类加载不到的时候，扩展类加载器专门加载 ext/*.jar，（Java的扩展jar包）
         * 3.如果扩展类找不到，会通过应用类加载器加载classpath中的jar包 （classpath在系统变量中设置）
         *
         * 双亲委派机制：顺序加载类的机制，这是一种安全机制，防止类的加载混乱
         * 优先从启动类加载器中加载，其次从扩展类加载器中加载，最后从应用类加载器中加载，直到加载到为止
         */
    }
}

class My_class{
    static {
        // 换句话说，如果你只想执行一个类的静态代码块，你只需要执行forName方法
        System.out.println("Myclass静态代码块执行了，说明类被加载到方法区");
    }
}
