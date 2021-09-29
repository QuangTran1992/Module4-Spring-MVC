package com.codegym.controller.api;


import com.codegym.model.Shop;
import com.codegym.model.dto.IShopDTO;
import com.codegym.model.dto.ShopDTO;
import com.codegym.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/shops")
public class ShopAPI {
    @Autowired
    private IShopService shopService;


    @GetMapping
    public ResponseEntity<Iterable<ShopDTO>> findAll(){
      try {
          Iterable<ShopDTO> shopList = shopService.findAllByOrders();

          if (((List) shopList).isEmpty()){
              return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
          return new ResponseEntity<>(shopList,HttpStatus.OK);
      }catch (Exception e){
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    }



}
