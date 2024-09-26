package com.easyconference.domain.service;

import com.easyconference.domain.entities.Articulo;
import java.util.List;

/**
 *
 * @author sonhuila
 */
public interface IArticuloService {
    public boolean almacenarArticulo(Articulo objArticulo);
    public List<Articulo> listarArticulos();
}
