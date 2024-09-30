package com.easyconference.access.Article;

import com.easyconference.domain.entities.Articulo;
import java.util.List;

/**
 * Interfaz IArticleRepository que define los métodos para manejar
 * el almacenamiento y la recuperación de artículos.
 * 
 * @author Maria Paula Barrera
 * @author Ashlee Vanessa Campaz
 * @author Monica Alejandra Castellanos
 * @author Karold Dirley Delgado
 * @author William Andres Serna
 * @version 1.0
 * @since 2024
 */
public interface IArticleRepository {
    public boolean almacenarArticulo(Articulo objArticulo);
    public List<Articulo> listarArticulos();
}
