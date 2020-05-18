
package com.app.pharmacy.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class ProductCategoryPK implements Serializable{
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "category_id")
    private int categoryId;

    public ProductCategoryPK() {
    }

    public ProductCategoryPK(int productId, int categoryId) {
        this.productId = productId;
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ProductCategoryPK{" + "productId=" + productId + ", categoryId=" + categoryId + '}';
    }
    
    
}
