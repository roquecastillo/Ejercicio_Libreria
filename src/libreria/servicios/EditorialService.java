

package libreria.servicios;

import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

/**
 *
 * @author Roque
 */
public class EditorialService {
    
    private final EditorialDAO dao;

    public EditorialService() {
        dao = new EditorialDAO();
    }
    
    
    
    public void crear(String id, String nombre){
        
        Editorial editorial = new Editorial();
        
        editorial.setId(id);
        editorial.setNombre(nombre);
        
        dao.guardar(editorial);
    }
    
  public Editorial buscarPorID(String id){
      return dao.buscarPorID(id);
      
  }

}
