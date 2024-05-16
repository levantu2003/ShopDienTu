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
public class HoaDon {

    private String MaHD, DonViTinh, MaKH, MaNV;
    private float DonGia, ThanhTien;
    private int SoLuong;
    private Date NgayXuatHD;

    public HoaDon() {
    }

    public HoaDon(String MaHD, String DonViTinh, String MaKH, String MaNV, float DonGia, float ThanhTien, int SoLuong, Date NgayXuatHD) {
        this.MaHD = MaHD;
        this.DonViTinh = DonViTinh;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
        this.DonGia = DonGia;
        this.ThanhTien = ThanhTien;
        this.SoLuong = SoLuong;
        this.NgayXuatHD = NgayXuatHD;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
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
