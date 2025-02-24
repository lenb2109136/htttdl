package com.example.htttdl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.htttdl.modal.PhieuChuyenGiao;
@Repository
public interface PhieuChuyenGiaoRepository extends JpaRepository<PhieuChuyenGiao, Integer>{

}
