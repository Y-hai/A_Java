package com.bjpowernode;

import java.util.ResourceBundle;

// 验证反射机制的灵活性
public class reflectTest03 {
    public static void main(String[] args) throws Exception {
        // 通过字符流读取配置文件
        /**
         * 配置文件要放在类路径下
         * Thread.currentThread() // 是获取当前线程对象
         * getContextClassLoader() // 是线程对象的方法，可以获取到当前线程的类加载器对象
         * getResource() // 这是类加载器对象的方法，当前线程的类加载器默认从类的根路径下加载资源
         */
        // 第一种
//        BufferedReader br = new BufferedReader(new FileReader("反射/src/test.properties"));
        // 第二种
//        InputStream reader = Thread.currentThread().getContextClassLoader().
//                getResourceAsStream("test.properties");
        /**
         * 最快拿到properties配置文件的方法，ResourceBundle绑定配置文件，必须在类路径下
         */
        ResourceBundle bundle = ResourceBundle.getBundle("test");
        // 创建属性类对象Map
//        Properties pro = new Properties();
        // 加载
//        pro.load(reader);
        // 通过key获取values
//        String className = pro.getProperty("className");
        // 通过反射创建对象
        String className = bundle.getString("className");
        Class c1 = Class.forName(className);
        Object o = c1.newInstance();
        System.out.println(o);
    }
}
