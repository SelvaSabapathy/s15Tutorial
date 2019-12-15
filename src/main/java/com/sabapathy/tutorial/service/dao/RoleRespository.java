package com.sabapathy.tutorial.service.dao;

import com.sabapathy.tutorial.service.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRespository extends JpaRepository<Role, Long> {
}
