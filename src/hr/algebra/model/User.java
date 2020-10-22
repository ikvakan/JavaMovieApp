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
    
    private  int idUser;
    private  String userName;
    private  String password;

    public User() {
    }

   

    public User(int idUser, String userName, String password) {
        this(userName,password);
        this.idUser = idUser;
    }
    
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
 
    public int getIdUser() {
        return idUser;
    }

    
    
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
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
