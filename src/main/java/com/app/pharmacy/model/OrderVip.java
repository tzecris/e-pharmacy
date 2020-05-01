package com.app.pharmacy.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "order_vip")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "OrderVip.findAll", query = "SELECT o FROM OrderVip o")
//    , @NamedQuery(name = "OrderVip.findByOrderVipId", query = "SELECT o FROM OrderVip o WHERE o.orderVipId = :orderVipId")
//    , @NamedQuery(name = "OrderVip.findByWeight", query = "SELECT o FROM OrderVip o WHERE o.weight = :weight")})
@PrimaryKeyJoinColumn(name = "order_id")
public class OrderVip extends Order implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long weight;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderVip")
    private Collection<IngredientOrderVip> ingredientOrderVipCollection;

    public OrderVip() {
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    @XmlTransient
    public Collection<IngredientOrderVip> getIngredientOrderVipCollection() {
        return ingredientOrderVipCollection;
    }

    public void setIngredientOrderVipCollection(Collection<IngredientOrderVip> ingredientOrderVipCollection) {
        this.ingredientOrderVipCollection = ingredientOrderVipCollection;
    }

    @Override
    public String toString() {
        return "com.app.pharmacy.model.OrderVip[ orderVipId=" + super.getOrderId() + " ]";
    }

}
