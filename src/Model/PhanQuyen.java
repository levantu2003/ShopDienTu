/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Kaiser
 */
public class PhanQuyen {

    private String MaPQ, TenNhomQuyen;

    public PhanQuyen() {
    }

    public PhanQuyen(String MaPQ, String TenNhomQuyen) {
        this.MaPQ = MaPQ;
        this.TenNhomQuyen = TenNhomQuyen;
    }

    public String getMaPQ() {
        return MaPQ;
    }

    public void setMaPQ(String MaPQ) {
        this.MaPQ = MaPQ;
    }

    public String getTenNhomQuyen() {
        return TenNhomQuyen;
    }

    public void setTenNhomQuyen(String TenNhomQuyen) {
        this.TenNhomQuyen = TenNhomQuyen;
    }

}
