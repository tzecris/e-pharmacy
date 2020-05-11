package com.app.pharmacy.mapper;

import com.app.pharmacy.dto.EmployeeDTO;
import com.app.pharmacy.model.Employee;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

/**
 *
 * @author Chris Tzelis
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EmployeeMapper extends GenericMapper<EmployeeDTO, Employee> {

}
