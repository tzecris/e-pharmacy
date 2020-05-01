/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(catalog = "pharmacy_app", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingredient.findAll", query = "SELECT i FROM Ingredient i")
    , @NamedQuery(name = "Ingredient.findByIngredientId", query = "SELECT i FROM Ingredient i WHERE i.ingredientId = :ingredientId")
    , @NamedQuery(name = "Ingredient.findByName", query = "SELECT i FROM Ingredient i WHERE i.name = :name")
    , @NamedQuery(name = "Ingredient.findByStock", query = "SELECT i FROM Ingredient i WHERE i.stock = :stock")
    , @NamedQuery(name = "Ingredient.findByPrice", query = "SELECT i FROM Ingredient i WHERE i.price = :price")})
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

    @XmlTransient
    public Collection<IngredientOrderVip> getIngredientOrderVipCollection() {
        return ingredientOrderVipCollection;
    }

    public void setIngredientOrderVipCollection(Collection<IngredientOrderVip> ingredientOrderVipCollection) {
        this.ingredientOrderVipCollection = ingredientOrderVipCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingredientId != null ? ingredientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredient)) {
            return false;
        }
        Ingredient other = (Ingredient) object;
        if ((this.ingredientId == null && other.ingredientId != null) || (this.ingredientId != null && !this.ingredientId.equals(other.ingredientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.pharmacy.model.Ingredient[ ingredientId=" + ingredientId + " ]";
    }

}
