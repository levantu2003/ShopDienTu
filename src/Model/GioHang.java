/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Kaiser
 */
public class GioHang {

    private String MaGH, MaKH;
    private int SoLuong;
    private float ThanhTien;

    public GioHang() {
    }

    public GioHang(String MaGH, String MaKH, int SoLuong, float ThanhTien) {
        this.MaGH = MaGH;
        this.MaKH = MaKH;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
    }

    public String getMaGH() {
        return MaGH;
    }

    public void setMaGH(String MaGH) {
        this.MaGH = MaGH;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
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

}
