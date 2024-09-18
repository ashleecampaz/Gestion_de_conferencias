package co.edu.unicauca.mvc.modelos;

public class Articulo {
   private int idArticulo;
   private String titulo;
   private String autores;
   
   private Conferencia objConferencia;

   public Articulo()
   {
       
   }
    public Articulo(int idArticulo, String titulo, String autores) {
        this.idArticulo = idArticulo;
        this.titulo = titulo;
        this.autores = autores;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public Conferencia getObjConferencia() {
        return objConferencia;
    }

    public void setObjConferencia(Conferencia objConferencia) {
        this.objConferencia = objConferencia;
    }
   
   
}
