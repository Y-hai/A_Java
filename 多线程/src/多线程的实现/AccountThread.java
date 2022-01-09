package 多线程的实现;

public class AccountThread extends Thread {
    // 两个线程必须共享一个对象
    private Account act;
    // 通过构造方法传过来一个对象
    public AccountThread(Account act) {
        this.act = act;
    }

    public void run() {
        // run方法的执行表示取款操作
        // 假设取款5000
        double money = 5000;
        // 取款
        act.withdraw(money);
        System.out.println("账户"+ act.getActno() +"取款成功，余额" + act.getBalance());
    }
}
