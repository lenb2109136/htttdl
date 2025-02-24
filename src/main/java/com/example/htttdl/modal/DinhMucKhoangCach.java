package com.example.htttdl.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dinhmucKhoangCach")
public class DinhMucKhoangCach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DMKC_ID")
    private Integer id;
    @Column(name = "DMKC_GIOIHANDUOI")
    private Float gioiHanDuoi;
    @Column(name = "DMKC_GIOIHANDUOI")
    private Float gioiHanTren;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getGioiHanDuoi() {
        return gioiHanDuoi;
    }

    public void setGioiHanDuoi(Float gioiHanDuoi) {
        this.gioiHanDuoi = gioiHanDuoi;
    }

    public Float getGioiHanTren() {
        return gioiHanTren;
    }

    public void setGioiHanTren(Float gioiHanTren) {
        this.gioiHanTren = gioiHanTren;
    }
}
