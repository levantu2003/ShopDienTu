/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Kaiser
 */
public class phieuHoaDon {

    private String MaHD, TenKH, Sdt, DiaChi, TenSP, HoTenNV, MaSP;
    private Float DonGia, TongTien;
    private int SoLuong;
    private Date NgayXuatHD;

    public phieuHoaDon() {
    }

    public phieuHoaDon(String MaHD, String MaSP, String TenKH, String Sdt, String DiaChi, String TenSP, String HoTenNV, Float DonGia, int SoLuong, Date NgayXuatHD) {
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.TenKH = TenKH;
        this.Sdt = Sdt;
        this.DiaChi = DiaChi;
        this.TenSP = TenSP;
        this.HoTenNV = HoTenNV;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
        this.NgayXuatHD = NgayXuatHD;
        this.TongTien = DonGia * SoLuong;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getHoTenNV() {
        return HoTenNV;
    }

    public void setHoTenNV(String HoTenNV) {
        this.HoTenNV = HoTenNV;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public Float getDonGia() {
        return DonGia;
    }

    public void setDonGia(Float DonGia) {
        this.DonGia = DonGia;
    }

    public Float getTongTien() {
        return TongTien;
    }

    public void setTongTien(Float TongTien) {
        this.TongTien = TongTien;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Date getNgayXuatHD() {
        return NgayXuatHD;
    }

    public void setNgayXuatHD(Date NgayXuatHD) {
        this.NgayXuatHD = NgayXuatHD;
    }

}
