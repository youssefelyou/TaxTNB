package com.example.tax.service;

import com.example.tax.bean.Redevable;
import com.example.tax.repository.RedevableDao;
import com.example.tax.service.abs.IService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RedevableService implements IService<Redevable> {

    @Autowired
    private RedevableDao redevableDao;


    @Override
    public Page<Redevable> findAll(Pageable page) {
        return redevableDao.findAll(page);
    }

    @Override
    public List<Redevable> findAll() {
        return redevableDao.findAll();
    }

    public Redevable save(Redevable redevable) {
        return redevableDao.save(redevable);
    }

    @Override
    public Redevable update(Redevable redevable) {
        return null;
    }

    public Optional<Redevable> findById(Long id) {
        return redevableDao.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        redevableDao.deleteById(id);
    }

    public Redevable findByCin(String Cin) {
        return redevableDao.findByCin(Cin);
    }
}