package com.shopping.responsivepageservice.service;



import com.shopping.responsivepageservice.Repository.MyRepository;
import com.shopping.responsivepageservice.entity.Shoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MyService {


    @Autowired
    private MyRepository myrepo;


    
    public List<Shoes> fetchShoeList()
    {
        return myrepo.findAll();
    }

    public Optional<Shoes> getShoesById(int id){
        return myrepo.findById(id);
    }

    public Shoes saveShoe(Shoes shoes)
    {
        return myrepo.save(shoes);
    }

//    public List<Shoes> saveShoeList(List<Shoes> shoes)
//    {
//        return myrepo.save(shoes);
//    }

    public Shoes updateShoeRecord(Shoes shoes, Integer Id)
    {

        Shoes shoeDB = myrepo.findById(Id).get();

        if (Objects.nonNull(shoes.getId()) && !"".equalsIgnoreCase(shoes.getBrand())) {
            shoeDB.setBrand(shoes.getBrand());
            shoeDB.setId(shoes.getId());
            shoeDB.setSize(shoes.getSize());
            shoeDB.setSole(shoes.getSole());
            shoeDB.setPrice(shoes.getPrice());
            shoeDB.setColour(shoes.getColour());
        }
        return myrepo.save(shoeDB);
    }
    public void deleteById(Integer id)
    {
        myrepo.deleteById(id);
    }


}
