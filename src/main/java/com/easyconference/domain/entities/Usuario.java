/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.easyconference.domain.entities;

/**
 *
 * @author Karol
 */
public class Usuario {

    private String name;
    private String lastName;
    private String email;
    private String password;
    private String country;
    private String organization;
    private String Ifields;

    public Usuario(String name, String lastName, String email, String password, String country, String organization, String Ifields) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.country = country;
        this.organization = organization;
        this.Ifields = Ifields;
    }
       
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getIfields() {
        return Ifields;
    }

    public void setIfields(String Ifields) {
        this.Ifields = Ifields;
    }
    
}
