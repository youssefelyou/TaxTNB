package com.example.tax.controller;


import com.example.tax.bean.TaxeTNB;
import com.example.tax.controller.abs.AbstractController;
import com.example.tax.service.TaxeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/taxe")
public class TaxeController extends AbstractController<TaxeTNB, TaxeService> {

    public TaxeController(TaxeService service) {
        super(service);
    }
}
