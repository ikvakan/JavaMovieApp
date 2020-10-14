/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

/**
 *
 * @author IgorKvakan
 */
public class User {
    
    private final String userName;
    private final String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    
    
    @Override
    public String toString() {
        return userName ;
    }
    public static boolean isAdmin(String userName,String password){
        if (userName.equals("Admin") && password.equals("123")) {
            return true;
        }
        return false;
    }
    
    
}
