package com.app.pharmacy.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "product")
@XmlRootElement
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_id")
    private Integer productId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String name;
    @Size(max = 45)
    private String description;
    private Integer type;
    private boolean prescripted;
    private Integer stock;
    private Double price;
    @Transient
    private Double finalPrice;
    private byte[] image;
    private Double discount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductOrder> productOrderList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Review> ratingsPerCustomerList;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "category_per_product",
            joinColumns = {
                @JoinColumn(name = "product_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "category_id")})
    private Collection<ProductCategory> categories;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Product(Integer productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public boolean getPrescripted() {
        return prescripted;
    }

    public void setPrescripted(boolean prescripted) {
        this.prescripted = prescripted;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<ProductOrder> getProductOrderList() {
        return productOrderList;
    }

    public void setProductOrderList(List<ProductOrder> productOrderList) {
        this.productOrderList = productOrderList;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getFinalPrice() {
        if (this.discount == null) {
            return this.price;
        }
        //Round double with two decimals
        return Math.round((this.price - ((this.discount / 100) * this.price)) * 100.0) / 100.0;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public List<Review> getRatingsPerCustomerCollection() {
        return ratingsPerCustomerList;
    }

    public void setRatingsPerCustomerCollection(List<Review> ratingsPerCustomerCollection) {
        this.ratingsPerCustomerList = ratingsPerCustomerCollection;
    }

    public List<Review> getRatingsPerCustomerList() {
        return ratingsPerCustomerList;
    }

    public void setRatingsPerCustomerList(List<Review> ratingsPerCustomerList) {
        this.ratingsPerCustomerList = ratingsPerCustomerList;
    }

    public Collection<ProductCategory> getCategories() {
        return categories;
    }

    public void setCategories(Collection<ProductCategory> categories) {
        this.categories = categories;
    }

}
