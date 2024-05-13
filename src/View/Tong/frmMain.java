/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Tong;

import Controller.ChuyenManHinhController;
import Controller.DanhMucBean;
import View.XacThuc.DangNhap;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author latu2
 */
public class frmMain extends javax.swing.JFrame {

    
    public frmMain() {
        initComponents();
        ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);
        controller.setView(jpnTrangChu, jlbTrangChu);
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpnTrangChu = new javax.swing.JPanel();
        jlbTrangChu = new javax.swing.JLabel();
        jpnQLNhaCungCap = new javax.swing.JPanel();
        jlbQLNhaCungCap = new javax.swing.JLabel();
        jpnQLHoaDon = new javax.swing.JPanel();
        jlbQLHoaDon = new javax.swing.JLabel();
        jpnQLSanPham = new javax.swing.JPanel();
        jlbQLSanPham = new javax.swing.JLabel();
        jpnQLTaiKhoan = new javax.swing.JPanel();
        jlbQLTaiKhoan = new javax.swing.JLabel();
        jpnQLKhachHang = new javax.swing.JPanel();
        jlbQLKhachHang = new javax.swing.JLabel();
        jpnQLThongKe = new javax.swing.JPanel();
        jlbQLThongKe = new javax.swing.JLabel();
        jpnDangXuat = new javax.swing.JPanel();
        jlbDangXuat = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jpnTrangChu.setBackground(new java.awt.Color(204, 204, 204));

        jlbTrangChu.setBackground(new java.awt.Color(255, 255, 255));
        jlbTrangChu.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jlbTrangChu.setForeground(new java.awt.Color(0, 0, 0));
        jlbTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-store-30.png"))); // NOI18N
        jlbTrangChu.setText("Quản lý\n\n\n\n cửa hàng"); // NOI18N

        javax.swing.GroupLayout jpnTrangChuLayout = new javax.swing.GroupLayout(jpnTrangChu);
        jpnTrangChu.setLayout(jpnTrangChuLayout);
        jpnTrangChuLayout.setHorizontalGroup(
            jpnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnTrangChuLayout.setVerticalGroup(
            jpnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnQLNhaCungCap.setBackground(new java.awt.Color(102, 102, 102));
        jpnQLNhaCungCap.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, null, null));

        jlbQLNhaCungCap.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlbQLNhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-supplier-25.png"))); // NOI18N
        jlbQLNhaCungCap.setText("Quản lý nhà cung cấp");

        javax.swing.GroupLayout jpnQLNhaCungCapLayout = new javax.swing.GroupLayout(jpnQLNhaCungCap);
        jpnQLNhaCungCap.setLayout(jpnQLNhaCungCapLayout);
        jpnQLNhaCungCapLayout.setHorizontalGroup(
            jpnQLNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLNhaCungCapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnQLNhaCungCapLayout.setVerticalGroup(
            jpnQLNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLNhaCungCapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnQLHoaDon.setBackground(new java.awt.Color(102, 102, 102));
        jpnQLHoaDon.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, null, null));

        jlbQLHoaDon.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlbQLHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-invoice-25.png"))); // NOI18N
        jlbQLHoaDon.setText("Quản lý hóa đơn");

        javax.swing.GroupLayout jpnQLHoaDonLayout = new javax.swing.GroupLayout(jpnQLHoaDon);
        jpnQLHoaDon.setLayout(jpnQLHoaDonLayout);
        jpnQLHoaDonLayout.setHorizontalGroup(
            jpnQLHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnQLHoaDonLayout.setVerticalGroup(
            jpnQLHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnQLSanPham.setBackground(new java.awt.Color(102, 102, 102));
        jpnQLSanPham.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, null, null));

        jlbQLSanPham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlbQLSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-product-management-25.png"))); // NOI18N
        jlbQLSanPham.setText("Quản lý sản phẩm");

        javax.swing.GroupLayout jpnQLSanPhamLayout = new javax.swing.GroupLayout(jpnQLSanPham);
        jpnQLSanPham.setLayout(jpnQLSanPhamLayout);
        jpnQLSanPhamLayout.setHorizontalGroup(
            jpnQLSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnQLSanPhamLayout.setVerticalGroup(
            jpnQLSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnQLSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnQLTaiKhoan.setBackground(new java.awt.Color(102, 102, 102));
        jpnQLTaiKhoan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, null, null));

