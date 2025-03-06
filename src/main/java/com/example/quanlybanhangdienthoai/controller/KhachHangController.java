package com.example.quanlybanhangdienthoai.controller;


import com.example.quanlybanhangdienthoai.model.KhachHang;
import com.example.quanlybanhangdienthoai.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
