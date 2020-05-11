package com.app.pharmacy.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "ingedient")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Ingredient.findAll", query = "SELECT i FROM Ingredient i")
//    , @NamedQuery(name = "Ingredient.findByIngredientId", query = "SELECT i FROM Ingredient i WHERE i.ingredientId = :ingredientId")
//    , @NamedQuery(name = "Ingredient.findByName", query = "SELECT i FROM Ingredient i WHERE i.name = :name")
//    , @NamedQuery(name = "Ingredient.findByStock", query = "SELECT i FROM Ingredient i WHERE i.stock = :stock")
//    , @NamedQuery(name = "Ingredient.findByPrice", query = "SELECT i FROM Ingredient i WHERE i.price = :price")})
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
    private Long price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredient")
    private Collection<IngredientOrderVip> ingredientOrderVipCollection;

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
