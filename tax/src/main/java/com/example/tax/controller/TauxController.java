package com.example.tax.controller;


import com.example.tax.bean.Taux;
import com.example.tax.service.TauxService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/taux")
public class TauxController {

    @Autowired
    private TauxService tauxService;

    @GetMapping("/all")
    public List<Taux> findAll() {
        return tauxService.findAll();
    }

    @PostMapping("/save")
    public Taux save(@RequestBody Taux taux) {
        return tauxService.save(taux);
    }

    @GetMapping("/{id}")
    public Optional<Taux> findById(@PathVariable Long id) {
        return tauxService.findById(id);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        tauxService.deleteById(id);
    }
}
