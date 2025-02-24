package com.example.htttdl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.htttdl.modal.DonGia;
@Repository
public interface DonGiaRepository extends JpaRepository<DonGia, Integer> {

}
