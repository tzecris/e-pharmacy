
package com.app.pharmacy.repository;

import com.app.pharmacy.model.Vip;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerVipRepository extends  PagingAndSortingRepository<Vip, Integer> {


    public List<Vip> findAll();

    public Page<Vip> findAll(Pageable pageable);
    
}
