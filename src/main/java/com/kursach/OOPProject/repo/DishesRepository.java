package com.kursach.OOPProject.repo;

import com.kursach.OOPProject.models.Dishes;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DishesRepository extends CrudRepository<Dishes,Long>
{

}
