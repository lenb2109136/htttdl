package com.example.htttdl.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "quanhuyen")
public class Huyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QH_ID")
    private Integer id;
    @Column(name = "QH_TEN")
    private String tenHuyen;

    @ManyToOne
    @JoinColumn(name = "T_ID")
    private Tinh tinh;

    public String getTenHuyen() {
        return tenHuyen;
    }

    public void setTenHuyen(String tenHuyen) {
        this.tenHuyen = tenHuyen;
    }

    public Tinh getTinh() {
        return tinh;
    }

    public void setTinh(Tinh tinh) {
        this.tinh = tinh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenTinh() {
        return tenHuyen;
    }

    public void setTenTinh(String tenTinh) {
        this.tenHuyen = tenTinh;
    }
}
