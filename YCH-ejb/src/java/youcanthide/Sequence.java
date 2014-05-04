/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package youcanthide;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author montynewman
 */
public class Sequence implements Serializable{
    
    ArrayList<Frame> frames;
    String name;
    int repeatCount;
    int currentFrame;
    boolean displaying;
    
    public Sequence(String n){
        frames=new ArrayList<Frame>();
        name=n;
        repeatCount=0;
        currentFrame=-1;
    }
    
    public Sequence(String n, int c){
        frames=new ArrayList<Frame>();
        name=n;
        repeatCount=c;
        currentFrame=-1;
    }
    
    public void addFrame(Frame f){
        frames.add(f);
    }
    
    public boolean replaceFrame(int index, Frame f){
        if(frames.get(index)==null)
            return false;
        
        frames.set(index, f);
        return true;
    }
    
    public void play(){
        if(frames.size()==0){
            return;
        }
        
        for(int i=0;i<frames.size();i++){
            Frame f = frames.get(i);
            currentFrame=i;
            if(!f.display()){
                while(!f.done()){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Sequence.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
                
        }
    }
    
    
    public String toString(){
        return "'"+name+"' contains " + frames.size() + " frames.";
    }
    
}
