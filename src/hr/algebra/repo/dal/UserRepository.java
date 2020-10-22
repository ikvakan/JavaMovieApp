/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.repo.dal;

import hr.algebra.model.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author IgorKvakan
 */
public interface UserRepository {
    
    int createUser(User user) throws Exception;
    Optional<User> selectUser(int id) throws Exception;
    List<User> selectUsers() throws Exception;
    void insertIntoUserMovies(int idUser,int idMovie) throws Exception;
    
}
