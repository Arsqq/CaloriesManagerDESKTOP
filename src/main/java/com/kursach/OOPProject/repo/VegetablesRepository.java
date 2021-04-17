package com.kursach.OOPProject.repo;

import com.kursach.OOPProject.models.Vegetables;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VegetablesRepository extends CrudRepository<Vegetables,Long>
{
    Vegetables findByVegetableName(String vegetableName);
}
