/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.NhaCungCap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author latu2
 */
public class NhaCungCapDAO {

    public int addNhaCungCap(NhaCungCap ncc) {
        try {
            String sql = "INSERT INTO NhaCungCap(MaNCC,TenNCC,Sdt,DiaChi,Email)"
                    + "VALUES(?,?,?,?,?)";
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getMaNCC());
            ps.setString(2, ncc.getTenNCC());
            ps.setString(3, ncc.getSdt());
            ps.setString(4, ncc.getDiaChi());
            ps.setString(5, ncc.getEmail());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int removeNhaCungCap(String MaNCC) {
        try {
            String sql = "DELETE FROM NhaCungCap WHERE MaNCC = ?";
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, MaNCC);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updateNhaCungCap(NhaCungCap ncc) {
        try {
            String sql = "UPDATE NhaCungCap set TenNCC=?,Sdt=?,DiaChi=?,Email=? "
                    + "WHERE MaNCC=?";
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getTenNCC());
            ps.setString(2, ncc.getSdt());
            ps.setString(3, ncc.getDiaChi());
            ps.setString(4, ncc.getEmail());
            ps.setString(5, ncc.getMaNCC());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<NhaCungCap> searchNhaCungCap(String DuLieu) {
        ArrayList<NhaCungCap> list = new ArrayList<>();
        try {
            String sql = "SELECT * "
                    + "FROM NhaCungCap "
                    + "WHERE MaNCC LIKE N'%" + DuLieu + "%' OR TenNCC LIKE N'%" + DuLieu + "%' OR Sdt LIKE N'%" + DuLieu + "%' OR DiaChi LIKE N'%" + DuLieu + "%' OR Email LIKE N'%" + DuLieu + "%'; ";
            Connection con = ConnectCSDL.OpenConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String mancc = rs.getString("MaNCC");
                String tenncc = rs.getString("TenNCC");
                String sdt = rs.getString("Sdt");
                String diachi = rs.getString("DiaChi");
                String emial = rs.getString("Email");
                NhaCungCap ncc = new NhaCungCap(mancc, tenncc, sdt, diachi, emial);
                list.add(ncc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<NhaCungCap> getListNhaCungCap(){
        ArrayList<NhaCungCap> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM NhaCungCap";
            Connection con = ConnectCSDL.OpenConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getString("MaNCC"));
                ncc.setTenNCC(rs.getString("TenNCC"));
                ncc.setSdt(rs.getString("Sdt"));
                ncc.setDiaChi(rs.getString("DiaChi"));
                ncc.setEmail(rs.getString("Email"));
                list.add(ncc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
