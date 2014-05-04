/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import youcanthide.Player;

/**
 *
 * @author littleuman
 */
@Stateless
@WebService
public class PersistenceTest {

    @PersistenceContext(name="PLAYERS")
    EntityManager em;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public void create() {
        Player p = new Player("Christopher","Manglos","manglosc","st1ckman", false);
        p.setID(1);
        em.persist(p);
    }
    
    public String retreive(){
        Player p = em.find(Player.class, 1);
        
        return p.getUsername();
    }
}
