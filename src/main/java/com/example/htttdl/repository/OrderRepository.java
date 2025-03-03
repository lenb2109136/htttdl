package com.example.htttdl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.htttdl.DTO.Customer.Admin.DiemNhanHangDTO;
import com.example.htttdl.modal.DonHang;
import com.example.htttdl.modal.TrangThai;

public interface OrderRepository extends JpaRepository<DonHang, Integer>, JpaSpecificationExecutor<DonHang> {
        @Modifying
        @Query("UPDATE DonHang d set d.trangThai=:trangThai where d.id=:orderId and d.khachHang.id =:customerId and (d.trangThai.id=1 or d.trangThai.id=1) ")
        public Integer cancelOrder(@Param("orderId") Integer orderId, @Param("trangThai") TrangThai trangThai,
                        @Param("customerId") Integer customerId);

        @Query("SELECT d FROM DonHang d WHERE d.id = :orderId AND d.khachHang.id = :customerId")
        Optional<DonHang> getOrderInfo(@Param("orderId") Integer orderId, @Param("customerId") Integer customerId);

        @Query("SELECT p.id from DonHang p where p.id=:orderId and p.khachHang.id=:customerId")
        public Optional<Integer> getOrderIsUpdate(@Param("orderId") Integer orderId,
                        @Param("customerId") Integer customerId);

        @Query("select p from DonHang p where p.diemNhanHang.id=:buucucId")
        public List<DonHang> getAllOrderOfBuuCuc(@Param("buucucId") Integer buuCucId);

        // Object orderId,Object diemNhanHangId, Object diChiChiTiet, Object
        // khoangCachDuTinh,
        // Object khoangCachNeuChuyenTiep
        @Query(value = """
                                                 SELECT ttdh.DH_ID as orderId,dhn.DNH_ID as diemNhanHangId, ttdh.DNH_DIACHICHITIET as diaChiChiTiet,
                                                 ttdh.DH_KHOANGCACHDUTINH as khoangCachDuTinh,(ST_Distance_Sphere(
                                                         point(dhn.DNH_KINHDO, dhn.DNH_VIDO),
                                                         point(ttdh.DNH_KINHDO, ttdh.DNH_VIDO)
                                                 ) / 1000 ) AS khoangCachDuTinhNeChuyenTiep

                                                 FROM diemnhanhang dhn
                                                 CROSS JOIN (
                                                 SELECT d.DH_ID,
                                                         d.DH_KHOANGCACHDUTINH,
                                                         d.DH_KINHDO,
                                                         d.DH_VIDO,
                                                         dh.DNH_KINHDO,
                                                         dh.DNH_VIDO,
                                                         dh.DNH_DIACHICHITIET,
                                                         dh.DNH_ID
                                                 FROM donhang d
                                                 JOIN diemnhanhang dh
                                                 ON dh.DNH_ID = d.DNH_ID
                                                 ) ttdh
                                                 WHERE  (ST_Distance_Sphere(
                             point(dhn.DNH_KINHDO, dhn.DNH_VIDO),
                             point(ttdh.DH_KINHDO, ttdh.DH_VIDO)
                        ) / 1000 )<ttdh.DH_KHOANGCACHDUTINH
                        AND  (ST_Distance_Sphere(
                             point(dhn.DNH_KINHDO, dhn.DNH_VIDO),
                             point(ttdh.DNH_KINHDO, ttdh.DNH_VIDO)
                        ) / 1000 )<ttdh.DH_KHOANGCACHDUTINH AND dhn.DNH_ID!=ttdh.DNH_ID
                                         """, nativeQuery = true)
        List<DiemNhanHangDTO> findDiemNhanHangGan(@Param("buuCucId") Integer buuCucId);
}
