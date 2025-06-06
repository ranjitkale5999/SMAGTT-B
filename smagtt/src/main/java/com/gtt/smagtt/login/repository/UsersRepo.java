package com.gtt.smagtt.login.repository;

import com.gtt.smagtt.login.entity.OurUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsersRepo extends JpaRepository<OurUsers, Integer> {

    Optional<OurUsers> findByEmail(String email);
}
