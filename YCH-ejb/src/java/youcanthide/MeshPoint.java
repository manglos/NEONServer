/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package youcanthide;

import java.awt.Color;

/**
 *
 * @author montynewman
 */
public class MeshPoint {
    
    int intensity, xPos, yPos;
    Color color;
    
    public MeshPoint(int x, int y){
        intensity=0;
        xPos=x;
        yPos=y;
        
    }
    
    public MeshPoint(int x, int y, Color c){
        intensity=0;
        xPos=x;
        yPos=y;
        color=c;
    }
    
    public Color getColor(){
        return color;
    }
    
    public void setColor(Color c){
        color=c;
    }
    
    public void setIntensit(int i){
        intensity=i;
    }
    
    public int getX(){
        return xPos;
    }
    
    public int getY(){
        return yPos;
    }
    
    public int getIntensity(){
        return intensity;
    }
    
    public String toString(){
        return "Point (" + xPos + "," + yPos + ") - Intensity="+intensity+" - Color=" + color;
    }
    
}
