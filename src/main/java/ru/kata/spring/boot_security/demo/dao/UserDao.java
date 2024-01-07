package ru.kata.spring.boot_security.demo.dao;





import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
public interface UserDao {
   void add(User user);
   void deleteById (long id);
   void update(User user);
   List<User> listUsers();
}
