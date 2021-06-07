/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author fbrcmmelo
 */
public class ConnectionFactory {
     public static Connection getConnection() throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/rappdinhobd?autoReconnect=true&useSSL=false", "root", "123456");
        } catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception{
        close(conn, stmt, rs);
    }
    
    public static void closeConnection(Connection conn, Statement stmt) throws Exception{
        close(conn, stmt, null);
    }
    
    public static void closeConnection(Connection conn) throws Exception{
        close(conn, null, null);
    }
    
    private static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception{
        try{
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
}
