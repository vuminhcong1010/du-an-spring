package com.example.quanlybanhangdienthoai.controller;


import com.example.quanlybanhangdienthoai.model.HoaDon;
import com.example.quanlybanhangdienthoai.model.HoaDonChiTiet;
import com.example.quanlybanhangdienthoai.model.KhachHang;
import com.example.quanlybanhangdienthoai.model.SanPhamChiTiet;
import com.example.quanlybanhangdienthoai.repository.HoaDonChiTietRepository;
import com.example.quanlybanhangdienthoai.repository.HoaDonRepository;
import com.example.quanlybanhangdienthoai.repository.KhachHangRepository;
import com.example.quanlybanhangdienthoai.repository.SanPhamChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banhang")
@CrossOrigin(origins = "http://localhost:8080")
public class BanHangController {

    @Autowired
    SanPhamChiTietRepository sanPhamChiTietRepository;
    @Autowired
    KhachHangRepository khachHangRepository;
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;

    @GetMapping("/hienthi")
    public List<SanPhamChiTiet> getHienThi(){
        return sanPhamChiTietRepository.findAll();
    }

    @PostMapping("/tao-don/{maKH}")
    public ResponseEntity<HoaDon> taoHoaDon(@PathVariable Integer maKH) {
        Optional<KhachHang> khachHangOpt = khachHangRepository.findById(maKH);
        if (khachHangOpt.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        HoaDon hoaDon = new HoaDon();
        hoaDon.setKhachHang(khachHangOpt.get());
        hoaDon.setNgayTao(LocalDate.now());
        hoaDon.setNgaySua(LocalDate.now());
        hoaDon.setTrangThai("Chờ thanh toán");
        hoaDon.setTongTien(0); // Chưa có sản phẩm, tổng tiền = 0 ban đầu

        HoaDon savedHoaDon = hoaDonRepository.save(hoaDon);
        return ResponseEntity.ok(savedHoaDon);
    }

    @PostMapping("/them-hoa-don-chi-tiet")
    public ResponseEntity<HoaDonChiTiet> themHoaDonChiTiet(
            @RequestParam Integer maHD,
            @RequestParam Integer idSP,
            @RequestParam Integer soLuong) {

        Optional<HoaDon> hoaDonOpt = hoaDonRepository.findById(maHD);
        Optional<SanPhamChiTiet> sanPhamOpt = sanPhamChiTietRepository.findById(idSP);

        if (hoaDonOpt.isEmpty() || sanPhamOpt.isEmpty() || soLuong <= 0) {
            return ResponseEntity.badRequest().build();
        }

        HoaDon hoaDon = hoaDonOpt.get();
        SanPhamChiTiet sanPham = sanPhamOpt.get();

        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        hoaDonChiTiet.setHoaDon(hoaDon);
        hoaDonChiTiet.setSanPhamChiTiet(sanPham);
        hoaDonChiTiet.setSoLuong(soLuong);
        hoaDonChiTiet.setDonGia(sanPham.getGiaBan());
        hoaDonChiTiet.setThanhTien(soLuong * sanPham.getGiaBan());

        HoaDonChiTiet savedHoaDonChiTiet = hoaDonChiTietRepository.save(hoaDonChiTiet);

        return ResponseEntity.ok(savedHoaDonChiTiet);
    }

}
