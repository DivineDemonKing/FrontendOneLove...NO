package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kata.spring.boot_security.demo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT r FROM Role r where r.name = ?1")
    public Role findByName(String name);
}
