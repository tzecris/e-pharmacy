
package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.OrderVipDTO;
import com.app.pharmacy.model.OrderVip;
import com.app.pharmacy.model.Vip;
import com.app.pharmacy.repository.CustomerVipRepository;
import java.util.List;
import java.util.Optional;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(uses = {CustomerVipMapper.class}, componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class OrderVipMapper {
    
    @Autowired
    CustomerVipRepository customerVipRepository;

    @Mapping(source = "vip.personId", target = "customerId")
    public abstract OrderVipDTO entityToDTO(OrderVip entity);

    @Mapping(source = "customerId", target = "vipId")
    public abstract OrderVip dtoToEntity(OrderVipDTO dto);

    public abstract List<OrderVipDTO> entityToDTOList(List<OrderVip> list);

    public abstract List<OrderVip> dtoToEntityList(List<OrderVipDTO> dtoList);

    public Vip getCustomer(Integer vipId) {
        Optional<Vip> result = customerVipRepository.findById(vipId);
        return result.isPresent() ? result.get() : null;
    }
    
}
