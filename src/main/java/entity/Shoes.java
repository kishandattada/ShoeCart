package entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shoes {

    @Id
    private int id;
    private String brand;
    private String price;
    private String colour;
    private String sole;
    private String size;
    private String type;

}

