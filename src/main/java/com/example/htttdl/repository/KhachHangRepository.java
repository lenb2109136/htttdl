package com.example.htttdl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.htttdl.modal.KhachHang;
@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {

}
