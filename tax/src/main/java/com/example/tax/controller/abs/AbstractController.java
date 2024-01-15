package com.example.tax.controller.abs;

import com.example.tax.service.abs.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class AbstractController<T, SERV extends IService<T>> {
    protected SERV service;

    public AbstractController(SERV service) {
        this.service = service;
    }

    @GetMapping("page")
    public Page<T> findAll(@RequestParam(defaultValue = "0", required = false) int page, @RequestParam(defaultValue = "10", required = false) int size) {
        return service.findAll(PageRequest.of(page, size));
    }

    @GetMapping("all")
    public List<T> findAll() {
        return service.findAll();
    }

    @PostMapping("save")
    public T save(@RequestBody T t) {
        return service.save(t);
    }

    @PutMapping("update")
    public T update(@RequestBody T t) {
        return service.update(t);
    }

    @GetMapping("id/{id}")
    public Optional<T> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("id/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
