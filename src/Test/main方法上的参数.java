package Test;

public class main方法上的参数 {
    /* 关于main方法上的参数
        谁负责调用main方法？ JVM
        JVM调用main方法时，会自动传一个String数组过来
     */
    public static void main(String[] args) {
            // JVM默认传递过来的这个数组对象的长度？默认0
            // 通过测试得出：args不是null。
            System.out.println("args数组的长度：" + args.length);
        // args数组主要是用来接收用户传递过来的参数的，比如验证用户名、密码
        if (args.length != 2) {
            System.out.println("程序运行失败，请输入参数：用户名、密码");
            return;
        }
        // 注意："yh"在前可以预防空指针异常
        if ("yh".equals(args[0]) && "123".equals(args[1])) {
            System.out.println("登陆成功，欢迎" + args[0] + "使用使用该系统");
        } else {
            System.out.println("用户名或密码错误，请重新输入");
        }
        main方法上的参数 m = new main方法上的参数();
        System.out.println(m.toString());
    }
}
