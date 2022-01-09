package JDBC原理;

import java.sql.*;

public class JDBCtest {
    // 连接数据库的信息最好放在配置文件中
    public static void main(String[] args) {
        // 1、注册驱动
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            // 第一种注册驱动的写法
//            Driver driver = new com.mysql.jdbc.Driver();
//            DriverManager.registerDriver(driver);
            // 第二种注册驱动的方法，通过反射机制加载类就行，因为代码在静态代码块里
            Class.forName("com.mysql.jdbc.Driver");
            // 2、获取连接
            String url = "jdbc:mysql://127.0.0.1:3306/bjpowernode";
            String user = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("数据库连接对象 = " + conn);
            // 数据库连接对象 = com.mysql.jdbc.JDBC4Connection@5387f9e0
            // 3、获取数据库操作对象(Statement专门执行sql语句的)
            stmt = conn.createStatement();

            // 4、执行sql
            String sql = "insert into aaa.properties(name) values('yh')"; // 注意结尾不要写分号
            String sql1 = "select empno, ename, sal from emp order by sal asc";
//            int num = stmt.executeUpdate(sql); // 专门执行DML语句
//            System.out.println(num == 1 ? "保存成功" : "保存失败");
            rs = stmt.executeQuery(sql1);
            // 5、处理查询结果集
            System.out.println("empno\tename\tsal");
            while (rs.next()) {
                // 可以用列名，也可以用列下标
                int empno = rs.getInt(1);
                String enam = rs.getString("ename");
                double sal = rs.getDouble("sal");
                System.out.println(empno + "\t" + enam + "\t" + sal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 6、释放资源
            try {
                if (rs != null) rs.close(); // 释放查询结果集
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (stmt != null) stmt.close(); // 释放数据库操作对象
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close(); // 释放数据库连接对象
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

