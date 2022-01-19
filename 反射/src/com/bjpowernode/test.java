package com.bjpowernode;

public class test {
    /**
     * 反射机制，通过反射机制可以操作字节码文件
     * 类似于黑客技术，可以读或修改字节码文件
     * 通过反射可以操作代码片段（class文件）
     *
     * 在哪个包下：在reflect包下
     * java.lang.class:代表整个字节码，代表一个类型
     * java.lang.reflect.Method:代表字节码中的构造方法字节码
     * java.lang.Constructor:代表构造方法字节码
     * java.lang.Field:代表字节码中的属性字节码
     *
     * 要操作一个类的字节码，需要首先获取到这个字节码
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        /**
         * 获取字节码文件的第一种方式
         * Class.forName()
         * 1、Class类中的静态方法
         * 2、方法的参数是一个字符串
         * 3、字符串需要是一个完整类名
         * 4、字符串类名必须带有包名，即使是lang包也不能省略
         */
        Class c1 = Class.forName("java.lang.String");
        Class c2 = Class.forName("java.util.Date");
        Class c3 = Class.forName("java.lang.Integer");
        /**
         * 获取字节码文件的第二种方式
         * Object中有getClass()方法
         */
        String s1 = new String("abc");
        Class c4 = s1.getClass();
//        System.out.println(c1 == c4); true 内存地址一致，字节码文件在方法区只装载一份
        /**
         * 获取字节码文件的第三种方式
         * Java语言中任何一种类型，包括基本数据类型，它都有.class属性
         */
        Class c5 = String.class;
        Class c6 = int.class;
//        System.out.println(c4 == c5);
        /**
         * 通过反射机制获取Class对象，通过Class来实例化对象
         */
        Class c7 = com.bjpowernode.user.class;
        // newInstance会调用user这个类的无参数构造方法，完成对象的创建，必须保证无参构造方法的存在
        Object obj = c7.newInstance();
        System.out.println(obj);
        /**
         * 使用反射机制创建对象有什么好处
         * 优点在于它的灵活性，符合OCP开闭原则：对扩展开放、对修改关闭
         */
    }
}
