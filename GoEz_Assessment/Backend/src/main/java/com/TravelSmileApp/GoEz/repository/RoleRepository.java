package com.TravelSmileApp.GoEz.repository;

import com.TravelSmileApp.GoEz.models.ERole;
import com.TravelSmileApp.GoEz.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
