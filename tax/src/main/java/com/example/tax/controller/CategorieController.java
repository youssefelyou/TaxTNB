package com.example.tax.controller;

import com.example.tax.bean.Categorie;
import com.example.tax.controller.abs.AbstractController;
import com.example.tax.service.CategorieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categorie")
public class CategorieController extends AbstractController<Categorie, CategorieService> {

    public CategorieController(CategorieService service) {
        super(service);
    }

}