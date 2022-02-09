package libreria.servicios;

import java.util.ArrayList;
import java.util.List;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import static libreria.entidades.Libro_.autor;
import libreria.persistencia.LibroDAO;

/**
 *
 * @author Roque
 */
public class LibroService {

    private final EditorialService e;
    private final AutorService a;
    private final LibroDAO dao;

    public LibroService() {
        e = new EditorialService();
        a = new AutorService();
        dao = new LibroDAO();
    }

    public void crear(String isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados,
            Integer ejemplaresRestantes, String idAutor, String idEditorial) {

        Libro libro = new Libro();
        Editorial editorial = e.buscarPorID(idEditorial);
        Autor autor = a.buscarPorID(idAutor);
        List<Autor> autores = new ArrayList();
        List<Editorial> editoriales = new ArrayList();

        autores.add(autor);
        editoriales.add(editorial);

        libro.setId(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setEjemplaresPrestados(ejemplaresPrestados);
        libro.setEjemplaresRestantes(ejemplaresRestantes);
        libro.setAutor(autores);
        libro.setEditorial(editoriales);

        dao.guardar(libro);

    }

    public void mostrarTodos() {
        
        for (Libro objeto : dao.listarTodos()) {
            System.out.println("ISBN: " + objeto.getIsbn() + "\n"
                    + "Título:" + objeto.getTitulo() + "\n"
                    + "Año: " + objeto.getAnio() + "\n"
                    + "Ejemplares: " + objeto.getEjemplares() + "\n"
                    + "Ejemplares Prestados: " + objeto.getEjemplaresPrestados() + "\n"
                    + "Ejemplares Restantes: " + objeto.getEjemplaresRestantes() + "\n"
                    + "Autor:" + objeto.getAutor().get(0).getNombre() + "\n"
                    + "Editorial: " + objeto.getEditorial().get(0).getNombre() + "\n"
                    + "=========================================");
           

        }
    }

    public Libro buscarPorISBN(String id) {
        return dao.buscarPorISBN(id);
    }

    public Libro buscarPorTitulo(String titulo) {
        return dao.buscarPorTitulo(titulo);
    }

}
