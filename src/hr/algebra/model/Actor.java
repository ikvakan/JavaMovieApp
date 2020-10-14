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
public class Actor {
    
    
    private int IDActor;
    private String firsName;
    private String lastName;

    public Actor(int IDActor, String firsName, String lastName) {
        this.IDActor = IDActor;
        this.firsName = firsName;
        this.lastName = lastName;
    }

    public int getIDActor() {
        return IDActor;
    }

    public void setIDActor(int IDActor) {
        this.IDActor = IDActor;
    }

    
    
    public Actor(String firsName, String lastName) {
        this.firsName = firsName;
        this.lastName = lastName;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return  firsName +  lastName ;
    }
    
    
    
}
