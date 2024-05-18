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

        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Tải driver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=BanLinhKienDienTu;integratedSecurity=false;encrypt=false;trustServerCertificate=true;";
            String user = "sa";
            String password = "123";
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Kết nối thất bại: " + e.getMessage(), e);
        }
        return con;
    }
}
