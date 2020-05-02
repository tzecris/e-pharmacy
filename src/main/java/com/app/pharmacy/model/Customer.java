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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "customer")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
//    , @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId")
//    , @NamedQuery(name = "Customer.findByAmka", query = "SELECT c FROM Customer c WHERE c.amka = :amka")
//    , @NamedQuery(name = "Customer.findByAfm", query = "SELECT c FROM Customer c WHERE c.afm = :afm")})
@PrimaryKeyJoinColumn(name = "person_id")
public class Customer extends Person implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer amka;
    private Integer afm;
    @JoinColumn(name = "vip_id", referencedColumnName = "vip_id")
    @ManyToOne
    private Vip vipId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Order> orderList = new ArrayList<>();

    public Customer() {
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

    @Override
    public String toString() {
        return "com.app.pharmacy.model.Customer[ customerId=" + super.getPersonId() + " ]";
    }

}
