package com.example.quanlybanhangdienthoai.controller;

import com.example.quanlybanhangdienthoai.model.NhanVien;
import com.example.quanlybanhangdienthoai.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
