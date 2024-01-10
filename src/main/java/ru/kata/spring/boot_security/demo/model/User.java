package ru.kata.spring.boot_security.demo.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
@Table(name = "user")
public class User implements UserDetails {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotBlank
   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Email
   @Column(name = "email")
   private String email;
   @Column(name = "password")
   private String password;

   public User() {}
   
   public User(String firstName, String lastName, String email, String password) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.password = password;
   }



   public User(long id, String firstName, String lastName, String email, String password) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.password = password;
   }
   public Long getId() {
      return id;
   }

   @ManyToMany
   @LazyCollection(LazyCollectionOption.EXTRA)
   @Fetch(FetchMode.JOIN)
   @JoinTable(
           name = "users_roles",
           joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "role_id")

   )
   private Set<Role> roles = new HashSet<>();
   public void addRole(Role role) {
      roles.add(role);
   }
   public Set<Role> getRoles() {
      return roles;
   }

   public void setRoles(Set<Role> roles) {
      this.roles = roles;
   }
   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      List<GrantedAuthority> listAuthorities = new ArrayList<>();
      for (Role role: roles) {
         listAuthorities.add(new SimpleGrantedAuthority(role.getName()));
      }
      return listAuthorities;
   }

   @Override
   public String getPassword() {
      return password;
   }

   @Override
   public String getUsername() {
      return email;
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return true;
   }

   @Override
   public String toString() {
      return "User{" +
              "firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              '}';
   }
}
