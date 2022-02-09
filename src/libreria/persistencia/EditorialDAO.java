

package libreria.persistencia;

import libreria.entidades.Editorial;

/**
 *
 * @author Roque
 */
public final class EditorialDAO extends DAO{
    
    public void guardar(Editorial objeto){
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    public Editorial editar(Editorial objeto){
        conectar();
        em.getTransaction().begin();
        Editorial libro = em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
        return libro;
        
    }
    
    public void eliminar(Editorial objeto){
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
    }
    
      public Editorial buscarPorID(String id){
        return em.find(Editorial.class, id);
        
    }

}
