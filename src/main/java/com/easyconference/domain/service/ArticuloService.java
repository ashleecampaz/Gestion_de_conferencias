package com.easyconference.domain.service;

import com.easyconference.domain.entities.Articulo;
import java.util.List;

/**
 *
 * @author sonhuila
 */
public class ArticuloService {
    private IArticuloService referenciaRepositorioArticulos;
    
    public ArticuloService(IArticuloService referenciaRepositorioArticulos) {
        this.referenciaRepositorioArticulos = referenciaRepositorioArticulos;
    }
    
    public boolean almacenarArticulo(Articulo objArticulo) {
        boolean bandera = this.referenciaRepositorioArticulos.almacenarArticulo(objArticulo);
        return bandera;
    }

    public List<Articulo> listarArticulos() {
        return this.referenciaRepositorioArticulos.listarArticulos();
    }
}
