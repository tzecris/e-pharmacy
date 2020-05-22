package com.app.pharmacy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "customer")
@XmlRootElement
@PrimaryKeyJoinColumn(name = "person_id")
public class Customer extends Person implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer amka;
    private Integer afm;
    @Transient
    private String customerInfo;
    @JoinColumn(name = "vip_id", referencedColumnName = "vip_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Vip vipId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Order> orderList = new ArrayList<>();

    public Customer() {
    }

    public String getCustomerInfo() {
        String result = "Customer info: ";
        if (super.getFirstName() != null && super.getLastName() != null) {
            result += super.getFirstName() + " " + super.getLastName() + ", ";
        }
        if (this.afm != null) {
            result += "VAT Reg.: " + this.afm + ", ";
        }
        result += "Username: " + super.getEmail() + ".";
        return result;
    }

    public void setCustomerInfo(String customerInfo) {
        this.customerInfo = customerInfo;
    }

    public Integer getAmka() {
        return amka;
    }

    public void setAmka(Integer amka) {
        this.amka = amka;
    }

    public Integer getAfm() {
        return afm;
    }

    public void setAfm(Integer afm) {
        this.afm = afm;
    }

    public Vip getVipId() {
        return vipId;
    }

    public void setVipId(Vip vipId) {
        this.vipId = vipId;
    }

    @XmlTransient
    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderCollection(List<Order> orderList) {
        this.orderList = orderList;
    }

}
