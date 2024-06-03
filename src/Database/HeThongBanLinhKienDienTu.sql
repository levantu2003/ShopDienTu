CREATE DATABASE BanLinhKienDienTu
GO
USE BanLinhKienDienTu
GO
CREATE TABLE [SanPham] (
	[MaSP] NVARCHAR(11) NOT NULL UNIQUE,
	[TenSP] NVARCHAR(255),
	[GiaBan] FLOAT,
	[MoTa] NTEXT,
	[NgaySanXuat] DATE,
	[TinhTrang] INT,
	[HinhAnh] VARBINARY(MAX),
	[MaLoai] NVARCHAR(11),
	PRIMARY KEY([MaSP])
);
GO

CREATE TABLE [LoaiSP] (
	[MaLoai] NVARCHAR(11) NOT NULL UNIQUE,
	[TenLoai] NVARCHAR(255),
	PRIMARY KEY([MaLoai])
);
GO

CREATE TABLE [NhaCungCap] (
	[MaNCC] NVARCHAR(11) NOT NULL UNIQUE,
	[TenNCC] NVARCHAR(255),
	[DiaChiNCC] NVARCHAR(255),
	PRIMARY KEY([MaNCC])
);
GO

CREATE TABLE [PhieuNhap] (
	[MaPN] NVARCHAR(11) NOT NULL UNIQUE,
	[NgayNhap] DATE,
	[GiaNhap] FLOAT,
	[SoLuongNhap] INT,
	[TongTienNhap] FLOAT,
	[MaNCC] NVARCHAR(11),
	[MaSP] NVARCHAR(11),
	[MaNV] NVARCHAR(11),
	PRIMARY KEY([MaPN])
);
GO

CREATE TABLE [NhanVien] (
	[MaNV] NVARCHAR(11) NOT NULL UNIQUE,
	[HoTenNV] NVARCHAR(255),
	[GioiTinh] NVARCHAR(5),
	[NgaySinh] DATE,
	[Sdt] NVARCHAR(11),
	[DiaChi] NVARCHAR(255),
	[MaCV] NVARCHAR(11),
	PRIMARY KEY([MaNV])
);
GO

CREATE TABLE [NguoiDung] (
	[MaND] NVARCHAR(11) NOT NULL UNIQUE,
	[Email] NVARCHAR(255),
	[MatKhau] NVARCHAR(255),
	PRIMARY KEY([MaND])
);
GO

CREATE TABLE [KhachHang] (
	[MaKH] NVARCHAR(11) NOT NULL UNIQUE,
	[TenKH] NVARCHAR(255),
	[GioiTinh] NVARCHAR(5),
	[Sdt] NVARCHAR(11),
	[DiaChi] NVARCHAR(255),
	PRIMARY KEY([MaKH])
);
GO

CREATE TABLE [HoaDon] (
	[MaHD] NVARCHAR(11) NOT NULL UNIQUE,
	[DonViTinh] NVARCHAR(255),
	[DonGia] NVARCHAR(255),
	[SoLuong] INT,
	[TongTien] FLOAT,
	[NgayXuatHD] DATE,
	[MaKH] NVARCHAR(11),
	[MaNV] NVARCHAR(11),
	PRIMARY KEY([MaHD])
);
GO

CREATE TABLE [GioHang] (
	[MaGH] NVARCHAR(11) NOT NULL UNIQUE,
	[ThanhTien] FLOAT,
	[MaKH] NVARCHAR(11),
	PRIMARY KEY([MaGH])
);
GO

CREATE TABLE [ChucVu] (
	[MaCV] NVARCHAR(11) NOT NULL UNIQUE,
	[TenCV] NVARCHAR(255),
	PRIMARY KEY([MaCV])
);
GO

CREATE TABLE [ChiTietPhanQuyen] (
	[MaCTPQ] NVARCHAR(11) NOT NULL UNIQUE,
	[QuyenDuocCapPhep] NVARCHAR(255),
	[KiemTraHanhDong] INT,
	[MaPQ] NVARCHAR(11),
	PRIMARY KEY([MaCTPQ])
);
GO

