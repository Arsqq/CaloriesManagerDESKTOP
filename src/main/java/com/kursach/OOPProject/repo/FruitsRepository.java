package com.kursach.OOPProject.repo;

import com.kursach.OOPProject.models.Fruits;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitsRepository extends CrudRepository<Fruits,Long>
{
    Fruits findByFruitName(String fruitName);
}
