package 多线程的实现;

public class Account {
    // 账号
    private String actno;
    // 余额
    private double balance;

    public Account() {
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getActno() {
        return actno;
    }

    public double getBalance() {
        return balance;
    }

    public Account(String actno, double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    // 取款的方法，synchronized出现在实例方法上相当于把方法中所有内容用synchronized括起来，传参this
    public synchronized void withdraw(double money) {
        // 两个对象处理同一个对象，必须同步
        // synchronized括号里的对象很重要
        /**
         * 排他锁
         * 线程同步代码块
         * this必须是待同步线程共享的对象，字符串常量池
         * 想象对String类型的局部变量操作时不妨使用StringBuilder，因为不会有线程安全的问题，线程不用每次去锁池里获取锁
         * 即可进入运行状态，可以提高效率
         * 如果是对成员变量操作的话，如果是多线程并发，为了线程安全必须使用StringBuffer
         * synchronization的三种用法：
         * 1. 使用synchronization代码块
         * 2. 在实例方法上加载，对象锁
         * 3. 在静态方法上加，这是类锁，一个类只有一把，抢到类锁才能执行类的静态方法
         */
        synchronized (this) {
            double before = this.getBalance();
            double after = before - money;
            // 模拟网络延迟，破坏操作的原子性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setBalance(after);
        }
    }
}
