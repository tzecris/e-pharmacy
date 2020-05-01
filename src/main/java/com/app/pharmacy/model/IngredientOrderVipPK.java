/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.pharmacy.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Admin
 */
@Embeddable
public class IngredientOrderVipPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ingredient_id")
    private int ingredientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_vip_id")
    private int orderVipId;

    public IngredientOrderVipPK() {
    }

    public IngredientOrderVipPK(int ingredientId, int orderVipId) {
        this.ingredientId = ingredientId;
        this.orderVipId = orderVipId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getOrderVipId() {
        return orderVipId;
    }

    public void setOrderVipId(int orderVipId) {
        this.orderVipId = orderVipId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ingredientId;
        hash += (int) orderVipId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngredientOrderVipPK)) {
            return false;
        }
        IngredientOrderVipPK other = (IngredientOrderVipPK) object;
        if (this.ingredientId != other.ingredientId) {
            return false;
        }
        if (this.orderVipId != other.orderVipId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.pharmacy.model.IngredientOrderVipPK[ ingredientId=" + ingredientId + ", orderVipId=" + orderVipId + " ]";
    }

}
