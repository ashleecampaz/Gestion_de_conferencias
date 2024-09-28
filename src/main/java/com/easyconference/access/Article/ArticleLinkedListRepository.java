package com.easyconference.access.Article;

import com.easyconference.domain.entities.Articulo;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author sonhuila
 */
public class ArticleLinkedListRepository implements IArticleRepository{
    private LinkedList<Articulo> listaArticulos;
    
    public ArticleLinkedListRepository()
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
