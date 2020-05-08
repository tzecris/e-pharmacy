package com.app.pharmacy.repository;

import com.app.pharmacy.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Chris Tzelis
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
