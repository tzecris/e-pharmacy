package com.app.pharmacy.dto;


public class IngredientDTO {
  
    private String name;
    private Integer stock;
    private Long price;

    public IngredientDTO(String name, Integer stock, Long price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public IngredientDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    
    
}
