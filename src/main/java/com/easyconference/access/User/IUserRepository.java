
package com.easyconference.access.User;
import com.easyconference.domain.entities.Usuario;
import java.util.List;
/**
 * Esta Interfaz contiene metodos para el manejo de usuarios en el login
* @author Maria Paula Barrera
 * @author Ashlee Vanessa Campaz
 * @author Monica Alejandra Castellanos
 * @author Karold Dirley Delgado
 * @author William Andres Serna
 * @version 1.0
 * @since 2024
 * @version 1.0
 * @since 2024
 */
public interface IUserRepository {
    void storeUsuario(Usuario usuario);
    List<Usuario> obtenerRegistros();
    boolean validarNombre(String name);
    boolean validarEmail(String email);
    boolean validarContrasena(String password);
    boolean validarCampo(String Ifield);
    public Usuario login(String correo, String contrasenia); 
    public boolean isEmailRegistered(String correo);
}

