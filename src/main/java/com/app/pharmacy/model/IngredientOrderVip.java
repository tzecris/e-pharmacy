package com.app.pharmacy.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ingredient_order_vip")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "IngredientOrderVip.findAll", query = "SELECT i FROM IngredientOrderVip i")
//    , @NamedQuery(name = "IngredientOrderVip.findByIngredientId", query = "SELECT i FROM IngredientOrderVip i WHERE i.ingredientOrderVipPK.ingredientId = :ingredientId")
//    , @NamedQuery(name = "IngredientOrderVip.findByOrderVipId", query = "SELECT i FROM IngredientOrderVip i WHERE i.ingredientOrderVipPK.orderVipId = :orderVipId")
//    , @NamedQuery(name = "IngredientOrderVip.findByWeight", query = "SELECT i FROM IngredientOrderVip i WHERE i.weight = :weight")})
public class IngredientOrderVip implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IngredientOrderVipPK ingredientOrderVipPK;
    private Long weight;
    @JoinColumn(name = "ingredient_id", referencedColumnName = "ingredient_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ingredient ingredient;
    @JoinColumn(name = "order_vip_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OrderVip orderVip;

    public IngredientOrderVip() {
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public OrderVip getOrderVip() {
        return orderVip;
    }

    public void setOrderVip(OrderVip orderVip) {
        this.orderVip = orderVip;
    }

    @Override
    public String toString() {
        return "com.app.pharmacy.model.IngredientOrderVip[ ingredientOrderVipPK=" + ingredientOrderVipPK + " ]";
    }

}
