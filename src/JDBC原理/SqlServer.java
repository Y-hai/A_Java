package JDBC原理;

/*
    sqlserver厂家实现JDBC接口
 */
public class SqlServer implements JDBC {
    @Override
    public void getConnection() {
        System.out.println("连接sqlserver数据库成功！");
    }
}
/*
    SqlServer驱动
 */