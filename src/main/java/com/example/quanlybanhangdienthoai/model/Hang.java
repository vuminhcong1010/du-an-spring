package com.example.quanlybanhangdienthoai.model;

import jakarta.persistence.*;

@Table(name = "hang")
@Entity
public class Hang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Hang")
    private Integer id;

    @Column(name = "ten_Hang")
    private String tenHang;

    @Column(name = "mo_ta")
    private String moTa;

    public Hang() {
    }

    public Hang(Integer id, String tenHang, String moTa) {
        this.id = id;
        this.tenHang = tenHang;
        this.moTa = moTa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
