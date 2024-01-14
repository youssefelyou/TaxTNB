package com.example.tax.controller;


import com.example.tax.bean.Taux;
import com.example.tax.controller.abs.AbstractController;
import com.example.tax.service.TauxService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/taux")
public class TauxController extends AbstractController<Taux, TauxService> {

    public TauxController(TauxService service) {
        super(service);
    }
}
