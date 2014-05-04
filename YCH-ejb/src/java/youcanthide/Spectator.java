package youcanthide;

import java.io.Serializable;
public class Spectator extends Role implements Serializable{

	Spectator(){
		super();
		setType("Spectator");
	}
	
	void gameEventHandler(GameEvent e){
		/* Large method with logic for handling any given event
		 * according to player role 'it'
		 */
	}

}
