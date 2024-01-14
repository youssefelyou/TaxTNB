package com.example.tax.service;

import com.example.tax.bean.Taux;
import com.example.tax.repository.TauxDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TauxService {

    @Autowired
    private TauxDao tauxDao;

    public List<Taux> findAll() {
        return tauxDao.findAll();
    }

    public Taux save(Taux taux) {
        return tauxDao.save(taux);
    }

    public Optional<Taux> findById(Long id) {
        return tauxDao.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        tauxDao.deleteById(id);
    }

    public Taux findByCategorieLabel(String label) {
        return tauxDao.findByCategorieLabel(label);
    }
}
