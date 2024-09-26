
package com.easyconference.access;
import com.easyconference.domain.entities.Usuario;
import java.util.List;
/**
 * Esta Interfaz contiene metodos para el manejo de usuarios en el login
 * @author 
 * @version 1.0
 * @since 2024
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

