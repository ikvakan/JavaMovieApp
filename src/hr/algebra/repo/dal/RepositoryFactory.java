/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.repo.dal;

import hr.algebra.dal.sql.SqlMovieRepository;
import hr.algebra.dal.sql.SqlUserRepository;

/**
 *
 * @author IgorKvakan
 */
public  class RepositoryFactory {

    public RepositoryFactory() {
    }
    
    public static UserRepository getSqlUserRepository() throws Exception{
        return new SqlUserRepository();
    }
    
    public static MovieRepository getMovieRepository(){
        return new SqlMovieRepository();
    }
    
}
