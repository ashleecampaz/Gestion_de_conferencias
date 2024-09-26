package com.easyconference.domain.entities;

import java.util.ArrayList;

/**
 *
 * @author sonhuila
 */
public class Articulo {
    private String nombre;
    private ArrayList<String> autores;
    private String resumen;
    private String palabrasClaves;

    public Articulo(String nombre,ArrayList<String> autores, String resumen, String palabrasClaves) {
        this.nombre = nombre;
        this.autores = autores; 
        this.resumen = resumen;
        this.palabrasClaves = palabrasClaves;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }
    
    public void setAutores(ArrayList<String> autores){
        this.autores = autores;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(String palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }    
}
