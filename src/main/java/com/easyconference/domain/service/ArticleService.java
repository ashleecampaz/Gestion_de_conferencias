package com.easyconference.domain.service;

import com.easyconference.domain.entities.Articulo;
import java.util.List;
import com.easyconference.access.Article.IArticleRepository;

/**
 *
 * @author sonhuila
 */
public class ArticleService {
    private IArticleRepository referenciaRepositorioArticulos;
    
    public ArticleService(IArticleRepository referenciaRepositorioArticulos) {
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
