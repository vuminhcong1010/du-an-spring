package com.example.quanlybanhangdienthoai.controller;


import com.example.quanlybanhangdienthoai.model.Hang;
import com.example.quanlybanhangdienthoai.model.LoaiSanPham;
import com.example.quanlybanhangdienthoai.model.SanPham;
import com.example.quanlybanhangdienthoai.repository.HangRepository;
import com.example.quanlybanhangdienthoai.repository.LoaiSanPhamRepository;
import com.example.quanlybanhangdienthoai.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sanpham")
@CrossOrigin(origins = "http://localhost:8080")
public class SanPhamController {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private HangRepository hangRepository;

    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;

    // Lấy danh sách sản phẩm
    @GetMapping("/hienthi")
    public List<SanPham> getDanhSachSanPham() {
        return sanPhamRepository.findAll();
    }

    // Thêm sản phẩm
    @PostMapping("/them")
    public ResponseEntity<SanPham> themSanPham(@RequestBody SanPham sanPham) {
        sanPham.setNgayTao(LocalDate.now());
        SanPham spMoi = sanPhamRepository.save(sanPham);
        return ResponseEntity.ok(spMoi);
    }

    // Sửa thông tin sản phẩm
    @PutMapping("/sua/{id}")
    public ResponseEntity<SanPham> suaSanPham(@PathVariable Integer id, @RequestBody SanPham sanPhamMoi) {
        return sanPhamRepository.findById(id).map(sp -> {
            sp.setAnhSanPham(sanPhamMoi.getAnhSanPham());
            sp.setMaSanPham(sanPhamMoi.getMaSanPham());
            sp.setTenSanPham(sanPhamMoi.getTenSanPham());
            sp.setTrangThai(sanPhamMoi.getTrangThai());
            sp.setNgaySua(LocalDate.now());
            sp.setMoTa(sanPhamMoi.getMoTa());

            // Cập nhật Hãng
            if (sanPhamMoi.getHang() != null) {
                Hang hang = hangRepository.findById(sanPhamMoi.getHang().getId()).orElse(null);
                sp.setHang(hang);
            }

            // Cập nhật Loại sản phẩm
            if (sanPhamMoi.getLoaiSanPham() != null) {
                LoaiSanPham loai = loaiSanPhamRepository.findById(sanPhamMoi.getLoaiSanPham().getId()).orElse(null);
                sp.setLoaiSanPham(loai);
            }

            sanPhamRepository.save(sp);
            return ResponseEntity.ok(sp);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Xóa sản phẩm
    @DeleteMapping("/xoa/{id}")
    public ResponseEntity<?> xoaSanPham(@PathVariable Integer id) {
        sanPhamRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


    // API lấy danh sách Hãng để hiển thị trong select
    @GetMapping("/hang")
    public List<Hang> getDanhSachHang() {
        return hangRepository.findAll();
    }

    // API lấy danh sách Loại Sản Phẩm để hiển thị trong select
    @GetMapping("/loaisanpham")
    public List<LoaiSanPham> getDanhSachLoaiSanPham() {
        return loaiSanPhamRepository.findAll();
    }

}
