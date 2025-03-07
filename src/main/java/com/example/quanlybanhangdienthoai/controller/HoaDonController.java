package com.example.quanlybanhangdienthoai.controller;


import com.example.quanlybanhangdienthoai.model.HoaDon;
import com.example.quanlybanhangdienthoai.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hoadon")
@CrossOrigin(origins = "http://localhost:8080")
public class HoaDonController {

    @Autowired
    HoaDonRepository hdre;

    @GetMapping("/hienthi")
    public List<HoaDon> getHienThi(){
        return hdre.findAll();
    }
}
