package com.example.tax.controller;

import com.example.tax.bean.Terrain;
import com.example.tax.controller.abs.AbstractController;
import com.example.tax.service.TerrainService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/terrain")
public class TerrainController extends AbstractController<Terrain, TerrainService> {

    public TerrainController(TerrainService service) {
        super(service);
    }
}
