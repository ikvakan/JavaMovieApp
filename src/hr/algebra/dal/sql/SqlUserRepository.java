/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

import hr.algebra.model.User;
import java.util.List;
import java.util.Optional;
import hr.algebra.repo.dal.UserRepository;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import javax.sql.DataSource;

/**
 *
 * @author IgorKvakan
 */
public class SqlUserRepository implements UserRepository {

    
    
    private static final String ID_USER = "IdUser";
    private static final String USER_NAME = "UserName";
    private static final String PASSWORD = "Password";

    private static final String CREATE_USER = "{ CALL createUser (?,?,?) }";
    private static final String SELECT_USER = "{ CALL selectUser (?) }";
    private static final String SELECT_USERS = "{ CALL selectUsers  }";

    private static final String INSERT_INTO_USER_MOVIES = "{ CALL insertIntoUserMovies (?,?)  }";
    

    public SqlUserRepository() {
        
    }
    
    

    @Override
    public int createUser(User user) throws Exception {
        DataSource dataSourcece = DataSourceSingleton.getInstance();
        try (Connection con = dataSourcece.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_USER)) {
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPassword());
            stmt.registerOutParameter(3, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(3);
        }
    }

    @Override
    public Optional<User> selectUser(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_USER)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new User(
                            rs.getInt(ID_USER),
                            rs.getString(USER_NAME),
                            rs.getString(PASSWORD)));
                }
            }
        }

        return Optional.empty();
    }

    @Override
    public List<User> selectUsers() throws Exception {
        List<User> users = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_USERS);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                users.add(new User(
                        rs.getInt(ID_USER),
                        rs.getString(USER_NAME),
                        rs.getString(PASSWORD))
                );

            };

        }
        return users;
    }

    @Override
    public void insertIntoUserMovies(int idUser, int idMovie) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(INSERT_INTO_USER_MOVIES)) {

            stmt.setInt(1,idUser);
            stmt.setInt(2,idMovie);
            
            stmt.executeUpdate();
        }
    }

}
