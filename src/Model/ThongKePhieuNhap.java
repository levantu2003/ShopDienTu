/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Kaiser
 */
public class ThongKePhieuNhap {

    private String MaTKPN, MaNV;
    private float TongSoTienNhap, TongDonGiaNhap;
    private int SoLuongDaNhap;

    public ThongKePhieuNhap() {
    }

    public ThongKePhieuNhap(String MaTKPN, String MaNV, float TongSoTienNhap, float TongDonGiaNhap, int SoLuongDaNhap) {
        this.MaTKPN = MaTKPN;
        this.MaNV = MaNV;
        this.TongSoTienNhap = TongSoTienNhap;
        this.TongDonGiaNhap = TongDonGiaNhap;
        this.SoLuongDaNhap = SoLuongDaNhap;
    }

    public String getMaTKPN() {
        return MaTKPN;
    }

    public void setMaTKPN(String MaTKPN) {
        this.MaTKPN = MaTKPN;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public float getTongSoTienNhap() {
        return TongSoTienNhap;
    }

    public void setTongSoTienNhap(float TongSoTienNhap) {
        this.TongSoTienNhap = TongSoTienNhap;
    }

    public float getTongDonGiaNhap() {
        return TongDonGiaNhap;
    }

    public void setTongDonGiaNhap(float TongDonGiaNhap) {
        this.TongDonGiaNhap = TongDonGiaNhap;
    }

    public int getSoLuongDaNhap() {
        return SoLuongDaNhap;
    }

    public void setSoLuongDaNhap(int SoLuongDaNhap) {
        this.SoLuongDaNhap = SoLuongDaNhap;
    }

}
