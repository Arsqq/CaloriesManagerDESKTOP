package com.kursach.OOPProject.repo;

import com.kursach.OOPProject.models.Dishes;
import com.kursach.OOPProject.models.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ProductsRepository extends CrudRepository<Products,Long>
{

}
