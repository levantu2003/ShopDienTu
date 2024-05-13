/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author latu2
 */
public class NhanVien {

    private String MaNV, Sdt, DiaChi, GioiTinh, MaCV;
    private Date NgaySinh;

    public NhanVien(String MaNV, String Sdt, String DiaChi, String GioiTinh, String MaCV, Date NgaySinh) {
        this.MaNV = MaNV;
        this.Sdt = Sdt;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.MaCV = MaCV;
        this.NgaySinh = NgaySinh;
    }

    public NhanVien() {
    }

    ;

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
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

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

}
