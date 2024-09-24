package com.easyconference.access;

import com.easyconference.domain.service.IConferenceService;
import com.easyconference.domain.entities.Conference;
import com.easyconference.domain.entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class ConferenciaArrayListRepository implements IConferenceService, IUserService{

    private ArrayList<Conference> listConference;
    private List<Usuario> usuarios; 
   
    public ConferenciaArrayListRepository()
    {
        this.listConference= new ArrayList();
        this.usuarios = new ArrayList();
    }
    

    @Override
    public boolean storeConference(Conference objConference) {
        boolean bandera=this.listConference.add(objConference);
        return bandera;
    }

    @Override
    public List<Conference> listConference() {
        return this.listConference;
    }

    public List<Usuario> listUsuario() {
        return this.usuarios;
    }

    // Método para agregar un nuevo usuario
    public boolean agregarUsuario(Usuario usuario) {
        if (isEmailRegistered(usuario.getEmail())) {
            return false; // Si el email ya está registrado, no agrega el usuario
        }
        usuarios.add(usuario);
        return true;
    }
    public List<Usuario> usuarios() {
        return usuarios;
    }
    // Verificar si un email ya está registrado
    @Override
    public boolean isEmailRegistered(String email) {
        for (Usuario user : usuarios) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean validarNombre(String name) {
        return name != null && !name.trim().isEmpty() && name.matches("^[a-zA-Z\\s]+$");
    }

    @Override
    public boolean validarEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return email != null && pattern.matcher(email).matches();
    }

    @Override
    public boolean validarContrasena(String password) {
        return password != null && password.length() >= 8;
    }

    @Override
    public boolean validarCampo(String Ifield) {
        return Ifield != null && !Ifield.trim().isEmpty();
    }

    @Override
    public void storeUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public List<Usuario> obtenerRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Usuario login(String correo, String contrasenia) {
       for (Usuario u: usuarios ){
            if(u.getEmail().equals(correo)){
                if(u.getPassword().equals(contrasenia)){
                    return u;
                }
                break;
            }
       }
       return null; 
    }
    
}
