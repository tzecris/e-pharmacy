
package com.app.pharmacy.service;

import com.app.pharmacy.dto.CustomerVipDTO;

public interface CustomerVipService extends GenericService<CustomerVipDTO> {

    public boolean uniqueEmail(String email);

    
}
