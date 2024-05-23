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
public class SanPham {

    private String MaSP;
    private String TenSP;
    private Float GiaBan;
    private String MoTa;
    private Date NgaySanXuat;
    private int TinhTrang;
    private byte[] HinhAnh;
    private String MaLoai;

    public SanPham() {
    }

    public SanPham(String MaSP, String TenSP, Float GiaBan, String MoTa, Date NgaySanXuat, int TinhTrang, byte[] HinhAnh, String MaLoai) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.GiaBan = GiaBan;
        this.MoTa = MoTa;
        this.NgaySanXuat = NgaySanXuat;
        this.TinhTrang = TinhTrang;
        this.HinhAnh = HinhAnh;
        this.MaLoai = MaLoai;
    }

    public SanPham(String MaSP, String TenSP, Float GiaBan, Date NgaySanXuat, int TinhTrang, byte[] HinhAnh) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.GiaBan = GiaBan;
        this.NgaySanXuat = NgaySanXuat;
        this.TinhTrang = TinhTrang;
        this.HinhAnh = HinhAnh;
    }

    

    
    

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public Float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(Float GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public Date getNgaySanXuat() {
        return NgaySanXuat;
    }

    public void setNgaySanXuat(Date NgaySanXuat) {
        this.NgaySanXuat = NgaySanXuat;
    }

    public int getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(int TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public byte[] getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(byte[] HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }
    
    
    

}
