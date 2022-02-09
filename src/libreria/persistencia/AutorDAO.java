

package libreria.persistencia;

import java.util.List;
import libreria.entidades.Autor;

/**
 *
 * @author Roque
 */
public final class AutorDAO extends DAO{
    
    public void guardar(Autor objeto){
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    public Autor editar(Autor objeto){
        conectar();
        em.getTransaction().begin();
        Autor libro = em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
        return libro;
        
    }
    
    public void eliminar(Autor objeto){
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
    }
    
    public Autor buscarPorID(String id){
        return em.find(Autor.class, id);
    }
    
    public List<Autor>buscarPorNombre(String nombre){
        
        return (List<Autor>) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                .setParameter("nombre", "%" + nombre + "%")
                .getResultList();
        
    }

}
