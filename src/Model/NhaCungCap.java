/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author latu2
 */
public class NhaCungCap {

    private String MaNCC, TenNCC, DiaChi;

    public NhaCungCap() {
    }

    public NhaCungCap(String MaNCC, String TenNCC, String DiaChi) {
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.DiaChi = DiaChi;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    

}
