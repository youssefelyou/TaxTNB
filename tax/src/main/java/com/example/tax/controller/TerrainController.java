package com.example.tax.controller;

import com.example.tax.bean.Terrain;
import com.example.tax.service.TerrainService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/terrain")
public class TerrainController {

    @Autowired
    private TerrainService terrainService;

    @GetMapping("/all")
    public List<Terrain> findAll() {
        return terrainService.findAll();
    }

    @PostMapping("/save")
    public Terrain save(@RequestBody Terrain terrain) {
        return terrainService.save(terrain);
    }

    @GetMapping("/{id}")
    public Optional<Terrain> findById(@PathVariable Long id) {
        return terrainService.findById(id);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        terrainService.deleteById(id);
    }
}
