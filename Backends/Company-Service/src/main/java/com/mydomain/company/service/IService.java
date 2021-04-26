package com.mydomain.company.service;

import java.util.Collection;

public interface IService<T> {
    Collection<T> findAll();

    T findById(Long id);

    T save(T t);
    T update(Long id,T t);

    String deleteById(Long id);
}