CREATE TABLE [HoaDon_SanPham] (
	[MaSP] NVARCHAR(11),
	[MaHD] NVARCHAR(11),
	PRIMARY KEY([MaSP], [MaHD])
);
GO

CREATE TABLE [NguoiDung_PhanQuyen] (
	[MaND] NVARCHAR(11),
	[MaPQ] NVARCHAR(11),
	PRIMARY KEY([MaND], [MaPQ])
);
GO

CREATE TABLE [SanPham_GioHang] (
	[MaSP] NVARCHAR(11),
	[MaGH] NVARCHAR(11),
	[SoLuong] INT,
	[DonGia] FLOAT,
	PRIMARY KEY([MaSP], [MaGH])
);
GO

CREATE TABLE [Kho] (
	[MaKho] NVARCHAR(11) NOT NULL UNIQUE,
	[DiaChiKho] NVARCHAR(255),
	PRIMARY KEY([MaKho])
);
GO

CREATE TABLE [Kho_SanPham] (
	[MaKho] NVARCHAR(11),
	[MaSP] NVARCHAR(11),
	[SoLuongTon] INT,
	PRIMARY KEY([MaKho], [MaSP])
);
GO

CREATE TABLE [ThongKeHoaDon] (
	[MaTKHD] NVARCHAR(11) NOT NULL UNIQUE,
	[NgayBan] DATE,
	[SoLuongDaBan] INT,
	[TongDonGiaBan] FLOAT,
	[TongGiaBan] FLOAT,
	[MaNV] NVARCHAR(11),
	PRIMARY KEY([MaTKHD])
);
GO

CREATE TABLE [ThongKePhieuNhap] (
	[MaTKPN] NVARCHAR(11) NOT NULL UNIQUE,
	[SoLuongDaNhap] INT,
	[TongDonGiaNhap] FLOAT,
	[TongGiaNhap] FLOAT,
	[MaNV] NVARCHAR(11),
	PRIMARY KEY([MaTKPN])
);
GO

CREATE TABLE [PhanQuyen] (
	[MaPQ] NVARCHAR(11) NOT NULL UNIQUE,
	[TenNhomQuyen] NVARCHAR(255),
	PRIMARY KEY([MaPQ])
);
GO

