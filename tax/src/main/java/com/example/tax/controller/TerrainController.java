package com.example.tax.controller;

import com.example.tax.bean.Terrain;
import com.example.tax.controller.abs.AbstractController;
import com.example.tax.service.TerrainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/terrain")
public class TerrainController extends AbstractController<Terrain, TerrainService> {

    public TerrainController(TerrainService service) {
        super(service);
    }

    @GetMapping("redevable/id/{id}")
    public List<Terrain> findByRedevableId(@PathVariable Long id) {
        return service.findByRedevableId(id);
    }

    @GetMapping("redevable/cin/{cin}")
    public List<Terrain> findByRedevableCin(@PathVariable String cin) {
        return service.findByRedevableCin(cin);
    }
}
