/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package youcanthide;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author montynewman
 */
public class Frame implements Serializable{
    
    Mesh myMesh;
    long displayTime;
    boolean displaying;
    MeshPoint points[][];
    int height,width;
    
    
    public Frame(MeshPoint p[][], long t){
        points=p;
        height=p.length;
        width=p[0].length;
        displayTime=t;
        displaying=false;
    }
    
    public boolean display(){
        if(myMesh==null){
            System.out.println("No mesh set for frame!");
            return false;
        }
        displaying=true;
        if(myMesh.display(this)){
            try {
                Thread.sleep(displayTime);
                return true;
            } catch (InterruptedException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        return false;
    }
    
    
    public boolean done(){
        return displaying;
    }
    
    public int width(){
        return width;
    }
    
    public int height(){
        return height;
    }
    
}
