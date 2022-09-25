package com.sql.conection.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Test06 {
	public static void main(String args[]) {  
        // �����������ݿ�ĸ�������.  
        String connectionUrl = "jdbc:sqlserver://localhost:1433;"  
                + "databaseName=AdventureWorks;integratedSecurity=true;";  
          String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=jdbc;user=sa;password=hbc3324126";//��sa����������ݿ� 
  
        // ����JDBC����  
        Connection con = null;  
        Statement stmt = null;  
        ResultSet rs = null;  
  
        try {  
            // �������ݿ�����.  
            System.out.println("���Խ������ݿ�����.");  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            con = DriverManager.getConnection(url);  
            System.out.println("���ݿ����ӳɹ�!");
            
            String  SQL = "INSERT INTO tb_count(NAME,  sex,email, birthday) VALUES('Jack',  '��', 'jack@126.com', '1980-01-04')";
               
            stmt = con.createStatement();  
            stmt.executeUpdate(SQL); 
        }
	
            
          //����ʹ�ӡ�����쳣  
            catch (Exception e) {  
                e.printStackTrace();  
            }  
      
            finally {  
                if (rs != null)  
                    try {  
                        rs.close(); //�رղ�ѯ�������� 
                    } catch (Exception e) {  
                    }  
                if (stmt != null)  
                    try {  
                        stmt.close();  //�ر������
                    } catch (Exception e) {  
                    }  
                if (con != null)  
                    try {  
                        con.close();   //�ر����ݿ�����
                    } catch (Exception e) {  
                    }  
            }  
        }  
    } 

