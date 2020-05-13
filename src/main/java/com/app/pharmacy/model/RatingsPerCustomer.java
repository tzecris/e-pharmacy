
package com.app.pharmacy.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ratings_per_customer")
@XmlRootElement
public class RatingsPerCustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RatingsPerCustomerPK ratingsPerCustomerPK;
    @Column(name = "rating")
    private Integer rating;
    @Size(max = 100)
    @Column(name = "review", length = 100)
    private String review;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customer customer;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public RatingsPerCustomer() {
    }

    public RatingsPerCustomer(RatingsPerCustomerPK ratingsPerCustomerPK) {
        this.ratingsPerCustomerPK = ratingsPerCustomerPK;
    }

    public RatingsPerCustomer(int customerId, int productId) {
        this.ratingsPerCustomerPK = new RatingsPerCustomerPK(customerId, productId);
    }

    public RatingsPerCustomerPK getRatingsPerCustomerPK() {
        return ratingsPerCustomerPK;
    }

    public void setRatingsPerCustomerPK(RatingsPerCustomerPK ratingsPerCustomerPK) {
        this.ratingsPerCustomerPK = ratingsPerCustomerPK;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ratingsPerCustomerPK != null ? ratingsPerCustomerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RatingsPerCustomer)) {
            return false;
        }
        RatingsPerCustomer other = (RatingsPerCustomer) object;
        if ((this.ratingsPerCustomerPK == null && other.ratingsPerCustomerPK != null) || (this.ratingsPerCustomerPK != null && !this.ratingsPerCustomerPK.equals(other.ratingsPerCustomerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.pharmacy.service.newpackage.RatingsPerCustomer[ ratingsPerCustomerPK=" + ratingsPerCustomerPK + " ]";
    }
    
}
