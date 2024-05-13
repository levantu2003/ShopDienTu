/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author latu2
 */
public class ConnectCSDL {
    public static Connection OpenConnection() throws Exception {
        
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Tải...");
            String url ="jdbc:sqlserver://localhost:1433;databasename=BanLinhKienDienTu;integratedSecurity=false;encrypt=false;trustServerCertificate=true;";
            String user ="sa";
            String password ="L@tu4923";
            Connection con = DriverManager.getConnection(url,user,password);
            System.out.println("Kết nối...");
            return con;
    
    }
}
