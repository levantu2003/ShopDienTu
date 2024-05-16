/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Kaiser
 */
public class HoaDonSanPham {

    private String MaHD, MaSP;

    public HoaDonSanPham() {
    }

    public HoaDonSanPham(String MaHD, String MaSP) {
        this.MaHD = MaHD;
        this.MaSP = MaSP;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

}
