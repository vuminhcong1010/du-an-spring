package com.example.quanlybanhangdienthoai.controller;

import com.example.quanlybanhangdienthoai.model.NhanVien;
import com.example.quanlybanhangdienthoai.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nhanvien")
@CrossOrigin(origins = "http://localhost:8080")
public class NhanVienController {

    @Autowired
    NhanVienRepository nvre;

    @GetMapping("/hienthi")
    public List<NhanVien> getHienThi(){
        return nvre.findAll();
    }

    // Thêm nhân viên mới
    @PostMapping("/them")
    public ResponseEntity<NhanVien> themNhanVien(@RequestBody NhanVien nhanVien) {
        NhanVien nvMoi = nvre.save(nhanVien);
        return ResponseEntity.ok(nvMoi);
    }

    // Sửa thông tin nhân viên
    @PutMapping("/sua/{id}")
    public ResponseEntity<NhanVien> suaNhanVien(@PathVariable String id, @RequestBody NhanVien nhanVienMoi) {
        return nvre.findById(id).map(nv -> {
            nv.setTenNV(nhanVienMoi.getTenNV());
            nv.setGioiTinh(nhanVienMoi.getGioiTinh());
            nv.setQueQuan(nhanVienMoi.getQueQuan());
            nv.setDiaChi(nhanVienMoi.getDiaChi());
            nv.setNgayLamViec(nhanVienMoi.getNgayLamViec());
            nv.setQuyenHan(nhanVienMoi.getQuyenHan());
            nv.setMatKhau(nhanVienMoi.getMatKhau());
            nvre.save(nv);
            return ResponseEntity.ok(nv);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Xóa nhân viên
    @DeleteMapping("/xoa/{id}")
    public ResponseEntity<?> xoaNhanVien(@PathVariable String id) {
        nvre.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
