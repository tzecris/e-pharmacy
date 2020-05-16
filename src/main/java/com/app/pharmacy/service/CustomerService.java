package com.app.pharmacy.service;

import com.app.pharmacy.dto.CustomerDTO;
import java.util.List;

public interface CustomerService extends GenericService<CustomerDTO> {

    public boolean uniqueEmail(String email);

    public List<CustomerDTO> findAllPagination(int page, int size, String sort);

}
