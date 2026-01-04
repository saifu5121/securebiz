package com.securebiz.demo.Repository;

import com.securebiz.demo.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(String name);
}



