package com.example.tax.controller;

import com.example.tax.bean.Categorie;
import com.example.tax.service.CategorieService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/categorie")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/all")
    public List<Categorie> findAll() {
        return categorieService.findAll();
    }

    @PostMapping("/save")
    public Categorie save(@RequestBody Categorie categorie) {
        return categorieService.save(categorie);
    }

    @GetMapping("/{id}")
    public Optional<Categorie> findById(@PathVariable Long id) {
        return categorieService.findById(id);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        categorieService.deleteById(id);
    }
}