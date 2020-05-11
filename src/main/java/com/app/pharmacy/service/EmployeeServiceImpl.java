package com.app.pharmacy.service;

import com.app.pharmacy.dto.EmployeeDTO;
import com.app.pharmacy.mapper.EmployeeMapper;
import com.app.pharmacy.model.Employee;
import com.app.pharmacy.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chris Tzelis
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeMapper.entityToDTOList(employeeRepository.findAll());
    }

    @Override
    public void save(EmployeeDTO dto) {
        employeeRepository.save(employeeMapper.dtoToEntity(dto));
    }

    @Override
    public EmployeeDTO findById(Integer id) {
        Optional<Employee> result = employeeRepository.findById(id);
        return result.isPresent() ? employeeMapper.entityToDTO(result.get()) : null;
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

}
