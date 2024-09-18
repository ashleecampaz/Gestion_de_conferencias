package co.edu.unicauca.mvc.modelos;

import java.util.Date;

public class Conferencia {
    private int idConferencia;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;   
    private float costoInscripcion;

    public Conferencia(String nombre, Date fechaInicio, Date fechaFin, float costoInscripcion) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;        
        this.costoInscripcion = costoInscripcion;
    }

    public int getIdConferencia() {
        return idConferencia;
    }

    public void setIdConferencia(int idConferencia) {
        this.idConferencia = idConferencia;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }


    public float getCostoInscripcion() {
        return costoInscripcion;
    }

    public void setCostoInscripcion(float costoInscripcion) {
        this.costoInscripcion = costoInscripcion;
    }
    
    @Override
    public String toString()
    {
        return this.nombre;
    }
}
