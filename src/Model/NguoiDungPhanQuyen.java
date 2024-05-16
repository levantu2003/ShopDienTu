/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Kaiser
 */
public class NguoiDungPhanQuyen {

    private String MaND, MaPQ;

    public NguoiDungPhanQuyen() {
    }

    public NguoiDungPhanQuyen(String MaND, String MaPQ) {
        this.MaND = MaND;
        this.MaPQ = MaPQ;
    }

    public String getMaND() {
        return MaND;
    }

    public void setMaND(String MaND) {
        this.MaND = MaND;
    }

    public String getMaPQ() {
        return MaPQ;
    }

    public void setMaPQ(String MaPQ) {
        this.MaPQ = MaPQ;
    }

}
