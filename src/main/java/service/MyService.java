package service;

import Repository.MyRepository;
import entity.Shoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MyService {

    @Autowired
    private MyRepository repo;

    
    public List<Shoes> fetchShoeList()
    {
        return (List<Shoes>)
                repo.findAll();
    }

    public Optional<Shoes> getShoesById(int id){
        return repo.findById(id);
    }

    public Shoes saveShoe(Shoes shoes)
    {
        return repo.save(shoes);
    }

    public Shoes updateShoeRecord(Shoes shoes, Integer Id)
    {

        Shoes shoeDB = repo.findById(Id).get();

        if (Objects.nonNull(shoes.getId()) && !"".equalsIgnoreCase(shoes.getBrand())) {
            shoeDB.setBrand(shoes.getBrand());
            shoeDB.setId(shoes.getId());
            shoeDB.setSize(shoes.getSize());
            shoeDB.setSole(shoes.getSole());
            shoeDB.setPrice(shoes.getPrice());
            shoeDB.setColour(shoes.getColour());
        }
        return repo.save(shoeDB);
    }
    public void deleteById(Integer id)
    {
        repo.deleteById(id);
    }


}
