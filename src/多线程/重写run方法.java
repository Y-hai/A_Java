package 多线程;
/*
    多线程第一种实现方法：重写Thread类的run方法，不推荐
    代码永远都是从上到下顺序执行，return永远是方法的最后一句
 */
public class 重写run方法 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
//        myThread.run(); // 直接调用run方法是单线程
        myThread.start(); // 会开辟新的栈空间
        for (int i = 1; i <= 1000; i++) {
            System.out.println("主线程--->" + i);
        }
        System.exit(0);
    }
}

// 重写Thread抽象类中的run方法
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println("分支线程--->" + i);
        }
    }
}