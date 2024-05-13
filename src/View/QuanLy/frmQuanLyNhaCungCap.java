/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.QuanLy;

import DAO.NhaCungCapDAO;
import Model.NhaCungCap;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author latu2
 */
public class frmQuanLyNhaCungCap extends javax.swing.JFrame {

    private ArrayList<NhaCungCap> list;
    DefaultTableModel model;
    int index = 0;

    public frmQuanLyNhaCungCap() {
        initComponents();
        this.setLocationRelativeTo(null);
        fillDataToTable();
    }

    public void fillDataToTable() {
        NhaCungCapDAO cddao = new NhaCungCapDAO();
        list = cddao.getListNhaCungCap();
        model = (DefaultTableModel) tableNhaCungCap.getModel();
        model.setRowCount(0);
        int i = 1;
        for (NhaCungCap cd : list) {
            Object[] row = new Object[]{i++, cd.getMaNCC(), cd.getTenNCC(), cd.getSdt(), cd.getDiaChi(), cd.getEmail()};
            model.addRow(row);
        }
        tableNhaCungCap.setModel(model);
    }

    public void fillDataSearchToTable() {
        NhaCungCapDAO cddao = new NhaCungCapDAO();
        list = cddao.searchNhaCungCap(btnTimKiem.getText());
        model = (DefaultTableModel) tableNhaCungCap1.getModel();
        model.setRowCount(0);
        int i = 1;
        for (NhaCungCap cd : list) {
            model.addRow(new Object[]{i++, cd.getMaNCC(), cd.getTenNCC(), cd.getSdt(), cd.getDiaChi(), cd.getEmail()});
//            model.addRow(row);
        }
        tableNhaCungCap1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableNhaCungCap = new javax.swing.JTable();
        JpnTacVu = new javax.swing.JPanel();
        btnThemSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableNhaCungCap1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã NCC", "Tên NCC", "Số điện thoại", "Địa chỉ", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableNhaCungCap);

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

        javax.swing.GroupLayout JpnTacVuLayout = new javax.swing.GroupLayout(JpnTacVu);
        JpnTacVu.setLayout(JpnTacVuLayout);
        JpnTacVuLayout.setHorizontalGroup(
            JpnTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnTacVuLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThemSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        JpnTacVuLayout.setVerticalGroup(
            JpnTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnTacVuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JpnTacVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableNhaCungCap1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã NCC", "Tên NCC", "Số điện thoại", "Địa chỉ", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableNhaCungCap1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JpnTacVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JpnTacVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSuaActionPerformed
        frmNhaCungCap qk = new frmNhaCungCap();
        qk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        qk.setVisible(true);
        fillDataToTable();
    }//GEN-LAST:event_btnThemSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        NhaCungCapDAO cddao = new NhaCungCapDAO();
        int selectedRow = tableNhaCungCap.getSelectedRow();
        int columnIndex = 1;
        String cellValue = null;
        if (selectedRow != -1) {
            Object value = tableNhaCungCap.getValueAt(selectedRow, columnIndex);
            cellValue = value.toString();
        }
        if (cellValue != null) {
            int x = cddao.removeNhaCungCap(cellValue);
            if (x > 0) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                fillDataToTable();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một nhà cung cấp để xóa!");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        NhaCungCapDAO cddao = new NhaCungCapDAO();
        NhaCungCap ncc = new NhaCungCap();
        try {
            list = cddao.searchNhaCungCap(btnTimKiem.getText());
            fillDataSearchToTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

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
            java.util.logging.Logger.getLogger(frmQuanLyNhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyNhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyNhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyNhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmQuanLyNhaCungCap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpnTacVu;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnThemSua;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableNhaCungCap;
    private javax.swing.JTable tableNhaCungCap1;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
