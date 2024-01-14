package com.example.tax.service;

import com.example.tax.bean.*;
import com.example.tax.repository.RedevableDao;
import com.example.tax.repository.TauxDao;
import com.example.tax.repository.TaxeDao;
import com.example.tax.repository.TerrainDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxeService {

    @Autowired
    private TaxeDao taxeDao;
    @Autowired
    private TerrainDao terrainDao;
    @Autowired
    private TauxDao tauxDao;
    @Autowired
    private RedevableDao redevableDao;


    public List<TaxeTNB> findAll() {
        return taxeDao.findAll();
    }

    public int  save(TaxeTNB taxeTNB) {
        Redevable redevable = redevableDao.findByCin(taxeTNB.getRedevable().getCin());
        Terrain terrain = terrainDao.findByNom(taxeTNB.getTerrain().getNom());

        if (redevable == null) {
            return -1;
        } else if (terrain == null) {
            return -2;
        } else if (terrain.getCategorie() == null) {
            return -3;
        } else if (taxeDao.findByTerrainNomAndTnbYear(terrain.getNom(), taxeTNB.getTnbYear()) != null) {
            return -4;
        } else if (tauxDao.findByCategorieLabel(terrain.getCategorie().getLabel()) == null) {
            return -5;
        } else {
            Taux taux = tauxDao.findByCategorieLabel(terrain.getCategorie().getLabel());
            taxeTNB.setRedevable(redevable);
            taxeTNB.setTerrain(terrain);
            taxeTNB.setTaux(taux);
            taxeTNB.setTotal(taxeTNB.getTerrain().getSurface() * taxeTNB.getTaux().getMontant());

        }
        return 1;

    }


    public Optional<TaxeTNB> findById(Long id) {
        return taxeDao.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        taxeDao.deleteById(id);
    }

    public TaxeTNB findByTerrainNomAndTnbYear(String nom, int tnbYear) {
        return taxeDao.findByTerrainNomAndTnbYear(nom, tnbYear);
    }
}