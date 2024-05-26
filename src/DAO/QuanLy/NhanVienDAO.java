/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.QuanLy;

import DAO.XacThuc.ConnectCSDL;
import Model.NhanVien;
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
public class NhanVienDAO {

    public int addNhanVien(NhanVien nv) {
        try {
            String sql = "INSERT INTO NhanVien(MaNV,HoTenNV,GioiTinh,NgaySinh,Sdt,DiaChi,MaCV)"
                    + "VALUES(?,?,?,?,?,?,?)";
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getHoTenNV());
            ps.setString(3, nv.getGioiTinh());
            ps.setDate(4, new java.sql.Date(nv.getNgaySinh().getTime()));
            ps.setString(5, nv.getSdt());
            ps.setString(6, nv.getDiaChi());
            ps.setString(7, nv.getMaCV());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int removeNhanVien(String MaNV) {
        try {
            String sql = "DELETE FROM NhanVien WHERE MaNV = ?";
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, MaNV);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updateNhanVien(NhanVien nv) {
        try {
            String sql = "UPDATE NhanVien set HoTenNV=?, GioiTinh=?, NgaySinh=?, Sdt=?, DiaChi=?, MaCV=? "
                    + "WHERE MaNV=?";
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getHoTenNV());
            ps.setString(2, nv.getGioiTinh());
            ps.setDate(3, new java.sql.Date(nv.getNgaySinh().getTime()));
            ps.setString(4, nv.getSdt());
            ps.setString(5, nv.getDiaChi());
            ps.setString(6, nv.getMaCV());
            ps.setString(7, nv.getMaNV());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public NhanVien searchNhanVien(String manv) {
        String sql = "SELECT nv.MaNV,nv.HoTenNV,nv.GioiTinh,nv.NgaySinh,nv.Sdt,nv.DiaChi,nv.MaCV,cv.TenCV "
                + "FROM NhanVien nv "
                + "INNER JOIN ChucVu cv ON nv.MaCV = cv.MaCV "
                + "WHERE nv.MaNV = ?";
        try {
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, manv);

            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    NhanVien nv = new NhanVien();
                    nv.setMaNV(rs.getString("MaNV"));
                    nv.setHoTenNV(rs.getString("HoTenNV"));
                    nv.setGioiTinh(rs.getString("GioiTinh"));
                    nv.setNgaySinh(rs.getDate("NgaySinh"));
                    nv.setSdt(rs.getString("Sdt"));
                    nv.setDiaChi(rs.getString("DiaChi"));
                    nv.setMaCV(rs.getString("TenCV"));
                    return nv;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<NhanVien> getListNhanVien() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            String sql = "SELECT nv.MaNV,nv.HoTenNV,nv.GioiTinh,nv.NgaySinh,nv.Sdt,nv.DiaChi,cv.TenCV "
                    + "FROM NhanVien nv "
                    + "INNER JOIN ChucVu cv ON nv.MaCV = cv.MaCV";
            Connection con = ConnectCSDL.OpenConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setHoTenNV(rs.getString("HoTenNV"));
                nv.setSdt(rs.getString("Sdt"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setMaCV(rs.getString("TenCV"));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
