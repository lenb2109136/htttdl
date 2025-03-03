package com.example.htttdl.controller.Admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.htttdl.DTO.Customer.Admin.DiemNhanHangDTO;
import com.example.htttdl.config.AminBean;
import com.example.htttdl.modal.DiemNhanHang;
import com.example.htttdl.modal.DonHang;
import com.example.htttdl.response.ObjectRespone;
import com.example.htttdl.service.OrderService;

@RestController
@CrossOrigin("*")
public class OrderControllerAdmin {

    @Autowired
    OrderService orderService;

    AminBean a = new AminBean(1);

    @GetMapping("/admin/order/getorder")
    public ResponseEntity<Object> getOrderPhanCong() {
        Map<String, Object> respone = new HashMap<>();
        System.out.println("BUU CUC ID LA: " + a.getBuuCucId());
        List<DonHang> orders = orderService.getAllOrderOfBuuCuc(a.getBuuCucId());
        List<DiemNhanHangDTO> l = orderService.getAllDiemNhanHangHopLy(1);
        respone.put("orders", orders);
        respone.put("diemNhanHang", l.stream()
                .collect(Collectors.groupingBy(DiemNhanHangDTO::getOrderId)));
        return new ResponseEntity<Object>(respone, HttpStatus.OK);
    }
}
