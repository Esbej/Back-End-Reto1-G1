/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.g1s1.repositorios;

import co.edu.usa.g1s1.modelo.User;
import co.edu.usa.g1s1.repositorios.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author juvinao
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository repo;

    public List<User> getAll() {
        return (List<User>) repo.findAll();
    }
    
    public Optional<User> getByEmailAndPassword(String email, String password) {
        return repo.findByEmailAndPassword(email, password);
    }

    public Optional<User> getByEmail(String email){
        return repo.findByEmail(email);
    }

    public Optional<User> getById(int id) {
        return repo.findById(id);
    }

    public User save(User user) {
        return repo.save(user);
    }

    public void delete(User user) {
        repo.delete(user);
    }



}
