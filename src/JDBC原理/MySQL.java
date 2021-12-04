package JDBC原理;

/*
    MySQL厂家负责编写实现JDBC接口
 */
public class MySQL implements JDBC {
    @Override
    public void getConnection() {
        // 这段代码涉及到MySQL底层数据的实现
        System.out.println("MySQL数据库连接成功！");
    }
}
/*
    实现类叫做驱动，这个类叫MySQL驱动
 */