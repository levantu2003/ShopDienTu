/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Kaiser
 */
public class SanPham_Gio {

    private String MaSP, MaGH;

    public SanPham_Gio() {
    }

    public SanPham_Gio(String MaSP, String MaGH) {
        this.MaSP = MaSP;
        this.MaGH = MaGH;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getMaGH() {
        return MaGH;
    }

    public void setMaGH(String MaGH) {
        this.MaGH = MaGH;
    }

}
