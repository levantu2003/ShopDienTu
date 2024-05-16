/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Kaiser
 */
public class ChiTietPhanQuyen {

    private String MaCTPQ, MaPQ, QuyenDuocCapPhep;
    private int KiemTraHanhDong;

    public ChiTietPhanQuyen() {
    }

    public ChiTietPhanQuyen(String MaCTPQ, String MaPQ, String QuyenDuocCapPhep, int KiemTraHanhDong) {
        this.MaCTPQ = MaCTPQ;
        this.MaPQ = MaPQ;
        this.QuyenDuocCapPhep = QuyenDuocCapPhep;
        this.KiemTraHanhDong = KiemTraHanhDong;
    }

    public String getMaCTPQ() {
        return MaCTPQ;
    }

    public void setMaCTPQ(String MaCTPQ) {
        this.MaCTPQ = MaCTPQ;
    }

    public String getMaPQ() {
        return MaPQ;
    }

    public void setMaPQ(String MaPQ) {
        this.MaPQ = MaPQ;
    }

    public String getQuyenDuocCapPhep() {
        return QuyenDuocCapPhep;
    }

    public void setQuyenDuocCapPhep(String QuyenDuocCapPhep) {
        this.QuyenDuocCapPhep = QuyenDuocCapPhep;
    }

    public int getKiemTraHanhDong() {
        return KiemTraHanhDong;
    }

    public void setKiemTraHanhDong(int KiemTraHanhDong) {
        this.KiemTraHanhDong = KiemTraHanhDong;
    }

}
