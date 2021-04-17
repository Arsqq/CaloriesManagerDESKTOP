package com.kursach.OOPProject.repo;

import com.kursach.OOPProject.models.MeatDishes;
import com.kursach.OOPProject.models.VeganDishes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface VeganDishesRepository extends CrudRepository<VeganDishes,Long>
{
    List<VeganDishes> findAllByCompositionContaining(String elementOfComposition);
    VeganDishes findByVeganDishName(String veganDishName);
}
