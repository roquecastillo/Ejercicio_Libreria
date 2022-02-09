

package libreria.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Roque
 */
@Entity
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String isbn;
    private String titulo;
    private Integer anio;
    private Integer ejemplares;
    @Column(name = "EJEMPLARES PRESTADOS")
    private Integer ejemplaresPrestados;
    private Integer ejemplaresRestantes;
    private Boolean alta;
    @ManyToMany
    private List<Autor> autor;
    @ManyToMany
    private List<Editorial> editorial;

    public Libro() {
        alta = true;
        editorial = new ArrayList();
        autor = new ArrayList();
    }

    public Libro(String isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, Boolean alta, List<Autor> autor, List<Editorial> editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.ejemplaresPrestados = ejemplaresPrestados;
        this.ejemplaresRestantes = ejemplaresRestantes;
        this.alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }

    public String getId() {
        return isbn;
    }

    public void setId(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public Integer getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }

    public void setEjemplaresRestantes(Integer ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    public List<Editorial> getEditorial() {
        return editorial;
    }

    public void setEditorial(List<Editorial> editorial) {
        this.editorial = editorial;
    }

    

    @Override
    public String toString() {
        return "ISBN: " + isbn + "\n" 
                + "Título:" + titulo + "\n" 
                + "Año: " + anio + "\n" 
                + "Ejemplares: " + ejemplares + "\n"
                + "Ejemplares Prestados: " + ejemplaresPrestados + "\n"
                + "Ejemplares Restantes: " + ejemplaresRestantes + "\n"
                + "Autor:" + autor + "\n" 
                + "Editorial: " + editorial;
    }
    
    

   

}
