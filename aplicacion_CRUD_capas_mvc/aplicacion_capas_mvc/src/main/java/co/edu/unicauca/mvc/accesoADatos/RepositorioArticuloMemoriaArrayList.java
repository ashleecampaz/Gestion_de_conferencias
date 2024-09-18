package co.edu.unicauca.mvc.accesoADatos;

import co.edu.unicauca.mvc.modelos.Articulo;
import java.util.ArrayList;
import java.util.List;

public class RepositorioArticuloMemoriaArrayList implements InterfaceRepositorioArticulo{

    private ArrayList<Articulo> listaDeArticulos;
    
    public RepositorioArticuloMemoriaArrayList()
    {
        this.listaDeArticulos= new ArrayList();
    }
    @Override
    public boolean almacenarArticulo(Articulo objArticulo) {
        objArticulo.setIdArticulo(getCantidadArticulos());
       return this.listaDeArticulos.add(objArticulo);
    }

    @Override
    public List<Articulo> listarArticulos() {
        return this.listaDeArticulos;
    }
    
    private int getCantidadArticulos()
    {
        return this.listaDeArticulos.size()+1;
    }

    @Override
    public boolean eliminarArticulo(int idArticulo) {
        boolean bandera=false;
        for (int i = 0; i < this.listaDeArticulos.size(); i++) {
            if(this.listaDeArticulos.get(i).getIdArticulo()==idArticulo)
            {
                this.listaDeArticulos.remove(i);
                bandera=true;
                break;
            }
        }
        return bandera;
    }

    @Override
    public Articulo consultarArticulo(int idArticulo) {
        Articulo objArticulo=null;
        for (int i = 0; i < this.listaDeArticulos.size(); i++) {
            if(this.listaDeArticulos.get(i).getIdArticulo()==idArticulo)
            {
                objArticulo=this.listaDeArticulos.get(i);
                break;
            }
        }
        
        return objArticulo;
    }

    @Override
    public boolean actualizarArticulo(Articulo objArticulo) {
        boolean bandera=false;
        for (int i = 0; i < this.listaDeArticulos.size(); i++) {
            if(this.listaDeArticulos.get(i).getIdArticulo()==objArticulo.getIdArticulo())
            {
                this.listaDeArticulos.set(i, objArticulo);
                bandera=true;
                break;
            }
        }
        
        return bandera;
    }
}
