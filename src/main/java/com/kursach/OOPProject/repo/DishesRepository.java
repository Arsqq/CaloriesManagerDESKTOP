package com.kursach.OOPProject.repo;

import com.kursach.OOPProject.models.AllProducts;
import com.kursach.OOPProject.models.CerealProducts;
import com.kursach.OOPProject.models.Dishes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface DishesRepository extends CrudRepository<Dishes,Long>
{
    Dishes findByDishNameIgnoreCase(String dishName);
    List<Dishes> findAllByCompositionContaining(String elementOfComposition);
    Dishes findByCalories(Double calories);
    Boolean existsByDishName(String name);
}
