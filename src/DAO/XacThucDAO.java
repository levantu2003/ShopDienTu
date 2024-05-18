/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Kaiser
 */
public class XacThucDAO {

    public NguoiDung dangNhap(String Email, String MatKhau) {
        NguoiDung nd = null;

        try {
            Connection con = ConnectCSDL.OpenConnection();
            String sql = "Select * from NguoiDung where Email = ? and MatKhau = ?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, Email);
            pre.setString(2, MatKhau);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                nd = new NguoiDung();
                nd.setMaND(rs.getString("MaND"));
                nd.setEmail(rs.getString("Email"));
                nd.setMatKhau(rs.getString("MatKhau"));
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nd;
    }
}