ALTER TABLE [SanPham]
ADD FOREIGN KEY([MaLoai]) REFERENCES [LoaiSP]([MaLoai])
ON UPDATE NO ACTION ON DELETE CASCADE;
GO
ALTER TABLE [Kho_SanPham]
ADD FOREIGN KEY([MaKho]) REFERENCES [Kho]([MaKho])
ON UPDATE NO ACTION ON DELETE CASCADE;
GO
ALTER TABLE [Kho_SanPham]
ADD FOREIGN KEY([MaSP]) REFERENCES [SanPham]([MaSP])
ON UPDATE NO ACTION ON DELETE CASCADE;
GO
ALTER TABLE [PhieuNhap]
ADD FOREIGN KEY([MaNCC]) REFERENCES [NhaCungCap]([MaNCC])
ON UPDATE NO ACTION ON DELETE CASCADE;
GO
ALTER TABLE [PhieuNhap]
ADD FOREIGN KEY([MaSP]) REFERENCES [SanPham]([MaSP])
ON UPDATE NO ACTION ON DELETE CASCADE;
GO
ALTER TABLE [PhieuNhap]
ADD FOREIGN KEY([MaNV]) REFERENCES [NhanVien]([MaNV])
ON UPDATE NO ACTION ON DELETE CASCADE;
GO
ALTER TABLE [HoaDon]
ADD FOREIGN KEY([MaNV]) REFERENCES [NhanVien]([MaNV])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [HoaDon]
ADD FOREIGN KEY([MaKH]) REFERENCES [KhachHang]([MaKH])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [HoaDon_SanPham]
ADD FOREIGN KEY([MaSP]) REFERENCES [SanPham]([MaSP])
ON UPDATE NO ACTION ON DELETE CASCADE;
GO
ALTER TABLE [HoaDon_SanPham]
ADD FOREIGN KEY([MaHD]) REFERENCES [HoaDon]([MaHD])
ON UPDATE NO ACTION ON DELETE CASCADE;
GO
ALTER TABLE [SanPham_GioHang]
ADD FOREIGN KEY([MaSP]) REFERENCES [SanPham]([MaSP])
ON UPDATE NO ACTION ON DELETE CASCADE;
GO
ALTER TABLE [SanPham_GioHang]
ADD FOREIGN KEY([MaGH]) REFERENCES [GioHang]([MaGH])
ON UPDATE NO ACTION ON DELETE CASCADE;
GO
ALTER TABLE [ThongKeHoaDon]
ADD FOREIGN KEY([MaNV]) REFERENCES [NhanVien]([MaNV])
ON UPDATE NO ACTION ON DELETE CASCADE;
GO
ALTER TABLE [ThongKePhieuNhap]
ADD FOREIGN KEY([MaNV]) REFERENCES [NhanVien]([MaNV])
ON UPDATE NO ACTION ON DELETE CASCADE;
GO
ALTER TABLE [NhanVien]
ADD FOREIGN KEY([MaCV]) REFERENCES [ChucVu]([MaCV])
ON UPDATE NO ACTION ON DELETE NO ACTION;
GO
ALTER TABLE [NguoiDung_PhanQuyen]
ADD FOREIGN KEY([MaND]) REFERENCES [NguoiDung]([MaND])
ON UPDATE NO ACTION ON DELETE CASCADE;
GO
ALTER TABLE [NguoiDung_PhanQuyen]
ADD FOREIGN KEY([MaPQ]) REFERENCES [PhanQuyen]([MaPQ])
ON UPDATE NO ACTION ON DELETE CASCADE;
GO
ALTER TABLE [ChiTietPhanQuyen]
ADD FOREIGN KEY([MaPQ]) REFERENCES [PhanQuyen]([MaPQ])
ON UPDATE NO ACTION ON DELETE CASCADE;
GO

-- Thêm dữ liệu cho bảng LoaiSP
INSERT INTO LoaiSP (MaLoai, TenLoai) VALUES
(N'LSP01', N'Linh kiện máy tính'),
(N'LSP02', N'Linh kiện điện tử'),
(N'LSP03', N'Thiết bị gia dụng');

-- Thêm dữ liệu cho bảng NhaCungCap
INSERT INTO NhaCungCap (MaNCC, TenNCC, DiaChiNCC) VALUES
(N'NCC01', N'Công ty ABC', N'123 Đường XYZ, Quận 1, TP.HCM'),
(N'NCC02', N'Công ty DEF', N'456 Đường PQR, Quận Tân Bình, TP.HCM'),
(N'NCC03', N'Công ty GHI', N'789 Đường STU, Quận Bình Thạnh, TP.HCM');

-- Thêm dữ liệu cho bảng ChucVu
INSERT INTO ChucVu (MaCV, TenCV) VALUES
(N'CV01', N'Nhân viên bán hàng'),
(N'CV02', N'Nhân viên kho'),
(N'CV03', N'Quản lý');

-- Thêm dữ liệu cho bảng NhanVien
INSERT INTO NhanVien (MaNV, HoTenNV, GioiTinh, NgaySinh, Sdt, DiaChi, MaCV) VALUES
(N'NV01', N'Nguyễn Văn A', N'Nam', '1990-05-15', N'0987654321', N'123 Đường ABC, Quận 1, TP.HCM', N'CV01'),
(N'NV02', N'Trần Thị B', N'Nữ', '1985-10-20', N'0912345678', N'456 Đường DEF, Quận Tân Bình, TP.HCM', N'CV02'),
(N'NV03', N'Lê Văn C', N'Nam', '1982-03-01', N'0919876543', N'789 Đường GHI, Quận Bình Thạnh, TP.HCM', N'CV03');

