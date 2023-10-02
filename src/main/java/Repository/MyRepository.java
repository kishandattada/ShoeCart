package Repository;

import entity.Shoes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;




@Repository
public abstract class MyRepository implements CrudRepository<Shoes, Integer> {


}
