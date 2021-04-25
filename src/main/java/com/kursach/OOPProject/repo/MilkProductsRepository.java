package com.kursach.OOPProject.repo;

import com.kursach.OOPProject.models.Dishes;
import com.kursach.OOPProject.models.MilkProducts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface MilkProductsRepository extends CrudRepository<MilkProducts,Long>
{
   MilkProducts findByMilkProductName(String milkProductName);
}
