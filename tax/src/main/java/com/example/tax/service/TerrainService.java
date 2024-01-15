package com.example.tax.service;

import com.example.tax.bean.Categorie;
import com.example.tax.bean.Redevable;
import com.example.tax.bean.Terrain;
import com.example.tax.repository.CategorieDao;
import com.example.tax.repository.RedevableDao;
import com.example.tax.repository.TerrainDao;
import com.example.tax.service.abs.IService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerrainService implements IService<Terrain> {

    @Autowired
    private TerrainDao terrainDao;
    @Autowired
    private CategorieDao categorieDao;
    @Autowired
    private RedevableDao redevableDao;


    @Override
    public Page<Terrain> findAll(Pageable page) {
        return terrainDao.findAll(page);
    }

    @Override
    public List<Terrain> findAll() {
        return terrainDao.findAll();
    }

    public Terrain save(Terrain terrain) {
        //check category
        Optional<Categorie> c = categorieDao.findById(terrain.getCategorie().getId());
        if (c.isPresent()) {
            terrain.setCategorie(c.get());
        } else {
            throw new RuntimeException("Category not found.");
        }

        //check Redevable
        Optional<Redevable> r = redevableDao.findById(terrain.getRedevable().getId());
        if (r.isPresent()) {
            terrain.setRedevable(r.get());
        } else {
            // create Redevavle
            Redevable rd = new Redevable();
            rd.setPrenom(terrain.getRedevable().getPrenom());
            rd.setNom(terrain.getRedevable().getNom());
            rd = redevableDao.save(rd);
            terrain.setRedevable(rd);
        }

        return terrainDao.save(terrain);
    }

    @Override
    public Terrain update(Terrain terrain) {
        return null;
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

    public List<Terrain> findByRedevableId(Long id) {
        return terrainDao.findByRedevableId(id);
    }
}