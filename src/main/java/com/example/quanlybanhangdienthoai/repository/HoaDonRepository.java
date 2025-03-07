package com.example.quanlybanhangdienthoai.repository;

import com.example.quanlybanhangdienthoai.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
}
