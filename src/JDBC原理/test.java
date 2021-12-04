package JDBC原理;

/*
    Java程序员面向接口编程
 */
public class test {
    public static void main(String[] args) throws Exception {
        JDBC jdbc = new Oracle();
        jdbc.getConnection();
        // 创建对象也可以通过反射机制
        Class c = Class.forName("JDBC原理.MySQL");
        JDBC jdbc1 = (JDBC) c.newInstance();
        jdbc1.getConnection();
    }
}
