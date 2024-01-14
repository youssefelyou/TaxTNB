package com.example.tax.service;

import com.example.tax.bean.Redevable;
import com.example.tax.repository.RedevableDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RedevableService {

    @Autowired
    private RedevableDao redevableDao;

    public List<Redevable> findAll() {
        return redevableDao.findAll();
    }

    public Redevable save(Redevable redevable) {
        return redevableDao.save(redevable);
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