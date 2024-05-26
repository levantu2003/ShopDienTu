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

    private String MaNV;
    private String HoTenNV;
    private String GioiTinh;
    private Date NgaySinh;
    private String Sdt;
    private String DiaChi;
    private String MaCV;
 
    
    public NhanVien(String MaNV, String HoTenNV, String GioiTinh, Date NgaySinh, String Sdt, String DiaChi, String MaCV) {
        this.MaNV = MaNV;
        this.HoTenNV = HoTenNV;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.Sdt = Sdt;
        this.DiaChi = DiaChi;
        this.MaCV = MaCV;
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

    public String getHoTenNV() {
        return HoTenNV;
    }

    public void setHoTenNV(String HoTenNV) {
        this.HoTenNV = HoTenNV;
    }

}
