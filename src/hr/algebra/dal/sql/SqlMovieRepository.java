/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

import hr.algebra.model.Movie;
import hr.algebra.repo.dal.MovieRepository;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.sql.DataSource;

/**
 *
 * @author IgorKvakan
 */
public class SqlMovieRepository implements MovieRepository {

    private static final String ID_MOVIE = "IDMovie";
    private static final String TITLE = "Title";
    private static final String DECSCRIPTION = "Description";
    private static final String DIRECTOR = "Director";
    private static final String ACTORS = "Actors";
    private static final String  DURATION= "Duration";
    private static final String  GENRE= "Genre";
    private static final String  PUB_DATE= "PubDate";
    private static final String  PICTURE_PATH= "PicturePath";
    
    private static final String CREATE_MOVIE = "{ CALL createMovie (?,?,?,?,?,?,?,?,?) }";
    private static final String SELECT_MOVIE = "{ CALL selectMovie (?) }";
    private static final String SELECT_MOVIES = "{ CALL selectMovies }";
    
    @Override
    public int createMovie(Movie movie) throws Exception {
        DataSource dataSource=DataSourceSingleton.getInstance();
        try(Connection con=dataSource.getConnection();
                CallableStatement stmt=con.prepareCall(CREATE_MOVIE)){
            
            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getDescription());
            stmt.setString(3, movie.getDirector());
            stmt.setString(4, movie.getActors());
            stmt.setString(5, movie.getDuration());
            stmt.setString(6, movie.getGenre());
            stmt.setString(7, movie.getPubDate());
            stmt.setString(8, movie.getPicturePath());
            stmt.registerOutParameter(9, Types.INTEGER);
            
            stmt.executeUpdate();
            return stmt.getInt(9);
        }
    }

    @Override
    public void createMovies(Set<Movie> movies) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIE)){
                
            for (Movie movie : movies) {
                stmt.setString(1, movie.getTitle());
                stmt.setString(2, movie.getDescription());
                stmt.setString(3, movie.getDirector());
                stmt.setString(4, movie.getActors());
                stmt.setString(5, movie.getDuration());
                stmt.setString(6, movie.getGenre());
                stmt.setString(7, movie.getPubDate());
                stmt.setString(8, movie.getPicturePath());
                stmt.registerOutParameter(9, Types.INTEGER);
            
                stmt.executeUpdate();
            }           
            
        }
            
            
            
    }

    @Override
    public void updateMovie(int id, Movie data) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteMovie(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Movie> selectMovie(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_MOVIE)) {
           
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                
                if (rs.next()) {
                    return Optional.of(new Movie(
                            rs.getInt(ID_MOVIE),
                            rs.getString(TITLE),
                            rs.getString(DECSCRIPTION),
                            rs.getString(DIRECTOR),
                            rs.getString(ACTORS),
                            rs.getString(DURATION),
                            rs.getString(GENRE),
                            rs.getString(PUB_DATE),
                            rs.getString(PICTURE_PATH)
                    ));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Movie> selectMovies() throws Exception {
        List<Movie> movies = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_MOVIES);
                ResultSet rs = stmt.executeQuery()) {
          
            while (rs.next()) {
                movies.add(new Movie(
                        rs.getInt(ID_MOVIE),
                            rs.getString(TITLE),
                            rs.getString(DECSCRIPTION),
                            rs.getString(DIRECTOR),
                            rs.getString(ACTORS),
                            rs.getString(DURATION),
                            rs.getString(GENRE),
                            rs.getString(PUB_DATE),
                            rs.getString(PICTURE_PATH)
                        
                                ));
            }
        } 
        return movies;
    }

   
    
}
