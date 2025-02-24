package com.example.htttdl.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DONHANG")
@Inheritance
(strategy = InheritanceType.JOINED)
public class DonHang {
	@Id
	@Column(name="DH_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "DNH_ID")
	private DiemNhanHang diemNhanHang;
	@ManyToOne
	@JoinColumn(name = "LH_ID")
	private LoaiHang loaiHang;
	
	@ManyToOne
	@JoinColumn(name = "PCG_ID")
	private PhieuChuyenGiao phieuChuyenGiao;
	@ManyToOne
	@JoinColumn(name = "PX_ID")
	private Xa xa;
	@ManyToOne
	@JoinColumn(name = "KH_ID")
	private KhachHang khachHang;
	@ManyToOne
	@JoinColumn(name = "HTVC_ID")
	private HinhThucVanChuyen hinhThucVanChuyen;
	@Column(name = "DH_TENNGUOINHAN")
	private String tenNguoiNhan;
	@Column(name = "DH_DIENTHOAI")
	private String SDTnguoiNhan;
	@Column(name = "DH_DIACHICHITIET")
	private String diaChiChiTiet;
	@Column(name = "DH_TRONGLUONG")
	private float trongLuong;
	@Column(name = "DH_KHOANGCACHDUTINH")
	private float KhoangCachDuTinh;
	@Column(name = "DH_KINHDO")
	private float kinhDo;
	@Column(name = "DH_VIDO")
	private float viDo;
	@Column(name = "DH_LAYTIENTAICHO")
	private boolean layTienTaiCho;
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
	public LoaiHang getLoaiHang() {
		return loaiHang;
	}
	public void setLoaiHang(LoaiHang loaiHang) {
		this.loaiHang = loaiHang;
	}
	public PhieuChuyenGiao getPhieuChuyenGiao() {
		return phieuChuyenGiao;
	}
	public void setPhieuChuyenGiao(PhieuChuyenGiao phieuChuyenGiao) {
		this.phieuChuyenGiao = phieuChuyenGiao;
	}
	public Xa getXa() {
		return xa;
	}
	public void setXa(Xa xa) {
		this.xa = xa;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public HinhThucVanChuyen getHinhThucVanChuyen() {
		return hinhThucVanChuyen;
	}
	public void setHinhThucVanChuyen(HinhThucVanChuyen hinhThucVanChuyen) {
		this.hinhThucVanChuyen = hinhThucVanChuyen;
	}
	public String getTenNguoiNhan() {
		return tenNguoiNhan;
	}
	public void setTenNguoiNhan(String tenNguoiNhan) {
		this.tenNguoiNhan = tenNguoiNhan;
	}
	public String getSDTnguoiNhan() {
		return SDTnguoiNhan;
	}
	public void setSDTnguoiNhan(String sDTnguoiNhan) {
		SDTnguoiNhan = sDTnguoiNhan;
	}
	public String getDiaChiChiTiet() {
		return diaChiChiTiet;
	}
	public void setDiaChiChiTiet(String diaChiChiTiet) {
		this.diaChiChiTiet = diaChiChiTiet;
	}
	public float getTrongLuong() {
		return trongLuong;
	}
	public void setTrongLuong(float trongLuong) {
		this.trongLuong = trongLuong;
	}
	public float getKhoangCachDuTinh() {
		return KhoangCachDuTinh;
	}
	public void setKhoangCachDuTinh(float khoangCachDuTinh) {
		KhoangCachDuTinh = khoangCachDuTinh;
	}
	public float getKinhDo() {
		return kinhDo;
	}
	public void setKinhDo(float kinhDo) {
		this.kinhDo = kinhDo;
	}
	public float getViDo() {
		return viDo;
	}
	public void setViDo(float viDo) {
		this.viDo = viDo;
	}
	public boolean isLayTienTaiCho() {
		return layTienTaiCho;
	}
	public void setLayTienTaiCho(boolean layTienTaiCho) {
		this.layTienTaiCho = layTienTaiCho;
	}
	
	
}
