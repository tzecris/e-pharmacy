package com.app.pharmacy.mapper;

import java.util.List;

/**
 *
 * @author Chris Tzelis
 */
public interface GenericMapper<T, R> {

    T entityToDTO(R entity);

    R dtoToEntity(T dto);

    List<T> entityToDTOList(List<R> entityList);

    List<R> dtoToEntityList(List<T> dtoList);
}
