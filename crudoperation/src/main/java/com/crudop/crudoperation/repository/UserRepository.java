package com.crudop.crudoperation.repository;

import com.crudop.crudoperation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}