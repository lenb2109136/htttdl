package com.example.htttdl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.htttdl.modal.DonHangLayNHan;
@Repository
public interface DonHangLayNhanRepository extends JpaRepository<DonHangLayNHan, Integer>{

}
