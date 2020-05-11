
package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.OrderVipDTO;
import com.app.pharmacy.model.OrderVip;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses = {OrderMapper.class,CustomerMapper.class}, componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderVipMapper extends GenericMapper<OrderVipDTO, OrderVip>{
    
}
