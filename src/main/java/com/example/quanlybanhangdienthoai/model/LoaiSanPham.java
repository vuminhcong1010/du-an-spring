package com.example.quanlybanhangdienthoai.model;

import jakarta.persistence.*;

@Table(name = "loaisp")
@Entity
public class LoaiSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_LSP")
    private Integer id;

    @Column(name = "ten_LSP")
    private String tenLoai;

    @Column(name = "mo_ta")
    private String moTa;

    public LoaiSanPham() {
    }

    public LoaiSanPham(Integer id, String tenHang, String moTa) {
        this.id = id;
        this.tenLoai = tenHang;
        this.moTa = moTa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
