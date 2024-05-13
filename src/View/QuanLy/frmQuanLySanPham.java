/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.QuanLy;

import DAO.SanPhamDAO;
import Model.SanPham;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author latu2
 */
public class frmQuanLySanPham extends javax.swing.JFrame {

    private ArrayList<SanPham> list;
    DefaultTableModel model;
    int index = 0;

    public frmQuanLySanPham() {
        initComponents();
        this.setLocationRelativeTo(null);
        fillDataToTable();
    }

    public void fillDataToTable() {
        SanPhamDAO cddao = new SanPhamDAO();
        list = cddao.getListSanPham();
        model = (DefaultTableModel) tableSanPham.getModel();
        model.setRowCount(0);
        int i = 1;
        for (SanPham cd : list) {
            Object[] row = new Object[]{i++, cd.getMaSP(), cd.getTenSP(), cd.getNgaySanXuat(), cd.getGiaNhap(), cd.getGiaBan()};
            model.addRow(row);
        }
        tableSanPham.setModel(model);
    }

    public void fillDataSearchToTable() {
        SanPhamDAO cddao = new SanPhamDAO();
        list = cddao.searchSanPham(btnTimKiem.getText());
        model = (DefaultTableModel) tableSanPham.getModel();
        model.setRowCount(0);
        int i = 1;
        for (SanPham cd : list) {
            Object[] row = new Object[]{i++, cd.getMaSP(), cd.getTenSP(), cd.getNgaySanXuat(), cd.getGiaNhap(), cd.getGiaBan()};
            model.addRow(row);
        }
//        tableSanPham.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();
        jpnTacVu = new javax.swing.JPanel();
        btnThemSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Ngày sản xuất", "Giá nhập", "Giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableSanPham);

        btnThemSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Action-edit-icon.png"))); // NOI18N
        btnThemSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Action-cancel-icon.png"))); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-search.png"))); // NOI18N
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Actions-view-refresh-icon.png"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnTacVuLayout = new javax.swing.GroupLayout(jpnTacVu);
        jpnTacVu.setLayout(jpnTacVuLayout);
        jpnTacVuLayout.setHorizontalGroup(
            jpnTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTacVuLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThemSua, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jpnTacVuLayout.setVerticalGroup(
            jpnTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTacVuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnTacVuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThemSua))
                    .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnTacVuLayout.createSequentialGroup()
                        .addGroup(jpnTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpnTacVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnTacVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        SanPhamDAO cddao = new SanPhamDAO();
        SanPham sp = new SanPham();
        try {

            fillDataSearchToTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnThemSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSuaActionPerformed
        frmSanPham qk = new frmSanPham();
        qk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        qk.setVisible(true);
        fillDataToTable();
    }//GEN-LAST:event_btnThemSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        SanPhamDAO cddao = new SanPhamDAO();

        int selectedRow = tableSanPham.getSelectedRow();
        int columnIndex = 1;
        String cellValue = null;

        if (selectedRow != -1) {
            Object value = tableSanPham.getValueAt(selectedRow, columnIndex);
            cellValue = value.toString();
        }

        if (cellValue != null) {
            int x = cddao.removeSanPham(cellValue);
            if (x > 0) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                fillDataToTable();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để xóa!");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        fillDataToTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmQuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmQuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmQuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmQuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmQuanLySanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnThemSua;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnTacVu;
    private javax.swing.JTable tableSanPham;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
