package 反射;

public class Example01 {
    /**
     * 反射机制可以操作字节码文件，通过反射机制可以操作代码片段
     * java.lang.reflect.*
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        String str = new String();
        str = "aaa";
        Class c1 = str.getClass();
        Class c2 = String.class;
        Class c3 = Class.forName("反射.User");
//        User u = (User) c3.newInstance();
        c3.newInstance();
//        System.out.println(u.aaa());
        System.out.println(str);
    }
}