-- Thêm dữ liệu cho bảng SanPham
INSERT INTO SanPham (MaSP, TenSP, GiaBan, MoTa, NgaySanXuat, TinhTrang, HinhAnh, MaLoai) VALUES
(N'SP01', N'Ổ cứng HDD 1TB', 1500000, N'Ổ cứng HDD dung lượng 1TB', '2022-01-15', 1, NULL, N'LSP01'),
(N'SP02', N'Mainboard ASUS', 2800000, N'Mainboard ASUS cho máy tính để bàn', '2023-03-01', 1, NULL, N'LSP01'),
(N'SP03', N'Màn hình LCD 24 inch', 3200000, N'Màn hình LCD kích thước 24 inch', '2022-06-20', 1, NULL, N'LSP01');

-- Thêm dữ liệu cho bảng PhanQuyen
INSERT INTO PhanQuyen (MaPQ, TenNhomQuyen) VALUES
(N'PQ01', N'Quản lý'),
(N'PQ02', N'Nhân viên bán hàng'),
(N'PQ03', N'Nhân viên kho');

-- Thêm dữ liệu cho bảng NguoiDung
INSERT INTO NguoiDung (MaND, Email, MatKhau) VALUES
(N'ND01', N'quanly@example.com', N'482c811da5d5b4bc6d497ffa98491e38'), -- Pass là password123
(N'ND02', N'nhanvien1@example.com', N'96b33694c4bb7dbd07391e0be54745fb'), -- Pass là password456
(N'ND03', N'nhanvien2@example.com', N'7d347cf0ee68174a3588f6cba31b8a67'); -- Pass là password789

-- Thêm dữ liệu cho bảng NguoiDung_PhanQuyen
INSERT INTO NguoiDung_PhanQuyen (MaND, MaPQ) VALUES
(N'ND01', N'PQ01'),
(N'ND02', N'PQ02'),
(N'ND03', N'PQ03');

-- Thêm dữ liệu cho bảng KhachHang
INSERT INTO KhachHang (MaKH, TenKH, GioiTinh, Sdt, DiaChi) VALUES
(N'KH01', N'Nguyễn Văn D', N'Nam', N'0912345678', N'456 Đường XYZ, Quận 1, TP.HCM'),
(N'KH02', N'Trần Thị E', N'Nữ', N'0987654321', N'789 Đường PQR, Quận Tân Bình, TP.HCM'),
(N'KH03', N'Lê Văn F', N'Nam', N'0919876543', N'123 Đường STU, Quận Bình Thạnh, TP.HCM');

-- Thêm dữ liệu cho bảng GioHang
INSERT INTO GioHang (MaGH, ThanhTien, MaKH) VALUES
(N'GH01', 5000000, N'KH01'),
(N'GH02', 8500000, N'KH02'),
(N'GH03', 3200000, N'KH03');

-- Thêm dữ liệu cho bảng SanPham_GioHang
INSERT INTO SanPham_GioHang (MaSP, MaGH, SoLuong, DonGia) VALUES
(N'SP01', N'GH01', 2, 1500000),
(N'SP02', N'GH02', 1, 2800000),
(N'SP03', N'GH03', 1, 3200000);

-- Thêm dữ liệu cho bảng Kho
INSERT INTO Kho (MaKho, DiaChiKho) VALUES
(N'KHO01', N'123 Đường ABC, Quận 1, TP.HCM'),
(N'KHO02', N'456 Đường DEF, Quận Tân Bình, TP.HCM'),
(N'KHO03', N'789 Đường GHI, Quận Bình Thạnh, TP.HCM');

