/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.easyconference.domain.service;

import com.easyconference.access.ConferenciaArrayListRepository;
import com.easyconference.domain.entities.Usuario;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import com.easyconference.access.IUserService;

/**
 * Acerca de los usuarios
 * String name, String lastName, String email, String password, String country, String organization, String Ifields;
 */
public class UserService{
    private IUserService repository;

    public UserService(IUserService repository) {
        this.repository = repository;
    }
    
    public boolean registerUser(String name, String lastName, String email, String password, String country, String organization, String Ifields) {
        // Validar todos los campos
        if (!validateFields(name, lastName, email, password, country, organization, Ifields)) {
            return false;
        }
        // Crear nuevo usuario
         Usuario newUser = new Usuario(name, lastName, email, password, country, organization, Ifields);
         repository.storeUsuario(newUser);
        // Almacenar el usuario en el repositorio
        return true;
    }
    
    private boolean validateFields(String name, String lastName, String email, String password, String country, String organization, String Ifields) {
        if (!repository.validarNombre(name) || !repository.validarNombre(lastName)) {
            JOptionPane.showMessageDialog(null, "Nombre o apellido inválido", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!repository.validarEmail(email)) {
            JOptionPane.showMessageDialog(null, "Email inválido", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!repository.validarContrasena(password)) {
            JOptionPane.showMessageDialog(null, "Contraseña inválida. Debe tener al menos 8 caracteres", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!repository.validarCampo(country) || !repository.validarCampo(organization) || !repository.validarCampo(Ifields)) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Métodos adicionales si son necesarios
    

   public Usuario login(String correo, String contrasenia){
   
       return repository.login(correo, contrasenia); 
   } 

    public IUserService getRepository() {
        return repository;
    }
   
   
}
