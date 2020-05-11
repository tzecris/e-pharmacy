
package com.app.pharmacy.repository;

import com.app.pharmacy.model.OrderVip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderVipRepository extends JpaRepository<OrderVip,Integer>{
    
}
