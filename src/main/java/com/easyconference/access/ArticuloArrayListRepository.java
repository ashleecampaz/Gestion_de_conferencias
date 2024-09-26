package com.easyconference.access;

import com.easyconference.domain.entities.Articulo;
import com.easyconference.domain.service.IArticuloService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sonhuila
 */
public class ArticuloArrayListRepository implements IArticuloService{
    private ArrayList<Articulo> listaArticulos;

    public ArticuloArrayListRepository() {
        this.listaArticulos = new ArrayList<>();
    }

    @Override
    public boolean almacenarArticulo(Articulo objArticulo) {
        boolean bandera = this.listaArticulos.add(objArticulo);
        return bandera;
    }

    @Override
    public List<Articulo> listarArticulos() {
        return this.listaArticulos;
    }
}
