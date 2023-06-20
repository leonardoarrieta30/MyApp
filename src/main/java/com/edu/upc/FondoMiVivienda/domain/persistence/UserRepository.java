package com.edu.upc.FondoMiVivienda.domain.persistence;

import com.edu.upc.FondoMiVivienda.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findUserByName(String name);



}
