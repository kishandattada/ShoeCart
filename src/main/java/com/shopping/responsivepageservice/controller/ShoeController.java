package com.shopping.responsivepageservice.controller;


import com.shopping.responsivepageservice.entity.Shoes;
import com.shopping.responsivepageservice.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShoeController {

    @Autowired
    MyService ser;

    @GetMapping(value = "/shoes")
    public List<Shoes> getListofShoes(){
       return ser.fetchShoeList();
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/shoeById/{id}")
    public Optional<Shoes> getShoesById(@PathVariable("id") int id){
        return ser.getShoesById(id);
    }

    @PostMapping(value= "/shoe",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Shoes insertRecord(@RequestBody Shoes shoe){
        return ser.saveShoe(shoe);
    }


    @PutMapping(value = "/shoe/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Shoes updateExistingRecord(@RequestBody Shoes shoe, @PathVariable("id") int id){
        return ser.updateShoeRecord(shoe, id);
    }

    @DeleteMapping("/shoe/{id}")
    public void deleteExistingRecord(@PathVariable("id") int id){
        ser.deleteById(id);
    }

}
