package com.codegym.controller.api;

import com.codegym.model.Province;
import com.codegym.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("provinces.open-api.vn/api/")
public class ProvinceAPI {

    @Autowired
    private IProvinceService provinceService;

    @GetMapping("/view/{id}")
    public ResponseEntity<Province> getId(@PathVariable Long id){
        Optional<Province> province = provinceService.findById(id);
        if(province.isPresent()){
            return new ResponseEntity<>(province.get(),HttpStatus.OK);
        }else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public  ResponseEntity<Province> saveProvince(@RequestBody Province province){
        if(province.getId() != null){
            return  new ResponseEntity<>(provinceService.save(province),HttpStatus.OK);

        }else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Province>> allProvinces() {
        Iterable<Province> provinces = provinceService.findAll();
        if (((List) provinces).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(provinces, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Province> deleteProvince(@PathVariable Long id) {
        Optional<Province> provinceOptional = provinceService.findById(id);
        if (!provinceOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        provinceService.remove(id);
        return new ResponseEntity<>(provinceOptional.get(), HttpStatus.NO_CONTENT);
    }
}

