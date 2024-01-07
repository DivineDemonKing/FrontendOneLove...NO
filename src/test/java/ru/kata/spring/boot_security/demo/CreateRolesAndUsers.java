package ru.kata.spring.boot_security.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CreateRolesAndUsers {
    @Autowired
    RoleRepository repo;
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testCreateRoles() {
        Role userRole = new Role("ROLE_USER");
        Role adminRole = new Role("ROLE_ADMIN");
        repo.saveAll(List.of(userRole, adminRole));

        User user = new User("user", "user", "user@gmail.com", "user");
        Role roleUser = repo.findByName("ROLE_USER");
        user.addRole(roleUser);
        userRepository.save(user);

        user = new User("admin", "admin", "admin@gmail.com", "admin");
        roleUser = repo.findByName("ROLE_ADMIN");
        user.addRole(roleUser);
        userRepository.save(user);

        user = new User("both", "both", "both@gmail.com", "both");
        roleUser = repo.findByName("ROLE_USER");
        Role role = repo.findByName("ROLE_ADMIN");
        user.addRole(roleUser);
        user.addRole(role);
        userRepository.save(user);

        assert (true);
    }
}
