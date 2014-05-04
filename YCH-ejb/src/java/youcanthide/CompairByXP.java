package youcanthide;

import java.util.Comparator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christopher Manglos
 */
public class CompairByXP implements Comparator<Player>{
    public int compare(Player p1, Player p2) {
        return -1;//((Integer)p2.getExperience()).compareTo(p1.getExperience());
    }   
}
