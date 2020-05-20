package com.app.pharmacy.dto;

/**
 *
 * @author Chris Tzelis
 */
public class ProductCategoryDTO {

    private Integer categoryId;

    private String nameCategory;

    public ProductCategoryDTO() {
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

}
