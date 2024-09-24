/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.easyconference.access;
import com.easyconference.domain.entities.Usuario;
import java.util.List;
/**
 *
 * @author Karol
 */
public interface IUserService {
    void storeUsuario(Usuario usuario);
    List<Usuario> obtenerRegistros();
    boolean validarNombre(String name);
    boolean validarEmail(String email);
    boolean validarContrasena(String password);
    boolean validarCampo(String Ifield);
    public Usuario login(String correo, String contrasenia); 
    public boolean isEmailRegistered(String correo);
}

