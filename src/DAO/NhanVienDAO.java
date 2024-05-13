/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
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
            String sql = "INSERT INTO NhanVien(MaNV,Sdt,DiaChi,NgaySinh,GioiTinh,MaCV)"
                    + "VALUES(?,?,?,?,?,?)";
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getSdt());
            ps.setString(3, nv.getDiaChi());
            ps.setDate(4, new java.sql.Date(nv.getNgaySinh().getTime()));
            ps.setString(5, nv.getGioiTinh());
            ps.setString(6, nv.getMaCV());
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
            String sql = "UPDATE NhanVien set Sdt=? ,DiaChi=? ,NgaySinh=? ,GioiTinh=? ,MaCV=? "
                    + "WHERE MaNV=?";
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getSdt());
            ps.setString(2, nv.getDiaChi());
            ps.setDate(3, new java.sql.Date(nv.getNgaySinh().getTime()));
            ps.setString(4, nv.getGioiTinh());
            ps.setString(5, nv.getMaCV());
            ps.setString(6, nv.getMaNV());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<NhanVien> searchNhanVien(String DuLieu) {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            String sql = "SELECT * "
                    + "FROM NhanVien nv "
                    + "INNER JOIN ChucVu cv ON nv.MaCV = cv.MaCV "
                    + "WHERE nv.MaNV LIKE N'%" + DuLieu + "%' OR nv.Sdt LIKE N'%" + DuLieu + "%' OR nv.DiaChi LIKE N'%" + DuLieu + "%' OR nv.NgaySinh LIKE N'%" + DuLieu + "%' OR nv.GioiTinh LIKE N'%" + DuLieu + "%' OR cv.TenCV LIKE N'%" + DuLieu + "%'";
            Connection con = ConnectCSDL.OpenConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String manv = rs.getString("MaNV");
                String sdt = rs.getString("Sdt");
                String diachi = rs.getString("DiaChi");
                Date ngaysinh = rs.getDate("NgaySinh");
                String gioitinh = rs.getString("GioiTinh");
                String macv = rs.getString("MaCV");
                NhanVien ncc = new NhanVien(manv, sdt, diachi,gioitinh,macv,ngaysinh);
                list.add(ncc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<NhanVien> getListNhanVien() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            String sql = "SELECT nv.MaNV,nv.Sdt,nv.DiaChi,nv.NgaySinh,nv.GioiTinh,cv.TenCV "+
                    "FROM NhanVien nv "+
                    "INNER JOIN ChucVu cv ON nv.MaCV = cv.MaCV";
            Connection con = ConnectCSDL.OpenConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
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
