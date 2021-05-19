package com.kursach.OOPProject.repo;

import com.kursach.OOPProject.models.MeatDishes;
import com.kursach.OOPProject.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository  extends CrudRepository<Users,Long>
{
   boolean existsByNameAndPassword(String name,String password);
    Users findByMail(String mail);
}
