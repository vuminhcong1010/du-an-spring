package com.example.quanlybanhangdienthoai.repository;

import com.example.quanlybanhangdienthoai.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
}
