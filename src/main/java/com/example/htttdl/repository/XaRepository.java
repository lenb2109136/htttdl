package com.example.htttdl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.htttdl.modal.Xa;
@Repository
public interface XaRepository extends JpaRepository<Xa, Integer>{

}
