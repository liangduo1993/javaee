package com.ecvlearning.javaee.dao;

import com.ecvlearning.javaee.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {


}
