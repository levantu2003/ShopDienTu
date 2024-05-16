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
public class PhieuNhap {

    private String MaPN;
    private Date NgayNhap;
    private float GiaNhap;
    private int SoLuong;
    private float ThanhTien;
    private String MaNCC;
    private String MaSP;

    public PhieuNhap() {
    }

    public PhieuNhap(String MaPN, Date NgayNhap, float GiaNhap, int SoLuong, float ThanhTien, String MaNCC, String MaSP) {
        this.MaPN = MaPN;
        this.NgayNhap = NgayNhap;
        this.GiaNhap = GiaNhap;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
        this.MaNCC = MaNCC;
        this.MaSP = MaSP;
    }

    public String getMaPN() {
        return MaPN;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public float getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(float GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

}
