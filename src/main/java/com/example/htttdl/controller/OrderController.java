package com.example.htttdl.controller;

import java.time.LocalDateTime;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.htttdl.modal.DonHang;
import com.example.htttdl.modal.DonHangBuuCuc;
import com.example.htttdl.modal.DonHangLayNHan;
import com.example.htttdl.modal.KhachHang;
import com.example.htttdl.modal.ThoiDiemTrangThai;
import com.example.htttdl.modal.TrangThai;
import com.example.htttdl.repository.DonHangBuuCucRepository;
import com.example.htttdl.repository.DonHangLayNhanRepository;
import com.example.htttdl.response.ObjectRespone;
import com.example.htttdl.service.OrderService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
public class OrderController {
    @Autowired
    DonHangBuuCucRepository dh;

    @Autowired
    DonHangLayNhanRepository dhLayNhan;

    @Autowired
    OrderService orderService;
    KhachHang khachHang = new KhachHang(1);

    @GetMapping("/test")
    public ResponseEntity<Object> getAllOrder(
            @RequestParam(name = "tenNguoiNhan", required = false) String tenNguoiNhan,
            @RequestParam(name = "trangThaiId", defaultValue = "1") Integer trangThaiId,
            @RequestParam(name = "id", required = false) Integer id,
            @RequestParam(name = "sortBy", required = false) String sortBy,
            @RequestParam(name = "page", defaultValue = "0") Integer page) {
        return new ResponseEntity<>(
                new ObjectRespone("success",
                        orderService.getAll(id, trangThaiId, tenNguoiNhan, khachHang, sortBy, page,
                                1000)),
                HttpStatus.ACCEPTED);
    }

    @GetMapping("/getbuucucnear")
    public ResponseEntity<Object> getNear(@RequestParam(name = "lat") Double lat,
            @RequestParam(name = "longti") Double longti) {
        return new ResponseEntity<>(orderService.getDiemNhanHangNear(lat, longti), HttpStatus.ACCEPTED);
    }

    @PostMapping("/customer/order/add/buucuc")
    public ResponseEntity<Object> addOrder(@RequestBody @Valid DonHangBuuCuc order) {
        order.setKhachHang(new KhachHang(1));
        orderService.getBaseAddressBuuCuc(order);
        orderService.checkHinhThucVanChuyen(order);
        orderService.caculateFee(order);
        orderService.saveOrder(order, 3);
        return new ResponseEntity<>(223332, HttpStatus.OK);
    }

    @PostMapping("/customer/order/add/laynhan")
    public ResponseEntity<Object> addOrder(@RequestBody DonHangLayNHan order) {
        order.setKhachHang(new KhachHang(1));
        orderService.getBaseAddressLayNhan(order);
        orderService.checkHinhThucVanChuyen(order);
        orderService.caculateFee(order);
        orderService.saveOrder(order, 1);
        return new ResponseEntity<>(new ObjectRespone("Thêm đơn hàng thành công", null), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/customer/order/cancel")
    public ResponseEntity<Object> cancelOrder(@RequestParam(name = "orderId", defaultValue = "-1") Integer orderId) {
        TrangThai trangThai = new TrangThai(9);
        if (orderService.cancelOrder(orderId, trangThai, khachHang.getId())) {
            ThoiDiemTrangThai thoiDiemTrangThai = new ThoiDiemTrangThai();
            thoiDiemTrangThai.setNhanvien(null);
            thoiDiemTrangThai.setThoiDiem(LocalDateTime.now());
            thoiDiemTrangThai.setDonHang(new DonHang(orderId));
            thoiDiemTrangThai.setTrangThai(trangThai);
            orderService.saveOrderThoiDiemTrangThai(thoiDiemTrangThai);
            return new ResponseEntity<>(new ObjectRespone("oHuy don haang thanh cong", null), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ObjectRespone("Don hang ko hopw le", null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/customer/order/getbyid")
    public ResponseEntity<Object> getOrderInfo(@RequestParam(name = "orderId", defaultValue = "-1") Integer orderId) {
        DonHang donHnag = orderService.getInfo(orderId, khachHang.getId());
        if (donHnag != null) {
            return new ResponseEntity<>(new ObjectRespone("success", donHnag), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ObjectRespone("success", donHnag), HttpStatus.OK);
    }

    @PutMapping("/customer/order/update/buucuc")
    public ResponseEntity<Object> updateOrder(@RequestBody @Valid DonHangBuuCuc order) {
        Boolean a = orderService.checkOrderCanUpdate(order.getId(), khachHang.getId());
        if (a) {
            order.setKhachHang(new KhachHang(1));
            orderService.getBaseAddressBuuCuc(order);
            orderService.checkHinhThucVanChuyen(order);
            orderService.caculateFee(order);
            orderService.saveOrder(order, 3);
            return new ResponseEntity<>(new ObjectRespone("Cập nhật đơn hàng thành công", null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ObjectRespone("Đơn hàng không hợp lệ", null), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/customer/order/update/laynhan")
    public ResponseEntity<Object> updateOrder(@RequestBody @Valid DonHangLayNHan order) {
        Boolean a = orderService.checkOrderCanUpdate(order.getId(), khachHang.getId());
        if (a) {
            order.setKhachHang(new KhachHang(1));
            orderService.getBaseAddressLayNhan(order);
            orderService.checkHinhThucVanChuyen(order);
            orderService.caculateFee(order);
            orderService.saveOrder(order, 1);
            return new ResponseEntity<>(new ObjectRespone("Cập nhật đơn hàng thành công", null), HttpStatus.OK);

        }
        return new ResponseEntity<>(new ObjectRespone("Đơn hàng không hợp lệ", null), HttpStatus.BAD_REQUEST);
    }

}
