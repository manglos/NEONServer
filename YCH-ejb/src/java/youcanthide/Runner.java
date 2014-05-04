package youcanthide;

import java.io.Serializable;
public class Runner extends Role implements Serializable{

	int numBeenTaggedThisTurn;
	int numBeenTaggedThisGame;
	int xpGained;

	Runner(){
		super();
		setType("Runner");
		numBeenTaggedThisTurn=0;
		numBeenTaggedThisGame=0;
		xpGained=0;
	}
	
	void gameEventHandler(GameEvent e){
		/* Large method with logic for handling any given event
		 * according to player role 'it'
		 */
	}
	
}
