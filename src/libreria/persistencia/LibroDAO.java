

package libreria.persistencia;

import java.util.List;
import libreria.entidades.Libro;

/**
 *
 * @author Roque
 */
public final class LibroDAO extends DAO{
    
    public void guardar(Libro objeto){
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    public Libro editar(Libro objeto){
        conectar();
        em.getTransaction().begin();
        Libro libro = em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
        return libro;
        
    }
    
    public void eliminar(Libro objeto){
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
    }
    
    public List<Libro> listarTodos(){
        return em.createQuery("SELECT l FROM Libro l").getResultList();
    }
    
    public Libro buscarPorISBN(String id){
        return em.find(Libro.class, id);
        
    }
    
    public Libro buscarPorTitulo(String titulo){
        return (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo")
                .setParameter("titulo", "%" + titulo + "%")
                .getSingleResult();
    }
        
    
    
    

}
