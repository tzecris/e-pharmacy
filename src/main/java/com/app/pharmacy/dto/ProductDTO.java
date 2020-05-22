package com.app.pharmacy.dto;

import java.util.List;
import java.util.Locale.Category;
import javax.validation.constraints.NotNull;

public class ProductDTO {

    private Integer productId;

    @NotNull
    private String name;

    @NotNull
    private String description;

    private List<Category> productCategoryList;

    private boolean prescripted;

    private String image;

    private Double discount;

    private Double finalPrice;

    @NotNull
    private Integer stock;

    @NotNull
    private Double price;

    private Integer quantity;

    public Integer getProductId() {
        return productId;
    }

    public ProductDTO() {
    }

    public List<Category> getProductCategoryList() {
        return productCategoryList;
    }

    public void setProductCategoryList(List<Category> productCategoryList) {
        this.productCategoryList = productCategoryList;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
