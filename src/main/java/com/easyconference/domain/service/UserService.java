/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.easyconference.domain.service;

import com.easyconference.access.User.IUserRepository;
import com.easyconference.access.Conference.ConferenceArrayListRepository;
import com.easyconference.domain.entities.Usuario;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * Esta clase contiene servivios para la clase Usuario
 * 
 * @author 
 * @version 1.0
 * @since 2024
 */
public class UserService{
    private IUserRepository repository;
     /**
     * Constructor que recibe un repositorio de usuarios.
     *
     * @param repository Un objeto que implementa la interfaz IUserRepository
                   para manejar las operaciones de usuario.
     */
    public UserService(IUserRepository repository) {
        this.repository = repository;
    }
       /**
     * Registra un nuevo usuario después de validar todos los campos.
     *
     * @param name        El nombre del usuario.
     * @param lastName    El apellido del usuario.
     * @param email       El email del usuario.
     * @param password    La contraseña del usuario.
     * @param country     El país del usuario.
     * @param organization La organización del usuario.
     * @param Ifields     Otros campos adicionales requeridos.
     * @return true si el usuario fue registrado correctamente, false en caso de error de validación.
     */
    public boolean registerUser(String name, String lastName, String email, String password, String country, String organization, String Ifields) {
        // Validar todos los campos
        if (!validateFields(name, lastName, email, password, country, organization, Ifields) || repository.isEmailRegistered(email)) {
            return false;
        }
        // Crear nuevo usuario
         Usuario newUser = new Usuario(name, lastName, email, password, country, organization, Ifields);
         repository.storeUsuario(newUser);
        // Almacenar el usuario en el repositorio
        return true;
    }
    /**
     * Valida los campos proporcionados para el registro de un usuario.
     *
     * @param name        El nombre del usuario.
     * @param lastName    El apellido del usuario.
     * @param email       El email del usuario.
     * @param password    La contraseña del usuario.
     * @param country     El país del usuario.
     * @param organization La organización del usuario.
     * @param Ifields     Otros campos adicionales requeridos.
     * @return true si todos los campos son válidos, false en caso contrario.
     */
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
     /**
     * Permite que un usuario inicie sesión validando su correo y contraseña.
     *
     * @param correo      El correo electrónico del usuario.
     * @param contrasenia La contraseña del usuario.
     * @return Un objeto Usuario si las credenciales son válidas, null en caso contrario.
     */
   public Usuario login(String correo, String contrasenia){
   
       return repository.login(correo, contrasenia); 
   } 
      /**
     * Obtiene el repositorio de usuarios utilizado por este servicio.
     *
     * @return El repositorio de usuarios.
     */
    public IUserRepository getRepository() {
        return repository;
    }
   
   
}
