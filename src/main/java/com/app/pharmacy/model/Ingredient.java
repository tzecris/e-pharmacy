package com.app.pharmacy.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ingredient")
@XmlRootElement
public class Ingredient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ingredient_id")
    private Integer ingredientId;
    @Size(max = 45)
    private String name;
    private Integer stock;
    private Double price;
    @Transient
    private Double finalPrice;
    private String image;
    private Double discount;
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredient", fetch = FetchType.LAZY)
    private List<IngredientOrderVip> ingredientOrderVipList;

    public Ingredient() {
    }

    public Ingredient(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

}
