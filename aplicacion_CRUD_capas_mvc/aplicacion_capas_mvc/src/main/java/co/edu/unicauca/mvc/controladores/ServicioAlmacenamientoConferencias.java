package co.edu.unicauca.mvc.controladores;

import co.edu.unicauca.mvc.accesoADatos.InterfaceRepositorioConferencia;
import co.edu.unicauca.mvc.infraestructura.Subject;
import java.util.List;
import co.edu.unicauca.mvc.modelos.Conferencia;


public class ServicioAlmacenamientoConferencias extends Subject{
    
    private InterfaceRepositorioConferencia referenciaRepositorioConferencias;
    
    public ServicioAlmacenamientoConferencias(InterfaceRepositorioConferencia referenciaRepositorioConferencias)
    {
        this.referenciaRepositorioConferencias=referenciaRepositorioConferencias;
    }
    
    public boolean almacenarConferencia(Conferencia objConfererencia) {
        boolean bandera=this.referenciaRepositorioConferencias.almacenarConferencia(objConfererencia);
        this.notifyAllObserves();
        return bandera;
    }

   
    public List<Conferencia> listarConferencias() {
        return this.referenciaRepositorioConferencias.listarConferencias();
    }
}
