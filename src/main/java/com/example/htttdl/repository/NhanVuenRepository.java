package com.example.htttdl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.htttdl.modal.NHANVIEN;
@Repository
public interface NhanVuenRepository extends JpaRepository<NHANVIEN, Integer>{

}
