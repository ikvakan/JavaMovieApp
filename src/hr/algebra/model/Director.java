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
public class Director {
    
    private int IDDirector;
    private String firstName;
    private String lastName;

    public Director(int IDDirector, String firstName, String lastName) {
        this.IDDirector = IDDirector;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getIDDirector() {
        return IDDirector;
    }

    public void setIDDirector(int IDDirector) {
        this.IDDirector = IDDirector;
    }

    
    public Director(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return  firstName  + lastName ;
    }
    
    
    
}
