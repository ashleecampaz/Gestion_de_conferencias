package co.edu.unicauca.mvc.accesoADatos;

import co.edu.unicauca.mvc.modelos.Articulo;
import java.util.List;

public interface InterfaceRepositorioArticulo {
    public boolean almacenarArticulo(Articulo objArticulo);
    public List<Articulo> listarArticulos();
    public boolean eliminarArticulo(int idArticulo);
    public Articulo consultarArticulo(int idArticulo);
    public boolean actualizarArticulo(Articulo objArticulo);
}
