package com.example.tax.repository;

import com.example.tax.bean.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerrainDao extends JpaRepository<Terrain, Long> {
    Terrain findByNom(String nom);

    List<Terrain> findByRedevableId(Long id);
    List<Terrain> findByRedevableCin(String id);

}

