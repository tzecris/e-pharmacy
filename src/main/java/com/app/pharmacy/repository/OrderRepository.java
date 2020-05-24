package com.app.pharmacy.repository;

import com.app.pharmacy.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Chris Tzelis
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("select o from Order o where o.customer.email = :email")
    List<Order> findByCustomerEmail(@Param("email") String email);

}
