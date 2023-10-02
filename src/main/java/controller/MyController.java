package controller;

import entity.Shoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.MyService;

import java.util.List;
import java.util.Optional;

@Controller
public class MyController {

    @Autowired
    MyService ser;

    @GetMapping("/shoesList")
    public List<Shoes> getListofShoes(){
       return ser.fetchShoeList();
    }

    @GetMapping("/shoeById/{id}")
    public Optional<Shoes> getShoesById(@PathVariable("id") int id){
        return ser.getShoesById(id);
    }

    @PostMapping("/Shoe")
    public Shoes insertRecord(@RequestBody Shoes shoe){
        return ser.saveShoe(shoe);
    }

    @PutMapping("/shoe/{id}")
    public Shoes updateExistingRecord(@RequestBody Shoes shoe, @PathVariable("id") int id){
        return ser.updateShoeRecord(shoe, id);
    }

    @DeleteMapping("/shoe/{id}")
    public void deleteExistingRecord(@PathVariable("id") int id){
        ser.deleteById(id);
    }

}
