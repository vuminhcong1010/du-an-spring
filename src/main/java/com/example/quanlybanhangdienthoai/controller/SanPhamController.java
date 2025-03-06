package com.example.quanlybanhangdienthoai.controller;


import com.example.quanlybanhangdienthoai.model.SanPham;
import com.example.quanlybanhangdienthoai.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sanpham")
@CrossOrigin(origins = "http://localhost:8080")
public class SanPhamController {

    @Autowired
    SanPhamRepository spre;

    @GetMapping("/hienthi")
    public List<SanPham> getHienThi(){
        return spre.findAll();
    }

}
