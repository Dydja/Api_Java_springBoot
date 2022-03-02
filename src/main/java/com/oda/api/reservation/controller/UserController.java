package com.oda.api.reservation.controller;

import com.oda.api.reservation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.oda.api.reservation.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigInteger;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired //faire appelle au service qui est notre 2 bean
    private UserService userService; //une instance de notre service

    /*@RequestMapping("/")
    public String getUser(){
        return("Hello ,World");
    }*/

    /**
     * Read -Get all users
     * @return - An Iterable object of user full filled
     */

    @GetMapping("/api/v1/users")
    public Iterable<User> getUsers(){
        return userService.getUsers();
    }

    /**
     * Store Users
     * @return - an saveUser object of user full filled
     */
    @PostMapping("/api/v1/users")
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    /**
     * Read get one user obtenir un user en fonction de l'id
     * @param id the id of the user
     * @return an user object full filled
     */
    @GetMapping("/api/v1/users/{id}")
    public User getUsers(@PathVariable("id") final BigInteger id){
        Optional<User> user = userService.getUser(id);
        if(user.isPresent()){
            return user.get();
        }else{
            return null;
        }
    }

    /**
     * Update-update an existing user
     * @param id- the id of user to update
     * @param user -user object updated
     * @return
     */
     @PutMapping("/api/v1/users/{id}")
     public User updateUser(@PathVariable("id") final BigInteger id,@RequestBody User user){
         Optional<User> customer = userService.getUser(id);
         if(customer.isPresent()){
             User currentUser = customer.get();

             String nom = user.getNom();
             if(nom != null){
                 currentUser.setNom(nom);
             }

             String prenom = user.getPrenom();
             if(prenom != null){
                 currentUser.setPrenom(prenom);
             }

             String email = user.getEmail();
             if(email != null){
                 currentUser.setEmail(email);
             }
             String numero = user.getNumero();
             if(numero != null){
                 currentUser.setNumero(numero);
             }

             String mot_passe = user.getMot_passe();
             if(mot_passe != null){
                 currentUser.setMot_passe(mot_passe);
             }
             userService.saveUser(currentUser);
             return currentUser;
         }else{
             return null;
         }
     }





    /**
     * Delete-delete an user
     * @param id-the id of user to delete
     */
    @DeleteMapping("/api/v1/users/{id}")
        public String deleteUser(@PathVariable("id") final BigInteger id){
            userService.deleteUser(id);
            return "Utilisateur supprimé avec succèss" +id;
        }




}
