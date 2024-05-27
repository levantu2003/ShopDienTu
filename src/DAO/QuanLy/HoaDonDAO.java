/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.QuanLy;

import DAO.XacThuc.ConnectCSDL;
import Model.phieuHoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Kaiser
 */
public class HoaDonDAO {

    public static ArrayList<phieuHoaDon> getListPhieuHoaDon() {
        ArrayList<phieuHoaDon> list = new ArrayList<>();
        try {
            String sql = "SELECT HD.MaHD, HD.DonGia, HD.SoLuong, HD.TongTien, HD.NgayXuatHD, KH.TenKH, KH.Sdt, KH.DiaChi, SP.TenSP, NV.HoTenNV "
                    + "FROM HoaDon HD "
                    + "JOIN KhachHang KH ON HD.MaKH = KH.MaKH "
                    + "JOIN HoaDon_SanPham HDSP ON HD.MaHD = HDSP.MaHD "
                    + "JOIN SanPham SP ON HDSP.MaSP = SP.MaSP "
                    + "JOIN NhanVien NV ON HD.MaNV = NV.MaNV";

            Connection con = ConnectCSDL.OpenConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String MaHD = rs.getString("MaHD");
                String TenKH = rs.getString("TenKH");
                String Sdt = rs.getString("Sdt");
                String DiaChi = rs.getString("DiaChi");
                String TenSP = rs.getString("TenSP");
                String HoTenNV = rs.getString("HoTenNV");
                Float DonGia = rs.getFloat("DonGia");
                Float TongTien = rs.getFloat("TongTien");
                int SoLuong = rs.getInt("SoLuong");
                Date NgayXuatHD = rs.getDate("NgayXuatHD");

                phieuHoaDon phd = new phieuHoaDon(MaHD, TenKH, Sdt, DiaChi, TenSP, HoTenNV, DonGia, TongTien, SoLuong, NgayXuatHD);
                list.add(phd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public phieuHoaDon timTheoID(String MaHD) throws Exception {
        String sql = "SELECT HD.MaHD, HD.DonGia, HD.SoLuong, HD.TongTien, HD.NgayXuatHD, "
                + "KH.TenKH, KH.Sdt, KH.DiaChi, SP.TenSP, NV.HoTenNV "
                + "FROM HoaDon HD "
                + "JOIN KhachHang KH ON HD.MaKH = KH.MaKH "
                + "JOIN HoaDon_SanPham HDSP ON HD.MaHD = HDSP.MaHD "
                + "JOIN SanPham SP ON HDSP.MaSP = SP.MaSP "
                + "JOIN NhanVien NV ON HD.MaNV = NV.MaNV "
                + "WHERE HD.MaHD = ?";
        try {
            Connection con = ConnectCSDL.OpenConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, MaHD);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    phieuHoaDon phieu = new phieuHoaDon();
                    phieu.setMaHD(rs.getString("MaHD"));
                    phieu.setDonGia(rs.getFloat("DonGia"));
                    phieu.setSoLuong(rs.getInt("SoLuong"));
                    phieu.setTongTien(rs.getFloat("TongTien"));
                    phieu.setNgayXuatHD(rs.getDate("NgayXuatHD"));
                    phieu.setTenKH(rs.getString("TenKH"));
                    phieu.setSdt(rs.getString("Sdt"));
                    phieu.setDiaChi(rs.getString("DiaChi"));
                    phieu.setTenSP(rs.getString("TenSP"));
                    phieu.setHoTenNV(rs.getString("HoTenNV"));
                    return phieu;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int removeHoaDon(String MaHD) {
        try {
            Connection con = ConnectCSDL.OpenConnection();

            String sqlHDSP = "DELETE FROM HoaDon_SanPham WHERE MaHD = ?";
            PreparedStatement psHDSP = con.prepareStatement(sqlHDSP);
            psHDSP.setString(1, MaHD);
            psHDSP.executeUpdate();

            String sqlHD = "DELETE FROM HoaDon WHERE MaHD = ?";
            PreparedStatement psHD = con.prepareStatement(sqlHD);
            psHD.setString(1, MaHD);
            return psHD.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updateHoaDon(String MaHD, float DonGia, int SoLuong, float TongTien, java.util.Date NgayXuatHD,
            String TenKH, String Sdt, String DiaChi, String TenSP, String HoTenNV) {
        try {
            Connection con = ConnectCSDL.OpenConnection();

            String sqlHD = "UPDATE HoaDon SET DonGia = ?, SoLuong = ?, TongTien = ?, NgayXuatHD = ? WHERE MaHD = ?";
            PreparedStatement psHD = con.prepareStatement(sqlHD);
            psHD.setFloat(1, DonGia);
            psHD.setInt(2, SoLuong);
            psHD.setFloat(3, TongTien);
            psHD.setDate(4, new java.sql.Date(NgayXuatHD.getTime()));
            psHD.setString(5, MaHD);
            psHD.executeUpdate();

            String sqlKH = "UPDATE KhachHang SET TenKH = ?, Sdt = ?, DiaChi = ? WHERE MaKH = (SELECT MaKH FROM HoaDon WHERE MaHD = ?)";
            PreparedStatement psKH = con.prepareStatement(sqlKH);
            psKH.setString(1, TenKH);
            psKH.setString(2, Sdt);
            psKH.setString(3, DiaChi);
            psKH.setString(4, MaHD);
            psKH.executeUpdate();

            String sqlHDSP = "UPDATE HoaDon_SanPham SET MaSP = (SELECT TOP 1 MaSP FROM SanPham WHERE TenSP = ?) WHERE MaHD = ?";
            PreparedStatement psHDSP = con.prepareStatement(sqlHDSP);
            psHDSP.setString(1, TenSP);
            psHDSP.setString(2, MaHD);
            psHDSP.executeUpdate();

            String sqlNV = "UPDATE NhanVien SET HoTenNV = ? WHERE MaNV = (SELECT MaNV FROM HoaDon WHERE MaHD = ?)";
            PreparedStatement psNV = con.prepareStatement(sqlNV);
            psNV.setString(1, HoTenNV);
            psNV.setString(2, MaHD);
            psNV.executeUpdate();

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
