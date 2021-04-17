package com.kursach.OOPProject.repo;

import com.kursach.OOPProject.models.VeganDishes;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface VeganDishesRepository extends CrudRepository<VeganDishes,Long>
{

}
