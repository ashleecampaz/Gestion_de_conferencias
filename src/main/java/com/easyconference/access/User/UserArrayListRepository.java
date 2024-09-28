/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.easyconference.access.User;

import com.easyconference.domain.entities.Conference;
import com.easyconference.domain.entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Personal
 */
public class UserArrayListRepository implements IUserRepository {
    private ArrayList<Usuario> usuarios;

    public UserArrayListRepository() {
        this.usuarios = new ArrayList();
    }
    
      /**
     * Retorna la lista de usuarios almacenados.
     *
     * @return Una lista de usuarios.
     */
    public List<Usuario> listUsuario() {
        return this.usuarios;
    }
    /**
     * Agrega un nuevo usuario al repositorio si su email no está registrado.
     *
     * @param usuario El usuario a agregar.
     * @return true si el usuario fue agregado, false si el email ya estaba registrado.
     */
    public boolean agregarUsuario(Usuario usuario) {
        if (isEmailRegistered(usuario.getEmail())) {
            return false; // Si el email ya está registrado, no agrega el usuario.
        }
        usuarios.add(usuario);
        return true;
    }

    /**
     * Verifica si un email ya está registrado en el repositorio.
     *
     * @param email El email a verificar.
     * @return true si el email ya está registrado, false en caso contrario.
     */
    @Override
    public boolean isEmailRegistered(String email) {
        for (Usuario user : usuarios) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Valida que el nombre no sea nulo y que contenga solo letras y espacios.
     *
     * @param name El nombre a validar.
     * @return true si el nombre es válido, false en caso contrario.
     */
    @Override
    public boolean validarNombre(String name) {
        return name != null && !name.trim().isEmpty() && name.matches("^[a-zA-Z\\s]+$");
    }

    /**
     * Valida si el email tiene un formato correcto.
     *
     * @param email El email a validar.
     * @return true si el email tiene un formato válido, false en caso contrario.
     */
    @Override
    public boolean validarEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return email != null && pattern.matcher(email).matches();
    }

    /**
     * Valida si la contraseña cumple con el requisito mínimo de longitud (8 caracteres).
     *
     * @param password La contraseña a validar.
     * @return true si la contraseña es válida, false en caso contrario.
     */
    @Override
    public boolean validarContrasena(String password) {
        return password != null && password.length() >= 8;
    }

    /**
     * Valida si un campo de texto no es nulo y no está vacío.
     *
     * @param Ifield El campo a validar.
     * @return true si el campo es válido, false en caso contrario.
     */
    @Override
    public boolean validarCampo(String Ifield) {
        return Ifield != null && !Ifield.trim().isEmpty();
    }

    /**
     * Almacena un nuevo usuario en el repositorio.
     *
     * @param usuario El usuario a almacenar.
     */
    @Override
    public void storeUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    /**
     * Lanza una excepción de operación no soportada al intentar obtener los registros de usuarios.
     *
     * @return No retorna, lanza una excepción.
     * @throws UnsupportedOperationException Si se intenta invocar el método.
     */
    @Override
    public List<Usuario> obtenerRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    /**
     * Permite que un usuario inicie sesión validando su email y contraseña.
     *
     * @param correo El correo electrónico del usuario.
     * @param contrasenia La contraseña del usuario.
     * @return El usuario si las credenciales son válidas, null en caso contrario.
     */
    @Override
    public Usuario login(String correo, String contrasenia) {
       for (Usuario u : usuarios) {
            if (u.getEmail().equals(correo)) {
                if (u.getPassword().equals(contrasenia)) {
                    return u;
                }
                break;
            }
       }
       return null;
    }
   
    
}
