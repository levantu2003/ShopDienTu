/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.QuanLy;

import DAO.XacThuc.ConnectCSDL;
import Model.KhachHang;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author Kaiser
 */
public class KhachHangDAO {

    public ArrayList<KhachHang> getListKhachHang() {
        ArrayList<KhachHang> list = new ArrayList<>();

        try {
            String sql = "SELECT MaKH, TenKH, GioiTinh, Sdt, DiaChi FROM KhachHang";
            Connection con = ConnectCSDL.OpenConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setSdt(rs.getString("Sdt"));
                kh.setDiaChi(rs.getString("DiaChi"));
                list.add(kh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public KhachHang timTheoMaKH(String MaKH) throws Exception {
        String sql = "SELECT * FROM KhachHang WHERE MaKH = ?";

        try {
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, MaKH);

            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    KhachHang kh = new KhachHang();
                    kh.setMaKH(rs.getString("MaKH"));
                    kh.setTenKH(rs.getString("TenKH"));
                    kh.setGioiTinh(rs.getString("GioiTinh"));
                    kh.setSdt(rs.getString("Sdt"));
                    kh.setDiaChi(rs.getString("DiaChi"));
                    return kh;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int addKhachHang(KhachHang kh) {
        try {
            String sql = "INSERT INTO KhachHang (MaKH, TenKH, GioiTinh, Sdt, DiaChi) VALUES (?, ?, ?, ?, ?)";
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getTenKH());
            ps.setString(3, kh.getGioiTinh());
            ps.setString(4, kh.getSdt());
            ps.setString(5, kh.getDiaChi());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int removeKhachHang(String MaKH) {
        try {
            String sql = "DELETE FROM KhachHang WHERE MaKH = ?";
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, MaKH);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updateKhachHang(KhachHang kh) {
        try {
            String sql = "UPDATE KhachHang SET TenKH=?, GioiTinh=?, Sdt=?, DiaChi=? WHERE MaKH=?";
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getGioiTinh());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getDiaChi());
            ps.setString(5, kh.getMaKH());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
