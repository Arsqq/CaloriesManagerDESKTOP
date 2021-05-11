package com.kursach.OOPProject.repo;

import com.kursach.OOPProject.models.AllProducts;
import org.springframework.data.repository.CrudRepository;

public interface AllProductsRepository extends CrudRepository<AllProducts,Long>
{
    AllProducts findByAnyProductNameIgnoreCase(String anyProductName);
    AllProducts findByCalories(Double calories);
    Boolean existsByAnyProductName(String name);
}
