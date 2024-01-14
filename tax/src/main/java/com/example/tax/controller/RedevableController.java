package com.example.tax.controller;

import com.example.tax.bean.Redevable;
import com.example.tax.controller.abs.AbstractController;
import com.example.tax.service.RedevableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/redevable")
public class RedevableController extends AbstractController<Redevable, RedevableService> {


    public RedevableController(RedevableService service) {
        super(service);
    }
}