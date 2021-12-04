package JDBC原理;
/*
    SUN公司制定接口，数据库厂家实现接口
 */
public interface JDBC {
    /*
        创建连接数据库的方法
     */
    void getConnection();
}
