package 多线程的实现;

public class Example01 {
    public static void main(String[] args) {
        // 创建账户对象，这个对象是共享的
        Account act = new Account("act-001", 10000);
        // 创建两个线程
        Thread t1 = new AccountThread(act);
        Thread t2 = new AccountThread(act);
        // 线程命名
        t1.setName("t1");
        t2.setName("t2");
        // 启动线程取款
        t1.start();
        t2.start();
    }
}
