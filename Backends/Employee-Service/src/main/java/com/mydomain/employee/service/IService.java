package com.mydomain.employee.service;

import java.util.Collection;

/**
 * @author M.Soltani
 */
public interface IService<T>{
    Collection<T> findAll();
    T save(T t);
    T update(Long id,T t);

    String deleteById(Long id);
}
