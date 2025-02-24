package com.example.htttdl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.htttdl.service.HinhThucVanChuyenService;

@SpringBootApplication
public class HtttdlApplication {
	@Autowired
	private HinhThucVanChuyenService hinhThucVanChuyenService;
	public static void main(String[] args) {
		SpringApplication.run(HtttdlApplication.class, args);
	}

}
