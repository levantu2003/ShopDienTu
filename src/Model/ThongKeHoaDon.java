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
public class ThongKeHoaDon {

    private String MaTKHD, MaNV;
    private float TongDonGiaBan, TongGiaBan;
    private int SoLuongDaBan;
    private Date NgayBan;

    public ThongKeHoaDon() {
    }

    public ThongKeHoaDon(String MaTKHD, String MaNV, float TongDonGiaBan, float TongGiaBan, int SoLuongDaBan, Date NgayBan) {
        this.MaTKHD = MaTKHD;
        this.MaNV = MaNV;
        this.TongDonGiaBan = TongDonGiaBan;
        this.TongGiaBan = TongGiaBan;
        this.SoLuongDaBan = SoLuongDaBan;
        this.NgayBan = NgayBan;
    }

    public String getMaTKHD() {
        return MaTKHD;
    }

    public void setMaTKHD(String MaTKHD) {
        this.MaTKHD = MaTKHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public float getTongDonGiaBan() {
        return TongDonGiaBan;
    }

    public void setTongDonGiaBan(float TongDonGiaBan) {
        this.TongDonGiaBan = TongDonGiaBan;
    }

    public float getTongGiaBan() {
        return TongGiaBan;
    }

    public void setTongGiaBan(float TongGiaBan) {
        this.TongGiaBan = TongGiaBan;
    }

    public int getSoLuongDaBan() {
        return SoLuongDaBan;
    }

    public void setSoLuongDaBan(int SoLuongDaBan) {
        this.SoLuongDaBan = SoLuongDaBan;
    }

    public Date getNgayBan() {
        return NgayBan;
    }

    public void setNgayBan(Date NgayBan) {
        this.NgayBan = NgayBan;
    }

}
