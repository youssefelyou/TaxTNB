package com.example.tax.controller;

import com.example.tax.bean.Redevable;
import com.example.tax.service.RedevableService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/redevable")
public class RedevableController {

    @Autowired
    private RedevableService redevableService;

    @GetMapping("/all")
    public List<Redevable> findAll() {
        return redevableService.findAll();
    }

    @PostMapping("/save")
    public Redevable save(@RequestBody Redevable redevable) {
        return redevableService.save(redevable);
    }

    @GetMapping("/{id}")
    public Optional<Redevable> findById(@PathVariable Long id) {
        return redevableService.findById(id);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        redevableService.deleteById(id);
    }
}