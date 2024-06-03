/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.QuanLy;

import DAO.QuanLy.SanPhamDAO;
import Model.SanPham;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static java.lang.Float.parseFloat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author latu2
 */
public class frmSanPham extends javax.swing.JFrame {

    String imgPath = "";

    public frmSanPham() {
        initComponents();
    }

    private byte[] readImageFile(String imagePath) {
        try {
            File file = new File(imagePath);
            FileInputStream fis = new FileInputStream(file);
            byte[] imageBytes = new byte[(int) file.length()];
            fis.read(imageBytes);
            fis.close();
            return imageBytes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtNgaySanXuat = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTrangThai = new javax.swing.JTextField();
        txtMaLoai = new javax.swing.JTextField();
        labelHinhSanPham = new javax.swing.JLabel();
        btnMoHinhSanPham = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã sản phẩm");

        jLabel2.setText("Tên sản phẩm");

        jLabel3.setText("Ngày Sản Xuất");

        jLabel5.setText("Giá bán");

        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Actions-document-new-icon.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Action-edit-icon.png"))); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Thêm, sửa Sản phẩm");

        jLabel7.setText("Trạng Thái");

        jLabel8.setText("Mã loại");

        txtMaLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaLoaiActionPerformed(evt);
            }
        });

        btnMoHinhSanPham.setText("Mở hình");
        btnMoHinhSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoHinhSanPhamActionPerformed(evt);
            }
        });

        jLabel9.setText("Mô tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(53, 53, 53)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtMaSP)
                                        .addComponent(txtGiaBan)
                                        .addComponent(txtTenSP)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(47, 47, 47)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(27, 27, 27)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNgaySanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(labelHinhSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(btnMoHinhSanPham))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelHinhSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMoHinhSanPham))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgaySanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLuu)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        SanPhamDAO cddao = new SanPhamDAO();
        SanPham sp = new SanPham();

        // Kiểm tra mã sản phẩm
        if (txtMaSP.getText() != null && !txtMaSP.getText().trim().isEmpty()) {
            sp.setMaSP(txtMaSP.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Không thể để trống Mã Sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra tên sản phẩm
        if (txtTenSP.getText() != null && !txtTenSP.getText().trim().isEmpty()) {
            sp.setTenSP(txtTenSP.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Không thể để trống Tên Sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra mô tả sản phẩm
        if (txtMoTa.getText() != null && !txtMoTa.getText().trim().isEmpty()) {
            sp.setMoTa(txtMoTa.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Không thể để trống Mô tả Sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra giá bán
        try {
            float giaBan = Float.parseFloat(txtGiaBan.getText());
            if (giaBan > 0) {
                sp.setGiaBan(giaBan);
            } else {
                JOptionPane.showMessageDialog(this, "Giá Sản phẩm không thể âm hoặc bằng 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra ngày sản xuất
        try {
            sp.setNgaySanXuat(new SimpleDateFormat("dd-MM-yyyy").parse(txtNgaySanXuat.getText()));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng dd-MM-yyyy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra và đặt hình ảnh
        byte[] imageBytes = null;
        if (imgPath != null && !imgPath.isEmpty()) {
            imageBytes = readImageFile(imgPath);
        } else {
            imageBytes = readImageFile("src/Images/hinh1.jpg");
        }
        sp.setHinhAnh(imageBytes);

        // Kiểm tra tình trạng
        try {
            sp.setTinhTrang(Integer.parseInt(txtTrangThai.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tình trạng hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra mã loại
        if (txtMaLoai.getText() != null && !txtMaLoai.getText().trim().isEmpty()) {
            sp.setMaLoai(txtMaLoai.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Không thể để trống Mã Loại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Thêm sản phẩm vào cơ sở dữ liệu
        int x = cddao.addSanPham(sp);
        if (x > 0) {
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
            // fillDataToTable(); // Thêm vào danh sách sản phẩm
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        this.txtMaSP.setText("");
        this.txtTenSP.setText("");
        this.txtNgaySanXuat.setText("");
        this.txtGiaBan.setText("");
        this.txtMoTa.setText("");
        this.txtTrangThai.setText("");
        this.txtMaLoai.setText("");
        this.labelHinhSanPham.setText("");
        this.txtMaSP.requestFocus();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        SanPhamDAO cddao = new SanPhamDAO();
        SanPham sp = new SanPham();

        // Kiểm tra mã sản phẩm
        if (txtMaSP.getText() != null && !txtMaSP.getText().trim().isEmpty()) {
            sp.setMaSP(txtMaSP.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Không thể để trống Mã Sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra tên sản phẩm
        if (txtTenSP.getText() != null && !txtTenSP.getText().trim().isEmpty()) {
            sp.setTenSP(txtTenSP.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Không thể để trống Tên Sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra giá bán
        try {
            float giaBan = Float.parseFloat(txtGiaBan.getText());
            if (giaBan > 0) {
                sp.setGiaBan(giaBan);
            } else {
                JOptionPane.showMessageDialog(this, "Giá Sản phẩm không thể âm hoặc bằng 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra ngày sản xuất
        try {
            sp.setNgaySanXuat(new SimpleDateFormat("dd-MM-yyyy").parse(txtNgaySanXuat.getText()));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng dd-MM-yyyy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra và đặt hình ảnh
        byte[] imageBytes = null;
        if (imgPath != null && !imgPath.isEmpty()) {
            imageBytes = readImageFile(imgPath);
        } else {
            imageBytes = readImageFile("src/Images/hinh1.jpg");
        }
        sp.setHinhAnh(imageBytes);

        // Kiểm tra tình trạng
        try {
            sp.setTinhTrang(Integer.parseInt(txtTrangThai.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tình trạng hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra mã loại
        if (txtMaLoai.getText() != null && !txtMaLoai.getText().trim().isEmpty()) {
            sp.setMaLoai(txtMaLoai.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Không thể để trống Mã Loại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Cập nhật sản phẩm trong cơ sở dữ liệu
        int x = cddao.updateSanPham(sp);
        if (x > 0) {
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
            // fillDataToTable(); // Thêm vào danh sách sản phẩm
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnMoHinhSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoHinhSanPhamActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\latu2\\Downloads\\QuanLyLinhKien\\src\\Images"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            imgPath = selectedFile.getAbsolutePath();

            // Hiển thị ảnh được chọn lên JLabel
            ImageIcon icon = new ImageIcon(imgPath);
            Image img = icon.getImage().getScaledInstance(153, 133, Image.SCALE_SMOOTH);
            labelHinhSanPham.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_btnMoHinhSanPhamActionPerformed

    private void txtMaLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaLoaiActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(frmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmSanPham().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnMoHinhSanPham;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelHinhSanPham;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaLoai;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtNgaySanXuat;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
