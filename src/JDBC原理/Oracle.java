package JDBC原理;

/*
    Oracle厂家实现JDBC接口
 */
public class Oracle implements JDBC {

    @Override
    public void getConnection() {
        System.out.println("连接Oracle数据库成功！");
    }
}
/*
    Oracle驱动
 */