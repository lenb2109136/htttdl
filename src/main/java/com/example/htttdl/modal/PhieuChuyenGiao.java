package com.example.htttdl.modal;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PHIEUCHUYENGIAO")
public class PhieuChuyenGiao {
	@Id
	@Column(name="PCG_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "DNH_ID")
	private DiemNhanHang diemNhanHang;
	@Column(name = "PCG_GHICHU")
	private String ghiChu;
	@Column(name = "PCG_NGAYLAP")
	private LocalDateTime ngayLap;
	@ManyToOne
	@JoinColumn(name = "NV_ID")
	private NHANVIEN nhanvien;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DiemNhanHang getDiemNhanHang() {
		return diemNhanHang;
	}
	public void setDiemNhanHang(DiemNhanHang diemNhanHang) {
		this.diemNhanHang = diemNhanHang;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public LocalDateTime getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(LocalDateTime ngayLap) {
		this.ngayLap = ngayLap;
	}
	public NHANVIEN getNhanvien() {
		return nhanvien;
	}
	public void setNhanvien(NHANVIEN nhanvien) {
		this.nhanvien = nhanvien;
	}
	
	
}
