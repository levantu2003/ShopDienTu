/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.XacThuc;

import Model.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Kaiser
 */
public class DangKyDAO {

    public boolean themNguoiDung(NguoiDung nguoiDung) {
        try {
            Connection con = ConnectCSDL.OpenConnection();
            String query = "INSERT INTO NguoiDung (MaND, Email, MatKhau) VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, nguoiDung.getMaND());
            statement.setString(2, nguoiDung.getEmail());
            statement.setString(3, nguoiDung.getMatKhau());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
