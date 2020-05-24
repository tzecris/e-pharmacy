package com.app.pharmacy.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "product_order")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "ProductOrder.findAll", query = "SELECT p FROM ProductOrder p")
//    , @NamedQuery(name = "ProductOrder.findByProductId", query = "SELECT p FROM ProductOrder p WHERE p.productOrderPK.productId = :productId")
//    , @NamedQuery(name = "ProductOrder.findByOrderId", query = "SELECT p FROM ProductOrder p WHERE p.productOrderPK.orderId = :orderId")
//    , @NamedQuery(name = "ProductOrder.findByQuantity", query = "SELECT p FROM ProductOrder p WHERE p.quantity = :quantity")})
public class ProductOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductOrderPK productOrderPK;
    @Basic(optional = false)
    @NotNull
    private int quantity;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Order order;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public ProductOrder() {
    }

    public ProductOrderPK getProductOrderPK() {
        return productOrderPK;
    }

    public void setProductOrderPK(ProductOrderPK productOrderPK) {
        this.productOrderPK = productOrderPK;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @PrePersist
    private void prePersiste() {
        if (getProductOrderPK() == null) {
            ProductOrderPK pk = new ProductOrderPK();
            pk.setOrder(order);
            pk.setProduct(product);
            setProductOrderPK(pk);
        }
    }

}
