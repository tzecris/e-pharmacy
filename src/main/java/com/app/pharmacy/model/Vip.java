/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.pharmacy.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "vip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vip.findAll", query = "SELECT v FROM Vip v")
    , @NamedQuery(name = "Vip.findByVipId", query = "SELECT v FROM Vip v WHERE v.vipId = :vipId")})
public class Vip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vip_id")
    private Integer vipId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "permission_img")
    private byte[] permissionImg;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "id_copy")
    private byte[] idCopy;
    @OneToMany(mappedBy = "vipId")
    private Collection<Customer> customerCollection;

    public Vip() {
    }

    public Vip(Integer vipId) {
        this.vipId = vipId;
    }

    public Vip(Integer vipId, byte[] permissionImg, byte[] idCopy) {
        this.vipId = vipId;
        this.permissionImg = permissionImg;
        this.idCopy = idCopy;
    }

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public byte[] getPermissionImg() {
        return permissionImg;
    }

    public void setPermissionImg(byte[] permissionImg) {
        this.permissionImg = permissionImg;
    }

    public byte[] getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(byte[] idCopy) {
        this.idCopy = idCopy;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vipId != null ? vipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vip)) {
            return false;
        }
        Vip other = (Vip) object;
        if ((this.vipId == null && other.vipId != null) || (this.vipId != null && !this.vipId.equals(other.vipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.pharmacy.model.Vip[ vipId=" + vipId + " ]";
    }

}
