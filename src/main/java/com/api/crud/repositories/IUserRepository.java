package com.api.crud.repositories;

import com.api.crud.models.UserModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IUserRepository extends JpaRepository<UserModels,Long> {


}
