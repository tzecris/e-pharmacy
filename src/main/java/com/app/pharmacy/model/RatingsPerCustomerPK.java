
package com.app.pharmacy.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class RatingsPerCustomerPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "customer_id", nullable = false)
    private int customerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id", nullable = false)
    private int productId;

    public RatingsPerCustomerPK() {
    }

    public RatingsPerCustomerPK(int customerId, int productId) {
        this.customerId = customerId;
        this.productId = productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) customerId;
        hash += (int) productId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RatingsPerCustomerPK)) {
            return false;
        }
        RatingsPerCustomerPK other = (RatingsPerCustomerPK) object;
        if (this.customerId != other.customerId) {
            return false;
        }
        if (this.productId != other.productId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.pharmacy.service.newpackage.RatingsPerCustomerPK[ customerId=" + customerId + ", productId=" + productId + " ]";
    }
    
}


