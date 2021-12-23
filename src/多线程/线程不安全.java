package 多线程;

public class 线程不安全 {
    public static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) { // 创建两个线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 每个线程中让count自增100次
                    for (int i = 0; i < 100; i++) {
                        count++;
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
