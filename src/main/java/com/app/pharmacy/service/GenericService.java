package com.app.pharmacy.service;

import java.util.List;

public interface GenericService<T> {

    List<T> findAll();

    void save(T dto);

    T findById(Integer id);

    void deleteById(Integer id);

}
