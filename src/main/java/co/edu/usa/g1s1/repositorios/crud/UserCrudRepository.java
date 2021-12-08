/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.g1s1.repositorios.crud;

import co.edu.usa.g1s1.modelo.User;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author juvinao
 */
public interface UserCrudRepository extends CrudRepository<User, Integer> {
    
    @Query(value = "Select e from User e Where e.email = ?1 and e.password = ?2")
    public Optional<User> findByEmailAndPassword(String email, String password);

    @Query(value = "Select e from User e Where e.email = ?1")
    public Optional<User> findByEmail(String email);
}
