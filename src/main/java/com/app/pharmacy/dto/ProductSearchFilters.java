package com.app.pharmacy.dto;

import java.util.List;

/**
 *
 * @author Chris Tzelis
 */
public class ProductSearchFilters {

    private List<Integer> categoryList;
    private String productName;
    private boolean stock;
    private double minPrice;
    private double maxPrice;
    private boolean prescripted;
    private boolean discount;

    public ProductSearchFilters() {
    }

    public List<Integer> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Integer> categoryList) {
        this.categoryList = categoryList;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public boolean isPrescripted() {
        return prescripted;
    }

    public void setPrescripted(boolean prescripted) {
        this.prescripted = prescripted;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }


}
