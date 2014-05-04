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
public class Playlist implements Serializable{
    
    ArrayList<Sequence> sequences;
    String name;
    int repeatCount;
    int currentSequence;
    
    public Playlist(String n){
        sequences=new ArrayList<Sequence>();
        name=n;
        repeatCount=-1;
    }
    
    public Playlist(String n, int c){
        sequences=new ArrayList<Sequence>();
        name=n;
        repeatCount=c;
    }
    
    public void play(){
        if(sequences.size()==0){
            return;
        }
        
        for(int i=0;i<sequences.size();i++){
            Sequence s = sequences.get(i);
            currentSequence=i;
            s.play();
                
        }
    }
    
}
