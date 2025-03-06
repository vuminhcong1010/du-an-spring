package com.example.quanlybanhangdienthoai.repository;

import com.example.quanlybanhangdienthoai.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {

}
