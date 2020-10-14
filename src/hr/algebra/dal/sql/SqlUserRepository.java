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
import java.sql.Types;
import javax.sql.DataSource;



/**
 *
 * @author IgorKvakan
 */
public class SqlUserRepository implements UserRepository{

    private static final String ID_USER="IdUser";
    private static final String USER_NAME="UserName";
    private static final String PASSWORD="Password";
    
    private static final String CREATE_USER="{ CALL createUser (?,?,?) }";
    private static final String SELECT_USER="{ CALL selectUser (?) }";
    private static final String SELECT_USERS="{ CALL selectUsers  }";
    
    
    
    @Override
    public int createUser(User user) throws Exception {
        DataSource dataSourcece=DataSourceSingleton.getInstance();
        try(Connection con= dataSourcece.getConnection();
                CallableStatement stmt= con.prepareCall(CREATE_USER)){
            stmt.setString(1,user.getUserName());
            stmt.setString(2,user.getPassword());
            stmt.registerOutParameter(3, Types.INTEGER);
            
            stmt.executeUpdate();
            return stmt.getInt(3);
        }
    }

    @Override
    public Optional<User> selectUser(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> selectUsers() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
