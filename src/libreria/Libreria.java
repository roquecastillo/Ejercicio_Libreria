
package libreria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.servicios.AutorService;
import libreria.servicios.EditorialService;
import libreria.servicios.LibroService;


public class Libreria {

   
    public static void main(String[] args) {
        
         try {
            EntityManagerFactory EMF = Persistence.createEntityManagerFactory("LibreriaPU");
            EntityManager em = EMF.createEntityManager();

      } catch (Exception ex) {
          System.out.println(ex.getMessage());
       }
        
        LibroService lS = new LibroService();
        AutorService aS = new AutorService();
        EditorialService eS = new EditorialService();
        
        //aS.crear("2", "Dante Alighieri");
        //eS.crear("2", "Oceano");
        
       // lS.crear("33", "La Divina Comedia", 1472, 1, 0, 1, "2", "2");
        //lS.crear("332", "Recuerdos que mienten un poco", 2019, 2, 0, 2, "1", "1");
        
    // aS.buscarPorNombre("Dante Alighieri");
    
       // System.out.println(lS.buscarPorISBN("332"));
     
       // System.out.println(lS.buscarPorTitulo("Recuerdos que mienten un poco"));
       
        //for (String objt : args) {
           lS.mostrarTodos();
       // }

       //aS.buscarPorNombre("Recuerdos que mienten un poco");
       
    }
    
}
