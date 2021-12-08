/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.g1s1.servicios;

import co.edu.usa.g1s1.modelo.User;
import co.edu.usa.g1s1.repositorios.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author juvinao
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User getById(int id) {
        Optional<User> user = userRepository.getById(id);
        return user.orElse(null);
    }

    public User getByEmailAndPassword(String email, String password) {
        Optional<User> user = userRepository.getByEmailAndPassword(email, password);
        if (user.isPresent()) {
            return user.get();
        } else {
            User e = new User();
            e.setEmail(email);
            e.setPassword(password);
            e.setName("NO DEFINIDO");
            return e;
        }
    }
        public boolean getByEmail(String email){
        Optional<User> user = userRepository.getByEmail(email);
        if(user.isPresent()){
            return true;
        }else{
            return false;
        }
    }
    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean delete(int id) {

        Boolean d = userRepository.getById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return d;

    }

    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> consultado = userRepository.getById(user.getId());
            if (consultado.isPresent()) {
                if (user.getEmail() != null) {
                    consultado.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    consultado.get().setPassword(user.getPassword());
                }
                return userRepository.save(consultado.get());
            }
        }
        return user;
    }

}