        jlbQLTaiKhoan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlbQLTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-account-management-25.png"))); // NOI18N
        jlbQLTaiKhoan.setText("Quản lý tài khoản");

        javax.swing.GroupLayout jpnQLTaiKhoanLayout = new javax.swing.GroupLayout(jpnQLTaiKhoan);
        jpnQLTaiKhoan.setLayout(jpnQLTaiKhoanLayout);
        jpnQLTaiKhoanLayout.setHorizontalGroup(
            jpnQLTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLTaiKhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnQLTaiKhoanLayout.setVerticalGroup(
            jpnQLTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLTaiKhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnQLKhachHang.setBackground(new java.awt.Color(102, 102, 102));
        jpnQLKhachHang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, null, null));

        jlbQLKhachHang.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlbQLKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-customer-25.png"))); // NOI18N
        jlbQLKhachHang.setText("Quản lý khách hàng");

        javax.swing.GroupLayout jpnQLKhachHangLayout = new javax.swing.GroupLayout(jpnQLKhachHang);
        jpnQLKhachHang.setLayout(jpnQLKhachHangLayout);
        jpnQLKhachHangLayout.setHorizontalGroup(
            jpnQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnQLKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnQLKhachHangLayout.setVerticalGroup(
            jpnQLKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnQLKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnQLThongKe.setBackground(new java.awt.Color(102, 102, 102));
        jpnQLThongKe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, null, null));

        jlbQLThongKe.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlbQLThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-management-25.png"))); // NOI18N
        jlbQLThongKe.setText("Quản lý thống kê");

        javax.swing.GroupLayout jpnQLThongKeLayout = new javax.swing.GroupLayout(jpnQLThongKe);
        jpnQLThongKe.setLayout(jpnQLThongKeLayout);
        jpnQLThongKeLayout.setHorizontalGroup(
            jpnQLThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnQLThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnQLThongKeLayout.setVerticalGroup(
            jpnQLThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnQLThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnDangXuat.setBackground(new java.awt.Color(255, 51, 51));
        jpnDangXuat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        jpnDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnDangXuatMouseClicked(evt);
            }
        });

        jlbDangXuat.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jlbDangXuat.setForeground(new java.awt.Color(0, 0, 0));
        jlbDangXuat.setText("Đăng xuất");
        jlbDangXuat.setAlignmentY(0.0F);
        jlbDangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jpnDangXuatLayout = new javax.swing.GroupLayout(jpnDangXuat);
        jpnDangXuat.setLayout(jpnDangXuatLayout);
        jpnDangXuatLayout.setHorizontalGroup(
            jpnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDangXuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbDangXuat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnDangXuatLayout.setVerticalGroup(
            jpnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDangXuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbDangXuat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnQLHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnQLNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnQLSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnQLTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnQLKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnQLThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jpnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnQLSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnQLNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnQLTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnQLHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnQLKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnQLThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpnView.setPreferredSize(new java.awt.Dimension(743, 370));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpnDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnDangXuatMouseClicked
        DangNhap qk = new DangNhap();
        qk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        qk.setVisible(true);
    }//GEN-LAST:event_jpnDangXuatMouseClicked


    
    
    
    
    
    
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
//            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmMain().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlbDangXuat;
    private javax.swing.JLabel jlbQLHoaDon;
    private javax.swing.JLabel jlbQLKhachHang;
    private javax.swing.JLabel jlbQLNhaCungCap;
    private javax.swing.JLabel jlbQLSanPham;
    private javax.swing.JLabel jlbQLTaiKhoan;
    private javax.swing.JLabel jlbQLThongKe;
    private javax.swing.JLabel jlbTrangChu;
    private javax.swing.JPanel jpnDangXuat;
    private javax.swing.JPanel jpnQLHoaDon;
    private javax.swing.JPanel jpnQLKhachHang;
    private javax.swing.JPanel jpnQLNhaCungCap;
    private javax.swing.JPanel jpnQLSanPham;
    private javax.swing.JPanel jpnQLTaiKhoan;
    private javax.swing.JPanel jpnQLThongKe;
    private javax.swing.JPanel jpnTrangChu;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
