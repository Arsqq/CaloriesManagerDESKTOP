package com.kursach.OOPProject.repo;

import com.kursach.OOPProject.models.MeatDishes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeatDishesRepository extends CrudRepository<MeatDishes,Long>
{
    List<MeatDishes> findAllByCompositionContaining(String elementOfComposition);
    MeatDishes findAByMeatDishName(String meatDishName);

}
