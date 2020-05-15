
package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.CustomerVipDTO;
import com.app.pharmacy.model.Vip;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(uses={PersonMapper.class, AddressMapper.class, CustomerMapper.class}, componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CustomerVipMapper extends GenericMapper<CustomerVipDTO, Vip>{
    
}
