package com.kursach.OOPProject.repo;

import com.kursach.OOPProject.models.CerealProducts;
import com.kursach.OOPProject.models.MilkProducts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Supplier;

@Repository
public interface CerealProductsRepository extends CrudRepository<CerealProducts,Long>
{
   CerealProducts findByCerealProductName(String cerealProductName);
}
