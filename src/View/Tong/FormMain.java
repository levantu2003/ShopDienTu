/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Tong;

import DAO.QuanLy.HoaDonDAO;
import DAO.QuanLy.NhaCungCapDAO;
import DAO.QuanLy.NhanVienDAO;
import DAO.QuanLy.SanPhamDAO;
import Model.NhaCungCap;
import Model.NhanVien;
import Model.SanPham;
import Model.phieuHoaDon;
import View.QuanLy.frmNhaCungCap;
import View.QuanLy.frmNhanVien;
import View.QuanLy.frmSanPham;
import View.XacThuc.DangNhap;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author latu2
 */
public class FormMain extends javax.swing.JFrame {

    private ArrayList<SanPham> listSanPham;
    private ArrayList<NhaCungCap> listNhaCungCap;
    private ArrayList<NhanVien> listNhanVien;

    DefaultTableModel model;
    int index = 0;
    CardLayout cardlayout;

    public FormMain() {
        initComponents();
        cardlayout = (CardLayout) (PanelView.getLayout());
        fillDataToTableSanPham();
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

    private void loadHinh(byte[] filePath) {
        if (filePath != null && filePath.length > 0) {
            try {
                // Chuyển đổi mảng byte thành hình ảnh
                InputStream is = new ByteArrayInputStream(filePath);
                BufferedImage img = ImageIO.read(is);
                Image scaledImage = img.getScaledInstance(153, 133, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaledImage);
                LabelDetailHinhAnhSP.setIcon(icon);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Không thể tải hình ảnh", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            LabelDetailHinhAnhSP.setIcon(null);
        }
    }

    public void fillDataToTableSanPham() {
        SanPhamDAO cddao = new SanPhamDAO();
        listSanPham = cddao.getListSanPham();
        model = (DefaultTableModel) tableSanPham.getModel();
        model.setRowCount(0);
        int i = 1;
        for (SanPham sp : listSanPham) {
            Object[] row = new Object[]{i++, sp.getMaSP(), sp.getTenSP(), sp.getGiaBan(), sp.getNgaySanXuat(), sp.getTinhTrang(), sp.getHinhAnh()};
            model.addRow(row);
        }
        tableSanPham.setModel(model);
    }

    public void fillDataSearchToTableSanPham() {
        SanPhamDAO cddao = new SanPhamDAO();
        listSanPham = cddao.searchSanPham(btnTimKiemSanPham.getText());
        model = (DefaultTableModel) tableSanPham.getModel();
        model.setRowCount(0);
        int i = 1;
        for (SanPham sp : listSanPham) {
            Object[] row = new Object[]{i++, sp.getMaSP(), sp.getTenSP(), sp.getGiaBan(), sp.getNgaySanXuat(), sp.getTinhTrang(), sp.getHinhAnh()};
            model.addRow(row);
        }
//        tableSanPham.setModel(model);
    }

    public void fillDataToTableNhaCungCap() {
        NhaCungCapDAO cddao = new NhaCungCapDAO();
        listNhaCungCap = cddao.getListNhaCungCap();
        model = (DefaultTableModel) tableNhaCungCap.getModel();
        model.setRowCount(0);
        int i = 1;
        for (NhaCungCap cd : listNhaCungCap) {
            Object[] row = new Object[]{i++, cd.getMaNCC(), cd.getTenNCC(), cd.getSdt(), cd.getDiaChi(), cd.getEmail()};
            model.addRow(row);
        }
        tableNhaCungCap.setModel(model);
    }

    public void fillDataSearchToTableNhaCungCap() {
        NhaCungCapDAO cddao = new NhaCungCapDAO();
        listNhaCungCap = cddao.searchNhaCungCap(btnTimKiemNhaCungCap.getText());
        model = (DefaultTableModel) tableNhaCungCap.getModel();
        model.setRowCount(0);
        int i = 1;
        for (NhaCungCap cd : listNhaCungCap) {
            model.addRow(new Object[]{i++, cd.getMaNCC(), cd.getTenNCC(), cd.getSdt(), cd.getDiaChi(), cd.getEmail()});
//            model.addRow(row);
        }
        tableNhaCungCap.setModel(model);
    }

    public void fillDataToTableNhanVien() {
        NhanVienDAO nvdao = new NhanVienDAO();
        listNhanVien = nvdao.getListNhanVien();
        model = (DefaultTableModel) tableNhanVien.getModel();
        model.setRowCount(0);
        int i = 1;
        for (NhanVien nv : listNhanVien) {
            Object[] row = new Object[]{i++, nv.getMaNV(), nv.getSdt(), nv.getDiaChi(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getMaCV()};
            model.addRow(row);
        }
        tableNhanVien.setModel(model);
    }

    public void fillDataSearchToTableNhanVien() {
        NhanVienDAO nvdao = new NhanVienDAO();
        listNhanVien = nvdao.searchNhanVien(btnTimKiemNhanVien.getText());
        model = (DefaultTableModel) tableNhanVien.getModel();
        model.setRowCount(0);
        int i = 1;
        for (NhanVien nv : listNhanVien) {
            Object[] row = new Object[]{i++, nv.getMaNV(), nv.getSdt(), nv.getDiaChi(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getMaCV()};
            model.addRow(row);
        }
//        tableSanPham.setModel(model);
    }

    public void fillDataToTableHoaDon() {
        HoaDonDAO hdDao = new HoaDonDAO();
        ArrayList<phieuHoaDon> listPhieuHoaDon = hdDao.getListPhieuHoaDon();

        DefaultTableModel model = (DefaultTableModel) tbHoaDon.getModel();
        model.setRowCount(0);

        for (phieuHoaDon phd : listPhieuHoaDon) {
            Object[] row = new Object[]{
                phd.getMaHD(),
                phd.getDonGia(),
                phd.getSoLuong(),
                phd.getTongTien(),
                phd.getNgayXuatHD(),
                phd.getTenKH(),
                phd.getSdt(),
                phd.getDiaChi(),
                phd.getTenSP(),
                phd.getHoTenNV()
            };
            model.addRow(row);
        }

        tbHoaDon.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        PanelMenu = new javax.swing.JPanel();
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
        PanelView = new javax.swing.JPanel();
        PanelSanPham = new javax.swing.JPanel();
        jScrollPaneSanPham = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();
        jpnTacVuSanPham = new javax.swing.JPanel();
        btnThemSuaSanPham = new javax.swing.JButton();
        btnXoaSanPham = new javax.swing.JButton();
        txtTimKiemSanPham = new javax.swing.JTextField();
        btnTimKiemSanPham = new javax.swing.JButton();
        btnRefreshSanPham = new javax.swing.JButton();
        PanelDetailSanPham = new javax.swing.JPanel();
        LabelDetailHinhAnhSP = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LabelDeTailMaSP = new javax.swing.JLabel();
        LabelDeTailTenSP = new javax.swing.JLabel();
        LabelDeTailGiaBan = new javax.swing.JLabel();
        LabelDeTailNgaySanXuat = new javax.swing.JLabel();
        LabelDeTailTinhTrang = new javax.swing.JLabel();
        PanelNhaCungCap = new javax.swing.JPanel();
        jScrollPaneNhaCungCap = new javax.swing.JScrollPane();
        tableNhaCungCap = new javax.swing.JTable();
        JpnTacVuNhaCungCap = new javax.swing.JPanel();
        btnThemSuaNhaCungCap = new javax.swing.JButton();
        btnXoaNhaCungCap = new javax.swing.JButton();
        txtTimKiemNhaCungCap = new javax.swing.JTextField();
        btnTimKiemNhaCungCap = new javax.swing.JButton();
        btnRefreshNhaCungCap = new javax.swing.JButton();
        PanelNhanVien = new javax.swing.JPanel();
        jScrollPaneNhanVien = new javax.swing.JScrollPane();
        tableNhanVien = new javax.swing.JTable();
        jpnTacVuNhanVien = new javax.swing.JPanel();
        btnThemSuaNhanVien = new javax.swing.JButton();
        btnXoaNhanVien = new javax.swing.JButton();
        txtTimKiemNhanVien = new javax.swing.JTextField();
        btnTimKiemNhanVien = new javax.swing.JButton();
        btnRefreshNhanVien = new javax.swing.JButton();
        PanelHoaDon = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        txtNgayXuatHD = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtHoTenNV = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTimKiemMaHD = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtTimKiemMaHD = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        PanelKhachHang = new javax.swing.JPanel();
        PanelThongKe = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelMenu.setBackground(new java.awt.Color(0, 153, 255));

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
        jpnQLNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnQLNhaCungCapMouseClicked(evt);
            }
        });

        jlbQLNhaCungCap.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlbQLNhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-supplier-25.png"))); // NOI18N
        jlbQLNhaCungCap.setText("Quản lý nhà cung cấp");
        jlbQLNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbQLNhaCungCapMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnQLNhaCungCapLayout = new javax.swing.GroupLayout(jpnQLNhaCungCap);
        jpnQLNhaCungCap.setLayout(jpnQLNhaCungCapLayout);
        jpnQLNhaCungCapLayout.setHorizontalGroup(
            jpnQLNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLNhaCungCapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbQLNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        jlbQLHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbQLHoaDonMouseClicked(evt);
            }
        });

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
        jpnQLSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnQLSanPhamMouseClicked(evt);
            }
        });

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
        jpnQLTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnQLTaiKhoanMouseClicked(evt);
            }
        });

        jlbQLTaiKhoan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlbQLTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-account-management-25.png"))); // NOI18N
        jlbQLTaiKhoan.setText("Quản lý tài khoản");
        jlbQLTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbQLTaiKhoanMouseClicked(evt);
            }
        });

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
        jlbQLKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbQLKhachHangMouseClicked(evt);
            }
        });

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
        jlbQLThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbQLThongKeMouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnQLHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnQLNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnQLSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnQLTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnQLKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnQLThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jpnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
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

        jSplitPane1.setLeftComponent(PanelMenu);

        PanelView.setBackground(new java.awt.Color(255, 255, 255));
        PanelView.setLayout(new java.awt.CardLayout());

        PanelSanPham.setBackground(new java.awt.Color(255, 255, 255));
        PanelSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelSanPhamMouseClicked(evt);
            }
        });

        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Giá bán", "Ngày sản xuất", "Tình Trạng", "Hình ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSanPhamMouseClicked(evt);
            }
        });
        jScrollPaneSanPham.setViewportView(tableSanPham);

        jpnTacVuSanPham.setBackground(new java.awt.Color(255, 255, 255));

        btnThemSuaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Action-edit-icon.png"))); // NOI18N
        btnThemSuaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSuaSanPhamActionPerformed(evt);
            }
        });

        btnXoaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Action-cancel-icon.png"))); // NOI18N
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        btnTimKiemSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-search.png"))); // NOI18N
        btnTimKiemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemSanPhamActionPerformed(evt);
            }
        });

        btnRefreshSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Actions-view-refresh-icon.png"))); // NOI18N
        btnRefreshSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnTacVuSanPhamLayout = new javax.swing.GroupLayout(jpnTacVuSanPham);
        jpnTacVuSanPham.setLayout(jpnTacVuSanPhamLayout);
        jpnTacVuSanPhamLayout.setHorizontalGroup(
            jpnTacVuSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTacVuSanPhamLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(btnRefreshSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThemSuaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jpnTacVuSanPhamLayout.setVerticalGroup(
            jpnTacVuSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTacVuSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnTacVuSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnTacVuSanPhamLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThemSuaSanPham))
                    .addComponent(btnRefreshSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnTacVuSanPhamLayout.createSequentialGroup()
                        .addGroup(jpnTacVuSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        LabelDetailHinhAnhSP.setText("Hình Ảnh");

        jLabel2.setText("Mã Sản phẩm");

        jLabel1.setText("Tên Sản phẩm");

        jLabel3.setText("Giá bán");

        jLabel4.setText("Trạng thái");

        jLabel5.setText("Ngày sản xuất");

        LabelDeTailMaSP.setText("...");

        LabelDeTailTenSP.setText("...");

        LabelDeTailGiaBan.setText("...");

        LabelDeTailNgaySanXuat.setText("...");

        LabelDeTailTinhTrang.setText("...");

        javax.swing.GroupLayout PanelDetailSanPhamLayout = new javax.swing.GroupLayout(PanelDetailSanPham);
        PanelDetailSanPham.setLayout(PanelDetailSanPhamLayout);
        PanelDetailSanPhamLayout.setHorizontalGroup(
            PanelDetailSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDetailSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelDetailHinhAnhSP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(PanelDetailSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelDetailSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDetailSanPhamLayout.createSequentialGroup()
                        .addGroup(PanelDetailSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelDeTailGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelDeTailTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154))
                    .addGroup(PanelDetailSanPhamLayout.createSequentialGroup()
                        .addGroup(PanelDetailSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelDeTailMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelDetailSanPhamLayout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(LabelDeTailNgaySanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelDetailSanPhamLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LabelDeTailTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))))
        );
        PanelDetailSanPhamLayout.setVerticalGroup(
            PanelDetailSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDetailSanPhamLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(PanelDetailSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelDetailHinhAnhSP, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelDetailSanPhamLayout.createSequentialGroup()
                        .addGroup(PanelDetailSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(LabelDeTailMaSP)
                            .addComponent(LabelDeTailNgaySanXuat))
                        .addGap(18, 18, 18)
                        .addGroup(PanelDetailSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(LabelDeTailTenSP)
                            .addComponent(LabelDeTailTinhTrang))
                        .addGap(18, 18, 18)
                        .addGroup(PanelDetailSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(LabelDeTailGiaBan))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel4.getAccessibleContext().setAccessibleName("Tình trạng");

        javax.swing.GroupLayout PanelSanPhamLayout = new javax.swing.GroupLayout(PanelSanPham);
        PanelSanPham.setLayout(PanelSanPhamLayout);
        PanelSanPhamLayout.setHorizontalGroup(
            PanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSanPhamLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(PanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelSanPhamLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jpnTacVuSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneSanPham)
                    .addComponent(PanelDetailSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        PanelSanPhamLayout.setVerticalGroup(
            PanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnTacVuSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(PanelDetailSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        PanelView.add(PanelSanPham, "PanelSanPham");

        PanelNhaCungCap.setBackground(new java.awt.Color(255, 255, 255));

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
        jScrollPaneNhaCungCap.setViewportView(tableNhaCungCap);

        JpnTacVuNhaCungCap.setBackground(new java.awt.Color(255, 255, 255));

        btnThemSuaNhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Action-edit-icon.png"))); // NOI18N
        btnThemSuaNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSuaNhaCungCapActionPerformed(evt);
            }
        });

        btnXoaNhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Action-cancel-icon.png"))); // NOI18N
        btnXoaNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNhaCungCapActionPerformed(evt);
            }
        });

        btnTimKiemNhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-search.png"))); // NOI18N
        btnTimKiemNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemNhaCungCapActionPerformed(evt);
            }
        });

        btnRefreshNhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Actions-view-refresh-icon.png"))); // NOI18N
        btnRefreshNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshNhaCungCapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpnTacVuNhaCungCapLayout = new javax.swing.GroupLayout(JpnTacVuNhaCungCap);
        JpnTacVuNhaCungCap.setLayout(JpnTacVuNhaCungCapLayout);
        JpnTacVuNhaCungCapLayout.setHorizontalGroup(
            JpnTacVuNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnTacVuNhaCungCapLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnRefreshNhaCungCap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThemSuaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnXoaNhaCungCap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(txtTimKiemNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiemNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        JpnTacVuNhaCungCapLayout.setVerticalGroup(
            JpnTacVuNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpnTacVuNhaCungCapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpnTacVuNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRefreshNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemSuaNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JpnTacVuNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXoaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimKiemNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiemNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelNhaCungCapLayout = new javax.swing.GroupLayout(PanelNhaCungCap);
        PanelNhaCungCap.setLayout(PanelNhaCungCapLayout);
        PanelNhaCungCapLayout.setHorizontalGroup(
            PanelNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNhaCungCapLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(PanelNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPaneNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JpnTacVuNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        PanelNhaCungCapLayout.setVerticalGroup(
            PanelNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNhaCungCapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JpnTacVuNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        PanelView.add(PanelNhaCungCap, "PanelNhaCungCap");

        PanelNhanVien.setBackground(new java.awt.Color(255, 255, 255));

        tableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "MaNV", "Số điện thoại", "Địa chỉ", "Ngày sinh", "Giới tính", "Chức vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneNhanVien.setViewportView(tableNhanVien);

        jpnTacVuNhanVien.setBackground(new java.awt.Color(255, 255, 255));

        btnThemSuaNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Action-edit-icon.png"))); // NOI18N
        btnThemSuaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSuaNhanVienActionPerformed(evt);
            }
        });

        btnXoaNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Action-cancel-icon.png"))); // NOI18N
        btnXoaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNhanVienActionPerformed(evt);
            }
        });

        btnTimKiemNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-search.png"))); // NOI18N
        btnTimKiemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemNhanVienActionPerformed(evt);
            }
        });

        btnRefreshNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Actions-view-refresh-icon.png"))); // NOI18N
        btnRefreshNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshNhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnTacVuNhanVienLayout = new javax.swing.GroupLayout(jpnTacVuNhanVien);
        jpnTacVuNhanVien.setLayout(jpnTacVuNhanVienLayout);
        jpnTacVuNhanVienLayout.setHorizontalGroup(
            jpnTacVuNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTacVuNhanVienLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(btnRefreshNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThemSuaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jpnTacVuNhanVienLayout.setVerticalGroup(
            jpnTacVuNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTacVuNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnTacVuNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnTacVuNhanVienLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThemSuaNhanVien))
                    .addComponent(btnRefreshNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnTacVuNhanVienLayout.createSequentialGroup()
                        .addGroup(jpnTacVuNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelNhanVienLayout = new javax.swing.GroupLayout(PanelNhanVien);
        PanelNhanVien.setLayout(PanelNhanVienLayout);
        PanelNhanVienLayout.setHorizontalGroup(
            PanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNhanVienLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPaneNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpnTacVuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        PanelNhanVienLayout.setVerticalGroup(
            PanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnTacVuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelView.add(PanelNhanVien, "PanelNhanVien");

        PanelHoaDon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Đơn giá", "Số lượng", "Tổng tiền", "Ngày xuất HD", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Tên sản phẩm", "Họ tên nhân viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoaDon);

        PanelHoaDon.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 721, 139));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mã hóa đơn:");
        PanelHoaDon.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 119, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Đơn giá:");
        PanelHoaDon.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 119, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tổng tiền:");
        PanelHoaDon.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 119, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Số lượng:");
        PanelHoaDon.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 119, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Ngày xuất HD:");
        PanelHoaDon.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 119, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Tên khách hàng:");
        PanelHoaDon.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 119, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Số điện thoại:");
        PanelHoaDon.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 119, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Địa chỉ:");
        PanelHoaDon.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 119, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Tên sản phẩm:");
        PanelHoaDon.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 119, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Họ tên nhân viên:");
        PanelHoaDon.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 119, -1));
        PanelHoaDon.add(txtMaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 196, -1));
        PanelHoaDon.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 196, -1));
        PanelHoaDon.add(txtDonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 196, -1));
        PanelHoaDon.add(txtNgayXuatHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 196, -1));
        PanelHoaDon.add(txtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 196, -1));
        PanelHoaDon.add(txtHoTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 196, -1));
        PanelHoaDon.add(txtTenSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 196, -1));
        PanelHoaDon.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 196, -1));
        PanelHoaDon.add(txtSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 196, -1));
        PanelHoaDon.add(txtTenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 196, -1));

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        PanelHoaDon.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, -1, -1));

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        PanelHoaDon.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, -1, -1));

        btnTimKiemMaHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTimKiemMaHD.setText("Tìm kiếm");
        btnTimKiemMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemMaHDActionPerformed(evt);
            }
        });
        PanelHoaDon.add(btnTimKiemMaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, -1, -1));

        btnLuu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        PanelHoaDon.add(btnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Tìm kiếm mã HD:");
        PanelHoaDon.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 119, -1));
        PanelHoaDon.add(txtTimKiemMaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 420, -1));

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        PanelHoaDon.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        PanelView.add(PanelHoaDon, "PanelHoaDon");

        javax.swing.GroupLayout PanelKhachHangLayout = new javax.swing.GroupLayout(PanelKhachHang);
        PanelKhachHang.setLayout(PanelKhachHangLayout);
        PanelKhachHangLayout.setHorizontalGroup(
            PanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 733, Short.MAX_VALUE)
        );
        PanelKhachHangLayout.setVerticalGroup(
            PanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );

        PanelView.add(PanelKhachHang, "PanelKhachHang");

        javax.swing.GroupLayout PanelThongKeLayout = new javax.swing.GroupLayout(PanelThongKe);
        PanelThongKe.setLayout(PanelThongKeLayout);
        PanelThongKeLayout.setHorizontalGroup(
            PanelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 733, Short.MAX_VALUE)
        );
        PanelThongKeLayout.setVerticalGroup(
            PanelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );

        PanelView.add(PanelThongKe, "PanelThongKe");

        jSplitPane1.setRightComponent(PanelView);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpnDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnDangXuatMouseClicked
        DangNhap qk = new DangNhap();
        qk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        qk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jpnDangXuatMouseClicked

    private void jpnQLSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnQLSanPhamMouseClicked
        cardlayout.show(PanelView, "PanelSanPham");
        fillDataToTableSanPham();
    }//GEN-LAST:event_jpnQLSanPhamMouseClicked

    private void jpnQLNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnQLNhaCungCapMouseClicked
        cardlayout.show(PanelView, "PanelNhaCungCap");
        fillDataToTableNhaCungCap();
    }//GEN-LAST:event_jpnQLNhaCungCapMouseClicked

    private void jlbQLNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbQLNhaCungCapMouseClicked
        cardlayout.show(PanelView, "PanelNhaCungCap");
        fillDataToTableNhaCungCap();
    }//GEN-LAST:event_jlbQLNhaCungCapMouseClicked

    private void jpnQLTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnQLTaiKhoanMouseClicked
        cardlayout.show(PanelView, "PanelNhanVien");
        fillDataToTableNhanVien();
    }//GEN-LAST:event_jpnQLTaiKhoanMouseClicked

    private void jlbQLTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbQLTaiKhoanMouseClicked
        cardlayout.show(PanelView, "PanelNhanVien");
        fillDataToTableNhanVien();
    }//GEN-LAST:event_jlbQLTaiKhoanMouseClicked

    private void PanelSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSanPhamMouseClicked
        cardlayout.show(PanelView, "PanelSanPham");
        fillDataToTableSanPham();
    }//GEN-LAST:event_PanelSanPhamMouseClicked

    private void btnThemSuaNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSuaNhaCungCapActionPerformed
        frmNhaCungCap qk = new frmNhaCungCap();
        qk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        qk.setVisible(true);
        fillDataToTableNhaCungCap();
    }//GEN-LAST:event_btnThemSuaNhaCungCapActionPerformed

    private void btnXoaNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNhaCungCapActionPerformed
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
                fillDataToTableNhaCungCap();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một nhà cung cấp để xóa!");
        }
    }//GEN-LAST:event_btnXoaNhaCungCapActionPerformed

    private void btnTimKiemNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemNhaCungCapActionPerformed
        NhaCungCapDAO cddao = new NhaCungCapDAO();
        NhaCungCap ncc = new NhaCungCap();
        try {
            listNhaCungCap = cddao.searchNhaCungCap(btnTimKiemNhaCungCap.getText());
            fillDataSearchToTableNhaCungCap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTimKiemNhaCungCapActionPerformed

    private void btnRefreshNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshNhaCungCapActionPerformed
        fillDataToTableNhaCungCap();
    }//GEN-LAST:event_btnRefreshNhaCungCapActionPerformed

    private void btnThemSuaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSuaNhanVienActionPerformed
        frmNhanVien qlnv = new frmNhanVien();
        qlnv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        qlnv.setVisible(true);
    }//GEN-LAST:event_btnThemSuaNhanVienActionPerformed

    private void btnXoaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNhanVienActionPerformed
        NhanVienDAO cddao = new NhanVienDAO();

        int selectedRow = tableNhanVien.getSelectedRow();
        int columnIndex = 1;
        String cellValue = null;

        if (selectedRow != -1) {
            Object value = tableNhanVien.getValueAt(selectedRow, columnIndex);
            cellValue = value.toString();
        }

        if (cellValue != null) {
            int x = cddao.removeNhanVien(cellValue);
            if (x > 0) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                fillDataToTableNhanVien();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để xóa!");
        }
    }//GEN-LAST:event_btnXoaNhanVienActionPerformed

    private void btnTimKiemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemNhanVienActionPerformed
        NhanVienDAO nvdao = new NhanVienDAO();
        NhanVien nv = new NhanVien();
        try {

            fillDataSearchToTableSanPham();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTimKiemNhanVienActionPerformed

    private void btnRefreshNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshNhanVienActionPerformed
        fillDataToTableNhanVien();
    }//GEN-LAST:event_btnRefreshNhanVienActionPerformed

    private void btnRefreshSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshSanPhamActionPerformed
        fillDataToTableSanPham();
    }//GEN-LAST:event_btnRefreshSanPhamActionPerformed

    private void btnTimKiemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemSanPhamActionPerformed
        SanPhamDAO cddao = new SanPhamDAO();
        SanPham sp = new SanPham();
        try {
            fillDataSearchToTableSanPham();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTimKiemSanPhamActionPerformed

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed
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
                fillDataToTableSanPham();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để xóa!");
        }
    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void btnThemSuaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSuaSanPhamActionPerformed
        frmSanPham qk = new frmSanPham();
        qk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        qk.setVisible(true);
        fillDataToTableSanPham();
    }//GEN-LAST:event_btnThemSuaSanPhamActionPerformed

    private void tableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSanPhamMouseClicked
        try {
            int dong = tableSanPham.getSelectedRow();
            if (dong >= 0) {
                String id = (String) tableSanPham.getValueAt(dong, 0);
                SanPhamDAO dao = new SanPhamDAO();
                SanPham st = dao.timTheoID(id);
                if (st != null) {
                    LabelDeTailMaSP.setText(st.getMaSP());
                    LabelDeTailTenSP.setText(st.getTenSP());
                    LabelDeTailGiaBan.setText(String.valueOf(st.getGiaBan()));
                    LabelDeTailNgaySanXuat.setText(st.getNgaySanXuat().toString());
                    if (st.getTinhTrang() == 1) {
                        LabelDeTailTinhTrang.setText("Mới");
                    } else {
                        LabelDeTailTinhTrang.setText("Cũ");
                    }
                    loadHinh(st.getHinhAnh());
                }

            } else {
                JOptionPane.showMessageDialog(this, "Bạn chưa thêm 1 dòng vào bảng");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tableSanPhamMouseClicked

    private void jlbQLHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbQLHoaDonMouseClicked
        cardlayout.show(PanelView, "PanelHoaDon");
        fillDataToTableHoaDon();
    }//GEN-LAST:event_jlbQLHoaDonMouseClicked

    private void jlbQLKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbQLKhachHangMouseClicked
        cardlayout.show(PanelView, "PanelKhachHang");
    }//GEN-LAST:event_jlbQLKhachHangMouseClicked

    private void jlbQLThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbQLThongKeMouseClicked
        cardlayout.show(PanelView, "PanelThongKe");
    }//GEN-LAST:event_jlbQLThongKeMouseClicked

    private void btnTimKiemMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemMaHDActionPerformed
        String maHD = txtTimKiemMaHD.getText();
        try {
            HoaDonDAO dao = new HoaDonDAO();
            phieuHoaDon phieu = dao.timTheoID(maHD);
            if (phieu != null) {
                txtMaHD.setText(phieu.getMaHD());
                txtDonGia.setText(String.valueOf(phieu.getDonGia()));
                txtSoLuong.setText(String.valueOf(phieu.getSoLuong()));
                txtTongTien.setText(String.valueOf(phieu.getTongTien()));
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                txtNgayXuatHD.setText(dateFormat.format(phieu.getNgayXuatHD()));
                txtTenKH.setText(phieu.getTenKH());
                txtSoDienThoai.setText(phieu.getSdt());
                txtDiaChi.setText(phieu.getDiaChi());
                txtTenSanPham.setText(phieu.getTenSP());
                txtHoTenNV.setText(phieu.getHoTenNV());
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy phiếu hoá đơn với mã HD: " + maHD, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi tìm kiếm phiếu hoá đơn", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        fillDataToTableHoaDon();
    }//GEN-LAST:event_btnTimKiemMaHDActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        txtMaHD.setText("");
        txtTenKH.setText("");
        txtSoDienThoai.setText("");
        txtDiaChi.setText("");
        txtTenSanPham.setText("");
        txtHoTenNV.setText("");
        txtDonGia.setText("");
        txtTongTien.setText("");
        txtSoLuong.setText("");
        txtNgayXuatHD.setText("");
    }//GEN-LAST:event_btnThemActionPerformed

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        try {
            int dong = tbHoaDon.getSelectedRow();
            if (dong >= 0) {
                String id = (String) tbHoaDon.getValueAt(dong, 0);
                HoaDonDAO dao = new HoaDonDAO();
                phieuHoaDon hd = dao.timTheoID(id);
                if (hd != null) {
                    txtMaHD.setText(hd.getMaHD());
                    txtTenKH.setText(hd.getTenKH());
                    txtSoDienThoai.setText(hd.getSdt());
                    txtDiaChi.setText(hd.getDiaChi());
                    txtTenSanPham.setText(hd.getTenSP());
                    txtHoTenNV.setText(hd.getHoTenNV());
                    txtDonGia.setText(String.valueOf(hd.getDonGia()));
                    txtTongTien.setText(String.valueOf(hd.getTongTien()));
                    txtSoLuong.setText(String.valueOf(hd.getSoLuong()));
                    txtNgayXuatHD.setText(hd.getNgayXuatHD().toString());
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn một dòng trong bảng.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            int dong = tbHoaDon.getSelectedRow();
            if (dong >= 0) {
                String id = (String) tbHoaDon.getValueAt(dong, 0);
                HoaDonDAO dao = new HoaDonDAO();
                int result = dao.removeHoaDon(id);
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Xóa hóa đơn thành công.");
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể xóa hóa đơn.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn một dòng trong bảng.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi xóa hóa đơn.");
        }
        fillDataToTableHoaDon();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            String MaHD = txtMaHD.getText();
            float DonGia = Float.parseFloat(txtDonGia.getText());
            int SoLuong = Integer.parseInt(txtSoLuong.getText());
            float TongTien = Float.parseFloat(txtTongTien.getText());
            java.util.Date NgayXuatHD = new SimpleDateFormat("dd-MM-yyyy").parse(txtNgayXuatHD.getText());
            String TenKH = txtTenKH.getText();
            String Sdt = txtSoDienThoai.getText();
            String DiaChi = txtDiaChi.getText();
            String TenSP = txtTenSanPham.getText();
            String HoTenNV = txtHoTenNV.getText();

            HoaDonDAO dao = new HoaDonDAO();
            int result = dao.updateHoaDon(MaHD, DonGia, SoLuong, TongTien, NgayXuatHD, TenKH, Sdt, DiaChi, TenSP, HoTenNV);
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật hóa đơn thành công.");
            } else {
                JOptionPane.showMessageDialog(this, "Không thể cập nhật hóa đơn.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi cập nhật hóa đơn.");
        }
        fillDataToTableHoaDon();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
//        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm hóa đơn không?", "Hỏi",
//                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
//            return;
//        }
//        try {
//            String MaHD = txtMaHD.getText();
//            float DonGia = Float.parseFloat(txtDonGia.getText());
//            int SoLuong = Integer.parseInt(txtSoLuong.getText());
//            float TongTien = Float.parseFloat(txtTongTien.getText());
//            java.util.Date NgayXuatHD = new SimpleDateFormat("dd-MM-yyyy").parse(txtNgayXuatHD.getText());
//            String TenKH = txtTenKH.getText();
//            String Sdt = txtSoDienThoai.getText();
//            String DiaChi = txtDiaChi.getText();
//            String TenSP = txtTenSanPham.getText();
//            String HoTenNV = txtHoTenNV.getText();
//
//            phieuHoaDon hd = new phieuHoaDon();
//            hd.setMaHD(MaHD);
//            hd.setDonGia(DonGia);
//            hd.setSoLuong(SoLuong);
//            hd.setTongTien(TongTien);
//            hd.setNgayXuatHD(NgayXuatHD);
//            hd.setTenKH(TenKH);
//            hd.setSdt(Sdt);
//            hd.setDiaChi(DiaChi);
//            hd.setTenSP(TenSP);
//            hd.setHoTenNV(HoTenNV);
//
//            HoaDonDAO dao = new HoaDonDAO();
//            int result = dao.addHoaDon(hd);
//            if (result == 1) {
//                JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                JOptionPane.showMessageDialog(this, "Thêm hóa đơn thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        fillDataToTableHoaDon();

    }//GEN-LAST:event_btnLuuActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpnTacVuNhaCungCap;
    private javax.swing.JLabel LabelDeTailGiaBan;
    private javax.swing.JLabel LabelDeTailMaSP;
    private javax.swing.JLabel LabelDeTailNgaySanXuat;
    private javax.swing.JLabel LabelDeTailTenSP;
    private javax.swing.JLabel LabelDeTailTinhTrang;
    private javax.swing.JLabel LabelDetailHinhAnhSP;
    private javax.swing.JPanel PanelDetailSanPham;
    private javax.swing.JPanel PanelHoaDon;
    private javax.swing.JPanel PanelKhachHang;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelNhaCungCap;
    private javax.swing.JPanel PanelNhanVien;
    private javax.swing.JPanel PanelSanPham;
    private javax.swing.JPanel PanelThongKe;
    private javax.swing.JPanel PanelView;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnRefreshNhaCungCap;
    private javax.swing.JButton btnRefreshNhanVien;
    private javax.swing.JButton btnRefreshSanPham;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemSuaNhaCungCap;
    private javax.swing.JButton btnThemSuaNhanVien;
    private javax.swing.JButton btnThemSuaSanPham;
    private javax.swing.JButton btnTimKiemMaHD;
    private javax.swing.JButton btnTimKiemNhaCungCap;
    private javax.swing.JButton btnTimKiemNhanVien;
    private javax.swing.JButton btnTimKiemSanPham;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaNhaCungCap;
    private javax.swing.JButton btnXoaNhanVien;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneNhaCungCap;
    private javax.swing.JScrollPane jScrollPaneNhanVien;
    private javax.swing.JScrollPane jScrollPaneSanPham;
    private javax.swing.JSplitPane jSplitPane1;
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
    private javax.swing.JPanel jpnTacVuNhanVien;
    private javax.swing.JPanel jpnTacVuSanPham;
    private javax.swing.JPanel jpnTrangChu;
    private javax.swing.JTable tableNhaCungCap;
    private javax.swing.JTable tableNhanVien;
    private javax.swing.JTable tableSanPham;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtHoTenNV;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayXuatHD;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTimKiemMaHD;
    private javax.swing.JTextField txtTimKiemNhaCungCap;
    private javax.swing.JTextField txtTimKiemNhanVien;
    private javax.swing.JTextField txtTimKiemSanPham;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
