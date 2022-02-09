

package libreria.servicios;

import java.util.List;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

/**
 *
 * @author Roque
 */
public class AutorService {
    
    private  AutorDAO dao;

    public AutorService() {
        dao = new AutorDAO();
    }
    
    public void crear (String id, String nombre){
        
        Autor autor = new Autor();
        autor.setId(id);
        autor.setNombre(nombre);
        
        dao.guardar(autor);
    }
    
    public Autor buscarPorID(String id){
        return dao.buscarPorID(id);
    }
    
    public void buscarPorNombre(String nombre){
        List<Autor>autores = dao.buscarPorNombre(nombre);
        for (Autor a : autores) {
            System.out.println(a);
        }
        
    }
    
    
    

}
