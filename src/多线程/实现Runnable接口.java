package 多线程;

/*
    第二种实现方式
    这种方式更常用，因为它面向接口编程，更加灵活，还可以实现其它抽象类
 */
public class 实现Runnable接口 {
    public static void main(String[] args) {
        // 创建一个可运行的对象
//        MyRunnable r = new MyRunnable();
        // 将可运行对象封装成一个线程对象
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    System.out.println("分支线程--->" + i);
                }
            }
        });
        // 启动线程
        t.start();
        for (int i = 1; i <= 1000; i++) {
            System.out.println("主线程--->" + i);
        }
    }
}

// 这并不是一个线程类，是一个可运行的类。它还不是一个线程。
//class MyRunnable implements Runnable {
//    @Override
//    public void run() {
//        for (int i = 1; i <= 1000; i++) {
//            System.out.println("分支线程--->" + i);
//        }
//    }
//}