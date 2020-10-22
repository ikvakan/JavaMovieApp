/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.repo.dal;

import hr.algebra.model.Movie;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author IgorKvakan
 */
public interface MovieRepository {
    
    int createMovie(Movie article) throws Exception;
    void createMovies(Set<Movie> articles) throws Exception;    
    void updateMovie(int id, Movie data) throws Exception;
    void deleteMovie(int id) throws Exception;
    Optional<Movie> selectMovie(int id) throws Exception;
    List<Movie> selectMovies() throws Exception;
    List<Movie> selectMovieForUser(int id) throws Exception;
    void deleteMovieForUser(int id) throws Exception;
}
