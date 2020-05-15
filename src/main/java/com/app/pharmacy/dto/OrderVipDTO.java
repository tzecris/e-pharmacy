
package com.app.pharmacy.dto;

import com.app.pharmacy.dto.OrderDTO;


public class OrderVipDTO extends OrderDTO{
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
