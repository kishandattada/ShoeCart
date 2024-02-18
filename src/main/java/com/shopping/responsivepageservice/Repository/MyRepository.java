package com.shopping.responsivepageservice.Repository;


import com.shopping.responsivepageservice.entity.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MyRepository extends JpaRepository<Shoes, Integer> {


}
