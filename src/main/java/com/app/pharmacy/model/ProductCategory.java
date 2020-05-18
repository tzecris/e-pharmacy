package com.app.pharmacy.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christos
 */
@Entity
@Table(name = "product_category")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "ProductCategory.findAll", query = "SELECT p FROM ProductCategory p")
//    , @NamedQuery(name = "ProductCategory.findByCategoryId", query = "SELECT p FROM ProductCategory p WHERE p.categoryId = :categoryId")
//    , @NamedQuery(name = "ProductCategory.findByNameCategory", query = "SELECT p FROM ProductCategory p WHERE p.nameCategory = :nameCategory")})
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "category_id")
    private Integer categoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name_category")
    private String nameCategory;

    public ProductCategory() {
    }

    public ProductCategory(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public ProductCategory(Integer categoryId, String nameCategory) {
        this.categoryId = categoryId;
        this.nameCategory = nameCategory;
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
