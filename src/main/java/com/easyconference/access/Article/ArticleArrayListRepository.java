package com.easyconference.access.Article;

import com.easyconference.domain.entities.Articulo;
import java.util.ArrayList;
import java.util.List;
/**
 * Esta clase implementa un repositorio de artículos utilizando una ArrayList para 
 * almacenar y gestionar objetos de tipo Articulo.
 * 
 * @author Maria Paula Barrera
 * @author Ashlee Vanessa Campaz
 * @author Monica Alejandra Castellanos
 * @author Karold Dirley Delgado
 * @author William Andres Serna
 * @version 1.0
 * @since 2024
 */
public class ArticleArrayListRepository implements IArticleRepository{
    private ArrayList<Articulo> listaArticulos;

    
    
    
     /**
     * Constructor que inicializa la lista de artículos como una ArrayList vacía.
     */
    public ArticleArrayListRepository() {
        this.listaArticulos = new ArrayList<>();
    }
    
     /**
     * Almacena un artículo en la lista.
     *
     * @param objArticulo El artículo que se desea almacenar.
     * @return true si el artículo fue almacenado correctamente, false en caso contrario.
     */

    @Override
    public boolean almacenarArticulo(Articulo objArticulo) {
        boolean bandera = this.listaArticulos.add(objArticulo);
        return bandera;
    }

     /**
     * Retorna una lista de todos los artículos almacenados.
     *
     * @return Una lista de objetos Articulo.
     */
    @Override
    public List<Articulo> listarArticulos() {
        return this.listaArticulos;
    }
}
