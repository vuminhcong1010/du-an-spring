package com.example.quanlybanhangdienthoai.repository;

import com.example.quanlybanhangdienthoai.model.Hang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HangRepository extends JpaRepository<Hang,Integer> {
}
