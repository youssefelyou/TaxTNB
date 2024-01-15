package com.example.tax.service.abs;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IService<T> {

    Page<T> findAll(Pageable page);

    List<T> findAll();

    T save(T t);

    T update(T t);

    Optional<T> findById(Long id);

    void deleteById(Long id);

}

