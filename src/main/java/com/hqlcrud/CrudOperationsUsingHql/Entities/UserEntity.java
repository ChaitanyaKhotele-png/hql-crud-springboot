package com.hqlcrud.CrudOperationsUsingHql.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userDetails")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 private String name;
 private String email;
 public int getId() {
    return id;
 }
 public String getName() {
    return name;
 }
 public String getEmail() {
    return email;
 }
 public void setId(int id) {
    this.id = id;
 }
 public void setName(String name) {
    this.name = name;
 }
 public void setEmail(String email) {
    this.email = email;
 }
 public UserEntity(int id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
 }
 

}
