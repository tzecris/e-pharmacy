
package com.app.pharmacy.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ProductDTO {
    
    @NotNull
    private Integer productId;
    
    @NotNull
    @Size(min = 1, max = 45)
    private String name;
    
    @NotNull
    @Size(min = 1, max = 45)
    private String description;
    
    @NotNull
    private Integer type;
    
    @NotNull
    private Short prescripted;
    
    @NotNull
    private Integer stock;
    
    @NotNull
    private Double price;

    public Integer getProductId() {
        return productId;
    }

    public ProductDTO() {
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

    public Short getPrescripted() {
        return prescripted;
    }

    public void setPrescripted(Short prescripted) {
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
    
    
    
    
    
}
