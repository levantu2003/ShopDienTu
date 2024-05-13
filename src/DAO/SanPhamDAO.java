/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.SanPham;
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
public class SanPhamDAO {

    public int addSanPham(SanPham sp) {
        try {
            String sql = "INSERT INTO SanPham(MaSP,TenSP,NgaySanXuat,GiaNhap,GiaBan,TrangThai,MaLoai)"
                    + "VALUES(?,?,?,?,?,?,?)";
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSP());
            ps.setDate(3, new java.sql.Date(sp.getNgaySanXuat().getTime()));
            ps.setDouble(4, sp.getGiaNhap());
            ps.setDouble(5, sp.getGiaBan());
            ps.setInt(6, sp.getTrangThai());
            ps.setString(7, sp.getMaLoai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int removeSanPham(String MaSP) {
        try {
            String sql = "DELETE FROM SanPham WHERE MaSP = ?";
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, MaSP);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updateSanPham(SanPham sp) {
        try {
            String sql = "UPDATE SanPham set TenSP=?,NgaySanXuat=?,GiaNhap=?,GiaBan=?,TrangThai=?,MaLoai=?"
                    + " WHERE MaSP=?";
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sp.getTenSP());
            ps.setDate(2, new java.sql.Date(sp.getNgaySanXuat().getTime()));
            ps.setDouble(3, sp.getGiaNhap());
            ps.setDouble(4, sp.getGiaBan());
            ps.setInt(5, sp.getTrangThai());
            ps.setString(6, sp.getMaLoai());
            ps.setString(7, sp.getMaSP());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<SanPham> searchSanPham(String DuLieu) {
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            float so = 0;
            if (DuLieu.isEmpty()) {
                so = 0;
            } else if (DuLieu.chars().allMatch(Character::isDigit)) {
                so = Float.parseFloat(DuLieu);
            }
            String sql = "SELECT sp.MaSP, sp.TenSP, sp.NgaySanXuat, sp.GiaNhap, sp.GiaBan "
                    + "FROM SanPham sp "
                    + "INNER JOIN LoaiSanPham lsp ON sp.MaLoai = lsp.MaLoai "
                    + "WHERE sp.MaSP LIKE N'%" + DuLieu + "%' OR sp.TenSP LIKE N'%" + DuLieu + "%' OR lsp.TenLoai LIKE N'%" + DuLieu + "%'";
            
            Connection con = ConnectCSDL.OpenConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String MaSP = rs.getString("MaSP");
                String TenSP = rs.getString("TenSP");
                Date NgaySanXuat = rs.getDate("NgaySanXuat");
                float GiaNhap = rs.getFloat("GiaNhap");
                float GiaBan = rs.getFloat("GiaBan");
                SanPham cd = new SanPham(MaSP, TenSP, NgaySanXuat, GiaNhap, GiaBan);
                list.add(cd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<SanPham> getListSanPham() {
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM SanPham";
            Connection con = ConnectCSDL.OpenConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setMaLoai(rs.getString("MaLoai"));
                sp.setNgaySanXuat(rs.getDate("NgaySanXuat"));
                sp.setGiaNhap(rs.getFloat("GiaNhap"));
                sp.setGiaBan(rs.getFloat("GiaBan"));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
