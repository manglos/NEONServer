/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package youcanthide;

import java.util.Comparator;

/**
 *
 * @author uman
 */
public class CompairByNumIt implements Comparator<Game>{
    public int compare(Game g1, Game g2) {
        return g1.getNumIt()-g2.getNumIt();
    }   
}