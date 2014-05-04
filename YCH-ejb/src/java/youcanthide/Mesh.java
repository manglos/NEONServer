/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package youcanthide;

/**
 *
 * @author montynewman
 */
public class Mesh {
    
    int id;
    public MeshPoint points[][];
    int width, height;
    String username;
    String address;
    
    public Mesh(int x, int y, String a){
        points = new MeshPoint[x][y];
        address=a;
        width=x;
        height=y;
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                points[i][j] = new MeshPoint(i,j);
            }
        }
    }
    
    public Mesh(MeshPoint p[][], String a){
        points = p;
        address=a;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setID(int i){
        id=i;
    }
    
    public void setUser(String un){
        username=un;
    }
    
    public int getID(){
        return id;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public boolean display(Frame f){
        if(f.width()==width && f.height()==height){
            points = f.points;
            return true;
        }
        
        return false;
    }
    
    
}
