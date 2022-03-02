package com.oda.api.reservation.service;

import com.oda.api.reservation.model.User;
import com.oda.api.reservation.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;
//Service est un pont entre controller et le repository
@Data
@Service //identique au @Component et @ Repository juste particulier
public class UserService {

    @Autowired //faire appelle au repository qui est notre bean
    private UserRepository userRepository; //une instance de notre repository

    //on recupere un elements pas son id
     public Optional<User> getUser(final BigInteger id){
         return userRepository.findById(id);
     }

     //Recupere tout les elts
    public Iterable<User> getUsers(){
         return userRepository.findAll();
    }

    //Supprimer un elment via l'id
    public void deleteUser(final BigInteger id){
         userRepository.deleteById(id);
    }

    //Save un element model classe User
    public User saveUser(User user){
         User savedUser = userRepository.save(user);
         return savedUser;
    }

}
