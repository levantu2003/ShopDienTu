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

    private String MaNCC, TenNCC, Sdt, DiaChi, Email;

    public NhaCungCap(String MaNCC, String TenNCC, String Sdt, String DiaChi, String Email) {
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.Sdt = Sdt;
        this.DiaChi = DiaChi;
        this.Email = Email;
    }

    public NhaCungCap() {
    }

    ;

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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}
