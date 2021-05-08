package com.kursach.OOPProject.repo;

import com.kursach.OOPProject.models.AllProducts;
import org.springframework.data.repository.CrudRepository;

public interface AllProductsRepository extends CrudRepository<AllProducts,Long>
{
    AllProducts findByAnyProductName(String anyProductName);
    AllProducts findByCalories(Double calories);
}
