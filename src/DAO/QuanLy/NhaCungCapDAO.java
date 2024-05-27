/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.QuanLy;

import DAO.XacThuc.ConnectCSDL;
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
            String sql = "INSERT INTO NhaCungCap(MaNCC,TenNCC,DiaChiNCC)"
                    + "VALUES(?,?,?)";
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getMaNCC());
            ps.setString(2, ncc.getTenNCC());
            ps.setString(3, ncc.getDiaChi());
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
            String sql = "UPDATE NhaCungCap set TenNCC=?,DiaChiNCC=? "
                    + "WHERE MaNCC=?";
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ncc.getTenNCC());
            ps.setString(2, ncc.getDiaChi());
            ps.setString(3, ncc.getMaNCC());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public NhaCungCap searchNhaCungCap(String mancc) throws Exception {
        String sql = "SELECT * FROM NhaCungCap WHERE MaNCC = ?";

        try {
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, mancc);

            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    NhaCungCap ncc = new NhaCungCap();
                    ncc.setMaNCC(rs.getString("MaNCC"));
                    ncc.setTenNCC(rs.getString("TenNCC"));
                    ncc.setDiaChi(rs.getString("DiaChiNCC"));
                    return ncc;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
//    public ArrayList<NhaCungCap> searchNhaCungCap(String DuLieu) {
//        ArrayList<NhaCungCap> list = new ArrayList<>();
//        try {
//            String sql = "SELECT * "
//                    + "FROM NhaCungCap "
//                    + "WHERE TenNCC LIKE N'%" + DuLieu + "%'";
//            Connection con = ConnectCSDL.OpenConnection();
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                String mancc = rs.getString("MaNCC");
//                String tenncc = rs.getString("TenNCC");
//                String diachi = rs.getString("DiaChiNCC");
//                NhaCungCap ncc = new NhaCungCap(mancc, tenncc,diachi);
//                list.add(ncc);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
    
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
                ncc.setDiaChi(rs.getString("DiaChiNCC"));
                list.add(ncc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
