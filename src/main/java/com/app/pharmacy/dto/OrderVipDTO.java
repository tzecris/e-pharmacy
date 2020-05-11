
package com.app.pharmacy.dto;

import com.app.pharmacy.model.Order;


public class OrderVipDTO extends Order{
    private Long weight;

    public OrderVipDTO(Long weight) {
        this.weight = weight;
    }

    public OrderVipDTO() {
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    
    
    
    
}
