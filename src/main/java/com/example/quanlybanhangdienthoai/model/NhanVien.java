package com.example.quanlybanhangdienthoai.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Table(name = "NhanVien")
@Entity
public class NhanVien {

    @Id
    @Column(name = "MaNV")
    private String maNV;

    @Column(name = "TenNV")
    private String tenNV;

    @Column(name = "GioiTinh")
    private Integer gioiTinh;

    @Column(name = "QueQuan")
    private String queQuan;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "NgayLamViec")
    private LocalDate ngayLamViec;

    @Column(name = "QuyenHan")
    private String quyenHan;

    @Column(name = "matkhau")
    private String matKhau;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, Integer gioiTinh, String queQuan, String diaChi, LocalDate ngayLamViec, String quyenHan, String matKhau) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.diaChi = diaChi;
        this.ngayLamViec = ngayLamViec;
        this.quyenHan = quyenHan;
        this.matKhau = matKhau;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public LocalDate getNgayLamViec() {
        return ngayLamViec;
    }

    public void setNgayLamViec(LocalDate ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }

    public String getQuyenHan() {
        return quyenHan;
    }

    public void setQuyenHan(String quyenHan) {
        this.quyenHan = quyenHan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}

