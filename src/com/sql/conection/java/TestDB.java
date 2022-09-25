package com.sql.conection.java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB {

    public static void main(String args[]) {
        // 设置连接数据库的各个参数.
        String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=AdventureWorks;integratedSecurity=true;";
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=dbhuangbangcheng;user=sa;password=hbc3324126";//以sa身份连接数据库

        // 声明JDBC对象
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 建立数据库连接.
            System.out.println("尝试建立数据库连接.");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
            System.out.println("数据库连接成功!");

            //创建SQL语删除student表中学号为'200215130'的学生记录
            String SQL = "DELETE FROM student WHERE Sno = '200215130' ";
            stmt = con.createStatement();
            stmt.executeUpdate(SQL);

            //创建SQL语句向student表中插入一条学号为'200215130'的学生记录
            SQL = "INSERT INTO student(Sno, Sname, Ssex, Sage, Sdept) VALUES('200215130', '陈冬', '男', 21, 'MA')";
            stmt.executeUpdate(SQL);

            //创建SQL语句查询student表中的所有记录并返回查询结果
            SQL = "SELECT * FROM student";
            rs = stmt.executeQuery(SQL);

            //遍历和打印SQL语句的查询结果
            System.out.println("学号"+"\t\t"+"姓名"+"\t"+"性别"+"\t"+"年龄"+"\t"+"所在系");
            while (rs.next()) {
                System.out.println(rs.getString("Sno")+"\t"+rs.getString("Sname")+"\t"
                        +rs.getString("Ssex")+"\t"+rs.getString("Sage")+"\t"+rs.getString("Sdept"));
            }
        }

        //处理和打印程序异常
        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            if (rs != null)
                try {
                    rs.close(); //关闭查询结果集句柄
                } catch (Exception e) {
                }
            if (stmt != null)
                try {
                    stmt.close();  //关闭语句句柄
                } catch (Exception e) {
                }
            if (con != null)
                try {
                    con.close();   //关闭数据库连接
                } catch (Exception e) {
                }
        }
    }
}



