package com.hqlcrud.CrudOperationsUsingHql.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqlcrud.CrudOperationsUsingHql.Entities.UserEntity;
import com.hqlcrud.CrudOperationsUsingHql.Repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

   // @Transactional
    public void saveUser(UserEntity user) {
        userRepository.saveUser(user);
    }

   // @Transactional(readOnly = true)
    public List<UserEntity> getAllUsers() {
        return userRepository.getAllUsers();
    }

  //  @Transactional(readOnly = true)
    public UserEntity getUserById(Long id) {
        return userRepository.getUserById(id);
    }

 //   @Transactional
    public void updateUser(long id, String name, String email) {
        userRepository.updateUser(id, name, email);
    }

  //  @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
}
