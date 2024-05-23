/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.QuanLy;

import DAO.XacThuc.ConnectCSDL;
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
            String sql = "INSERT INTO SanPham(MaSP,TenSP,GiaBan,MoTa,NgaySanXuat,TinhTrang,HinhAnh,MaLoai)"
                    + "VALUES(?,?,?,?,?,?,?,?)";
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSP());
            ps.setDouble(3, sp.getGiaBan());
            ps.setString(4, sp.getMoTa());
            ps.setDate(5, new java.sql.Date(sp.getNgaySanXuat().getTime()));
            ps.setInt(6, sp.getTinhTrang());
            ps.setBytes(7, sp.getHinhAnh());
            ps.setString(8, sp.getMaLoai());
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
            String sql = "UPDATE SanPham set TenSP=?,GiaBan=?,MoTa=?,NgaySanXuat=?,TinhTrang=?,HinhAnh=?,MaLoai=?"
                    + " WHERE MaSP=?";
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sp.getTenSP());
            ps.setDouble(2, sp.getGiaBan());
            ps.setString(3, sp.getMoTa());
            ps.setDate(4, new java.sql.Date(sp.getNgaySanXuat().getTime()));
            ps.setInt(5, sp.getTinhTrang());
            ps.setBytes(6, sp.getHinhAnh());
            ps.setString(7, sp.getMaLoai());
            ps.setString(8, sp.getMaSP());
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
            String sql = "SELECT MaSP,TenSP,GiaBan,NgaySanXuat,TinhTrang,HinhAnh "
                    + "FROM SanPham "
                    + "WHERE TenSP LIKE N'%" + DuLieu + "%' ;";

            Connection con = ConnectCSDL.OpenConnection();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String MaSP = rs.getString("MaSP");
                String TenSP = rs.getString("TenSP");
                Float GiaBan = rs.getFloat("GiaBan");
                Date NgaySanXuat = rs.getDate("NgaySanXuat");
                int TinhTrang = rs.getInt("TinhTrang");
                byte[] HinhAnh = rs.getBytes("HinhAnh");
                SanPham sp = new SanPham(MaSP, TenSP, GiaBan, NgaySanXuat, TinhTrang, HinhAnh);
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<SanPham> getListSanPham() {
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            String sql = "SELECT MaSP,TenSP,GiaBan,NgaySanXuat,TinhTrang,HinhAnh FROM SanPham";
            Connection con = ConnectCSDL.OpenConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setGiaBan(rs.getFloat("GiaBan"));
                sp.setNgaySanXuat(rs.getDate("NgaySanXuat"));
                sp.setTinhTrang(rs.getInt("TinhTrang"));
                sp.setHinhAnh(rs.getBytes("HinhAnh"));

                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public SanPham timTheoID(String MaSV) throws Exception {
        String sql = "Select * From SanPham where MaSP = ?";
        try {
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, MaSV);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    SanPham sp = new SanPham();
                    sp.setMaSP(rs.getString(1));
                    sp.setTenSP(rs.getString(2));
                    sp.setGiaBan(Float.parseFloat(rs.getString(3)));
                    sp.setNgaySanXuat(rs.getDate(5));
                    sp.setTinhTrang(rs.getInt(6));
                    sp.setHinhAnh(rs.getBytes(7));
                    return sp;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Trả về null nếu không tìm thấy
    }
}
