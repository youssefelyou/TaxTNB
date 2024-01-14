package com.example.tax.controller;


import com.example.tax.bean.TaxeTNB;
import com.example.tax.service.TaxeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/taxe")
public class TaxeController {

    @Autowired
    private TaxeService taxeService;

    @GetMapping("/all")
    public List<TaxeTNB> findAll() {
        return taxeService.findAll();
    }


    @GetMapping("/")
    public TaxeTNB findByTerrainNomAndTnbYear(String nom, int tnbYear) {
        return taxeService.findByTerrainNomAndTnbYear(nom, tnbYear);
    }

    @PostMapping("/save")
    public int save(TaxeTNB taxeTNB) {
        return taxeService.save(taxeTNB);
    }

    @GetMapping("/{id}")
    public Optional<TaxeTNB> findById(@PathVariable Long id) {
        return taxeService.findById(id);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        taxeService.deleteById(id);
    }
}
