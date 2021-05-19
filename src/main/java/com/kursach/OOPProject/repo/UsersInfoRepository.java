package com.kursach.OOPProject.repo;

import com.kursach.OOPProject.models.Users;
import com.kursach.OOPProject.models.UsersIndInfo;
import com.kursach.OOPProject.models.Vegetables;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersInfoRepository extends CrudRepository<UsersIndInfo,Long>
{
    UsersIndInfo findByUserName(String name);
    boolean existsByUserName(String name);
}
