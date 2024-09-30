package com.easyconference.domain.service;

import com.easyconference.domain.entities.Articulo;
import java.util.List;
import com.easyconference.access.Article.IArticleRepository;
import com.easyconference.access.Factory;
import com.easyconference.infra.Subject;

/**
 * Clase ArticleService que gestiona el almacenamiento y la recuperación de artículos. 
 * Esta clase interactúa con un repositorio que implementa la interfaz IArticleRepository.
 * 
 * @author Maria Paula Barrera
 * @author Ashlee Vanessa Campaz
 * @author Monica Alejandra Castellanos
 * @author Karold Dirley Delgado
 * @author William Andres Serna
 * @version 1.0
 * @since 2024
 */
public class ArticleService extends Subject {
    private final IArticleRepository referenciaRepositorioArticulos;
       /**
     * Constructor que recibe un repositorio de artículos.
     * 
     * @param referenciaRepositorioArticulos El repositorio que implementa IArticleRepository.
     */
    public ArticleService(IArticleRepository referenciaRepositorioArticulos) {
        this.referenciaRepositorioArticulos = referenciaRepositorioArticulos;
    }
    
    /**
     * Constructor que recibe un tipo de repositorio y lo obtiene a través de la fábrica.
     * 
     * @param typeRepositoy El tipo de repositorio de artículos.
     */
    public ArticleService(String typeRepositoy) {
        this.referenciaRepositorioArticulos = Factory.getInstance().getArticleRepository(typeRepositoy);
    }
    
    /**
     * Almacena un artículo en el repositorio.
     * 
     * @param objArticulo El artículo que se desea almacenar.
     * @return true si el artículo fue almacenado exitosamente, false en caso contrario.
     */
    public boolean almacenarArticulo(Articulo objArticulo) {
        boolean bandera = this.referenciaRepositorioArticulos.almacenarArticulo(objArticulo);
        return bandera;
    }

    
    /**
     * Lista los artículos almacenados en el repositorio.
     * 
     * @return Una lista de artículos.
     */
    public List<Articulo> listarArticulos() {
        return this.referenciaRepositorioArticulos.listarArticulos();
    }
}
