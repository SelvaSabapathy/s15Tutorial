package com.sabapathy.tutorial.dao;

import com.sabapathy.tutorial.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRespository extends JpaRepository<Role, Long> {
}
