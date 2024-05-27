/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.XacThuc;

import Model.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Kaiser
 */
public class DangNhapDAO {

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

    public String getNewMaND() {
        try {
            Connection con = ConnectCSDL.OpenConnection();
            String query = "SELECT MAX(CAST(SUBSTRING(MaND, 3, LEN(MaND)) AS INT)) AS maxMaND FROM NguoiDung";
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            int maxMaND = 0;
            if (rs.next()) {
                maxMaND = rs.getInt("maxMaND");
            }
            String newMaND = "ND" + String.format("%02d", maxMaND + 1);
            return newMaND;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
