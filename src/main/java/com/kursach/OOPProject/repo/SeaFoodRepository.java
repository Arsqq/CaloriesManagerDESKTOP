package com.kursach.OOPProject.repo;

import com.kursach.OOPProject.models.SeaFood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SeaFoodRepository extends CrudRepository <SeaFood,Long>
{
    SeaFood findBySeaFoodName(String seaFoodName);
}