-- Thêm dữ liệu cho bảng Kho_SanPham
INSERT INTO Kho_SanPham (MaKho, MaSP, SoLuongTon) VALUES
(N'KHO01', N'SP01', 100),
(N'KHO02', N'SP02', 50),
(N'KHO03', N'SP03', 80);

-- Thêm dữ liệu cho bảng HoaDon
INSERT INTO HoaDon (MaHD, DonViTinh, DonGia, SoLuong, TongTien, NgayXuatHD, MaKH, MaNV) VALUES
(N'HD01', N'Cái', 1500000, 2, 3000000, '2023-05-01', N'KH01', N'NV01'),
(N'HD02', N'Cái', 2800000, 1, 2800000, '2023-05-10', N'KH02', N'NV01'),
(N'HD03', N'Cái', 3200000, 1, 3200000, '2023-05-15', N'KH03', N'NV02');

-- Thêm dữ liệu cho bảng HoaDon_SanPham
INSERT INTO HoaDon_SanPham (MaSP, MaHD) VALUES
(N'SP01', N'HD01'),
(N'SP02', N'HD02'),
(N'SP03', N'HD03');

-- Thêm dữ liệu cho bảng PhieuNhap
INSERT INTO PhieuNhap (MaPN, NgayNhap, GiaNhap, SoLuongNhap, TongTienNhap, MaNCC, MaSP, MaNV) VALUES
(N'PN01', '2023-04-01', 1200000, 100, 120000000, N'NCC01', N'SP01', N'NV03'),
(N'PN02', '2023-04-10', 2400000, 50, 120000000, N'NCC02', N'SP02', N'NV03'),
(N'PN03', '2023-04-20', 2800000, 80, 224000000, N'NCC03', N'SP03', N'NV03');

-- Thêm dữ liệu cho bảng ChiTietPhanQuyen
INSERT INTO ChiTietPhanQuyen (MaCTPQ, QuyenDuocCapPhep, KiemTraHanhDong, MaPQ) VALUES
(N'CTPQ01', N'Quản lý sản phẩm', 1, N'PQ01'),
(N'CTPQ02', N'Quản lý nhân viên', 1, N'PQ01'),
(N'CTPQ03', N'Bán hàng', 1, N'PQ02');

-- Thêm dữ liệu cho bảng ThongKeHoaDon
INSERT INTO ThongKeHoaDon (MaTKHD, NgayBan, SoLuongDaBan, TongDonGiaBan, TongGiaBan, MaNV) VALUES
(N'TKHD01', '2023-05-01', 2, 3000000, 3000000, N'NV01'),
(N'TKHD02', '2023-05-10', 1, 2800000, 2800000, N'NV01'),
(N'TKHD03', '2023-05-15', 1, 3200000, 3200000, N'NV02');

-- Thêm dữ liệu cho bảng ThongKePhieuNhap
INSERT INTO ThongKePhieuNhap (MaTKPN, SoLuongDaNhap, TongDonGiaNhap, TongGiaNhap, MaNV) VALUES
(N'TKPN01', 100, 120000000, 120000000, N'NV03'),
(N'TKPN02', 50, 120000000, 120000000, N'NV03'),
(N'TKPN03', 80, 224000000, 224000000, N'NV03');

SELECT * FROM SanPham;
SELECT * FROM LoaiSP;
SELECT * FROM NhaCungCap;
SELECT * FROM PhieuNhap;
SELECT * FROM NhanVien;
SELECT * FROM NguoiDung;
SELECT * FROM KhachHang;
SELECT * FROM HoaDon;
SELECT * FROM GioHang;
SELECT * FROM ChucVu;
SELECT * FROM ChiTietPhanQuyen;
SELECT * FROM HoaDon_SanPham;
SELECT * FROM NguoiDung_PhanQuyen;
SELECT * FROM SanPham_GioHang;
SELECT * FROM Kho;
SELECT * FROM Kho_SanPham;
SELECT * FROM ThongKeHoaDon;
SELECT * FROM ThongKePhieuNhap;
SELECT * FROM PhanQuyen;

