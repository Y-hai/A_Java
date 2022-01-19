package 实现生产者和消费者方法;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();
        // 生产者
        Thread t1 = new Thread(new Producer(list));
        // 消费者
        Thread t2 = new Thread(new Consumer(list));
        // 线程命名
        t1.setName("生产者线程");
        t2.setName("消费者线程");
        // 线程启动
        t1.start();
        t2.start();
    }
}

// 生产线程
class Producer implements Runnable {
    private List list;

    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        // 一直生产
        while (true) {
            // 给仓库对象加锁
            synchronized (list) {
                if (list.size() >= 1) {
                    // 仓库已经满了，生产线程进入等待状态
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 开始生产
                Object obj = new Object();
                list.add(obj);
                System.out.println(Thread.currentThread().getName() + "--->" + obj);
                // 唤醒消费者
                list.notifyAll();
            }
        }
    }
}

// 消费线程
class Consumer implements Runnable {
    private List list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        // 一直消费
        while (true) {
            synchronized (list) {
                if (list.size() == 0) {
                    // 仓库已经空了，消费线程进入等待状态
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 开始消费
                Object obj = list.remove(0);
                System.out.println(Thread.currentThread().getName() + "--->" + obj);
                // 唤醒生产者
                list.notifyAll();
            }
        }
    }
}
