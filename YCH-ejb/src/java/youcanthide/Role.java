package youcanthide;
import java.io.Serializable;
public abstract class Role implements Serializable{
	String type="";
	
	Role(){}
	Role(String r){
		type=r;
	}
	
	public void setType(String t){
		type=t;
	}
	public String getType(){
		return type;
	}
	
	abstract void gameEventHandler(GameEvent e);
	
	public String toString(){
		return type;
	}

}
