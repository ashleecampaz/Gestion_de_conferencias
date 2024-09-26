package com.easyconference.access;

import com.easyconference.domain.entities.Articulo;
import com.easyconference.domain.service.IArticuloService;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author sonhuila
 */
public class ArticuloLinkedListRepository implements IArticuloService{
    private LinkedList<Articulo> listaArticulos;
    
    public ArticuloLinkedListRepository()
    {
        this.listaArticulos= new LinkedList();
    }
    
    @Override
    public boolean almacenarArticulo(Articulo objArticulo) {
        boolean bandera=this.listaArticulos.add(objArticulo);
        return bandera;
    }

    @Override
    public List<Articulo> listarArticulos() {
        return this.listaArticulos;
    }
}
