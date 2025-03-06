package com.example.quanlybanhangdienthoai.repository;

import com.example.quanlybanhangdienthoai.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
}
