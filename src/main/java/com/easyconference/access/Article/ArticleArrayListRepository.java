package com.easyconference.access.Article;

import com.easyconference.domain.entities.Articulo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sonhuila
 */
public class ArticleArrayListRepository implements IArticleRepository{
    private ArrayList<Articulo> listaArticulos;

    public ArticleArrayListRepository() {
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
