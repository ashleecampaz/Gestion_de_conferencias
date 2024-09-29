package co.edu.unicauca.mvc.test;

import co.edu.unicauca.mvc.accesoADatos.RepositorioArticuloMemoriaArrayList;
import co.edu.unicauca.mvc.accesoADatos.RepositorioConferenciaMemoriaArrayList;
import co.edu.unicauca.mvc.controladores.ServicioAlmacenamientoArticulos;
import co.edu.unicauca.mvc.controladores.ServicioAlmacenamientoConferencias;
import co.edu.unicauca.mvc.modelos.Articulo;
import co.edu.unicauca.mvc.modelos.EstadoRevision;
import co.edu.unicauca.mvc.vistas.adminConferencia.VtnPrincipalAdmin;
import co.edu.unicauca.mvc.vistas.articulos.Revisor;
import co.edu.unicauca.mvc.vistas.asistente.VtnPrincipalAsistente;
import co.edu.unicauca.mvc.vistas.autorPublicacion.VtnPrincipalAutor;
import javax.swing.UIManager;



public class Test {

    
    public static void main(String[] args) {
        
        
        seleccionarLookAndField();
                
        RepositorioConferenciaMemoriaArrayList objRepositorio1=
                new RepositorioConferenciaMemoriaArrayList();
        
        ServicioAlmacenamientoConferencias objServicio1
                = new   ServicioAlmacenamientoConferencias(objRepositorio1);  
        
        RepositorioArticuloMemoriaArrayList objRepositorio2=
                new RepositorioArticuloMemoriaArrayList();
        
        ServicioAlmacenamientoArticulos objServicio2
                = new ServicioAlmacenamientoArticulos(objRepositorio2);
        
        Revisor revisor1 = new Revisor("Revisor 1");
        Revisor revisor2 = new Revisor("Revisor 2");
        objServicio2.addObserver(revisor1);
        objServicio2.addObserver(revisor2);
        Articulo articulo1 = new Articulo("Artículo 1", "w");
        Articulo articulo2 = new Articulo("Artículo 2", "s");
        objServicio2.almacenarArticulo(articulo2);
        objServicio2.almacenarArticulo(articulo2);
        objServicio2.cambiarEstadoArticulo("Artículo 1", EstadoRevision.EN_REVISION);
        objServicio2.cambiarEstadoArticulo("Artículo 2", EstadoRevision.REVISADO);
        
        VtnPrincipalAsistente objVtnAsistente=new VtnPrincipalAsistente();
        VtnPrincipalAutor objVtnAutor= new VtnPrincipalAutor();
        
        objServicio1.addObserver(objVtnAsistente);
        objServicio1.addObserver(objVtnAutor);
        
        VtnPrincipalAdmin objVtnPrincipal= new VtnPrincipalAdmin();    
        objVtnPrincipal.asociarServios(objServicio1,objServicio2); 
        
        objVtnPrincipal.setVisible(true);
        objVtnAsistente.setVisible(true);
        objVtnAutor.setVisible(true);
    }
    
    private static void seleccionarLookAndField()
    {
        for(UIManager.LookAndFeelInfo laf:UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(laf.getName()))
                try {
                UIManager.setLookAndFeel(laf.getClassName());
                 } catch (Exception ex) {
            }
        }
    }
    
    
    
}
