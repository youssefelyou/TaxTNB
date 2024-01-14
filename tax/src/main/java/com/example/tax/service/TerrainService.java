package com.example.tax.service;

import com.example.tax.bean.Terrain;
import com.example.tax.repository.TerrainDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerrainService {

    @Autowired
    private TerrainDao terrainDao;

    public List<Terrain> findAll() {
        return terrainDao.findAll();
    }

    public Terrain save(Terrain terrain) {
        return terrainDao.save(terrain);
    }

    public Optional<Terrain> findById(Long id) {
        return terrainDao.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        terrainDao.deleteById(id);
    }

    public Terrain findByNom(String nom) {
        return terrainDao.findByNom(nom);
    }
}