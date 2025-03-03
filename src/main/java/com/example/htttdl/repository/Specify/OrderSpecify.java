package com.example.htttdl.repository.Specify;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.example.htttdl.modal.DonHang;
import com.example.htttdl.modal.KhachHang;
import com.example.htttdl.modal.NHANVIEN;
import com.example.htttdl.modal.TrangThai;

public class OrderSpecify {
    public static Specification<DonHang> filterByCriteria(Integer id, TrangThai trangThai, String tenNguoiNhan,
            KhachHang khachHang) {
        return (root, query, criteriaBuilder) -> {
            Specification<DonHang> spec = Specification.where(null);
            spec = spec.and(
                    (root1, query1, criteriaBuilder1) -> criteriaBuilder1.equal(root1.get("khachHang"), khachHang));
            if (id != null) {
                spec = spec.and((root1, query1, criteriaBuilder1) -> criteriaBuilder1.equal(root1.get("id"), id));
            }
            if (trangThai != null) {
                spec = spec.and(
                        (root1, query1, criteriaBuilder1) -> criteriaBuilder1.equal(root1.get("trangThai"), trangThai));
            }
            if (StringUtils.hasText(tenNguoiNhan)) {
                spec = spec.and((root1, query1, criteriaBuilder1) -> criteriaBuilder1.like(root1.get("tenNguoiNhan"),
                        "%" + tenNguoiNhan + "%"));
            }
            return spec.toPredicate(root, query, criteriaBuilder);
        };
    }
}
