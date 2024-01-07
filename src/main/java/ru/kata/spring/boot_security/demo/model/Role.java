package ru.kata.spring.boot_security.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    public Role() {

    }
    public Role(Long id) {
        this.id = id;
    }

    public Role(String name) {
        this.name = name;
    }
    public Role(Long id,String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return id.toString();
    }
}
