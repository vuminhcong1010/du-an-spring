package com.example.quanlybanhangdienthoai.controller;


import com.example.quanlybanhangdienthoai.model.KhachHang;
import com.example.quanlybanhangdienthoai.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/khachhang")
@CrossOrigin(origins = "http://localhost:8080")
public class KhachHangController {

    @Autowired
    KhachHangRepository khre;

    @GetMapping("/hienthi")
    public List<KhachHang> getList(){
        List<KhachHang> list = khre.findAll();
        return list;
    }
    @PostMapping("/them")
    public ResponseEntity<KhachHang> themKhachHang(@RequestBody KhachHang khachHang) {
        khachHang.setNgayTao(LocalDate.now()); // Set ngày tạo tự động
        KhachHang khMoi = khre.save(khachHang);
        return ResponseEntity.ok(khMoi);
    }

    // Sửa thông tin khách hàng
    @PutMapping("/sua/{id}")
    public ResponseEntity<KhachHang> suaKhachHang(@PathVariable Integer id, @RequestBody KhachHang khachHangMoi) {
        return khre.findById(id).map(kh -> {
            kh.setTenKhachHang(khachHangMoi.getTenKhachHang());
            kh.setSoDienThoai(khachHangMoi.getSoDienThoai());
            kh.setEmail(khachHangMoi.getEmail());
            kh.setDiaChi(khachHangMoi.getDiaChi());
            khre.save(kh);
            return ResponseEntity.ok(kh);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Xóa khách hàng
    @DeleteMapping("/xoa/{id}")
    public ResponseEntity<?> xoaKhachHang(@PathVariable Integer id) {
        khre.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
