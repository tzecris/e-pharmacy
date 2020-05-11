package com.app.pharmacy.repository;

import com.app.pharmacy.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Chris Tzelis
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
