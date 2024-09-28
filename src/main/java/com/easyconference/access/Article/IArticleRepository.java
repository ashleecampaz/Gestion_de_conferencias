package com.easyconference.access.Article;

import com.easyconference.domain.entities.Articulo;
import java.util.List;

/**
 *
 * @author sonhuila
 */
public interface IArticleRepository {
    public boolean almacenarArticulo(Articulo objArticulo);
    public List<Articulo> listarArticulos();
}
