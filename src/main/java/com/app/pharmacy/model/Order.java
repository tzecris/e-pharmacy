package com.app.pharmacy.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "my_order")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")
//    , @NamedQuery(name = "Order.findByOrderId", query = "SELECT o FROM Order o WHERE o.orderId = :orderId")
//    , @NamedQuery(name = "Order.findByDate", query = "SELECT o FROM Order o WHERE o.date = :date")
//    , @NamedQuery(name = "Order.findByPrescriptionZipcode", query = "SELECT o FROM Order o WHERE o.prescriptionZipcode = :prescriptionZipcode")
//    , @NamedQuery(name = "Order.findByStatus", query = "SELECT o FROM Order o WHERE o.status = :status")
//    , @NamedQuery(name = "Order.findByPayment", query = "SELECT o FROM Order o WHERE o.payment = :payment")})
@Inheritance(strategy = InheritanceType.JOINED)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_id")
    private Integer orderId;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "prescription_zipcode")
    private Integer prescriptionZipcode;
    private Integer status;
    @Size(max = 45)
    private String payment;
    @Lob
    private byte[] prescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Collection<ProductOrder> productOrderCollection;
    @JoinColumn(name = "customer_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Customer customer;

    public Order() {
    }

    public Order(Integer orderId) {
        this.orderId = orderId;
    }

    public Order(Integer orderId, Date date) {
        this.orderId = orderId;
        this.date = date;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPrescriptionZipcode() {
        return prescriptionZipcode;
    }

    public void setPrescriptionZipcode(Integer prescriptionZipcode) {
        this.prescriptionZipcode = prescriptionZipcode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public byte[] getPrescription() {
        return prescription;
    }

    public void setPrescription(byte[] prescription) {
        this.prescription = prescription;
    }

    @XmlTransient
    public Collection<ProductOrder> getProductOrderCollection() {
        return productOrderCollection;
    }

    public void setProductOrderCollection(Collection<ProductOrder> productOrderCollection) {
        this.productOrderCollection = productOrderCollection;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "com.app.pharmacy.model.Order[ orderId=" + orderId + " ]";
    }

}
