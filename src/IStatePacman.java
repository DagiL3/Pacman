import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

abstract class IStatePacman {
	private Game game;
	private Bord[][] borde;
	private Personage_pacman pacman;
	private Personage_fantome fantome;
	
	public IStatePacman(Game game){
		this.game=game;
		this.pacman=game.getPacman();	
		this.borde=game.getBorde();
	}
	/**
	 * @brief  est responsable du deplacement les 4 fantomes 
	 */
	public void moveFantome(){
		if(pacman.getVie()<=0||game.getNumberPacgammes()<=0){			
			return;
		}else {
			game.verifyTimingState();
			moveFantome1();
			moveFantome2();
			moveFantome3();
			moveFantome4();
		}
	}
	
	/**
	 * @brief  est responsable du deplacement le pacman
	 */
	public void movePacman(){
		if(game.getPacman().getVie()<=0||game.getNumberPacgammes()<=0) {
			return;
		}else {
			game.verifyTimingState();
			int x=game.getPacman().getPosX();
			int y=game.getPacman().getPosY();
			Bord current =game.getCell(x,y);	
			switch(game.mykeybord){
			case KeyEvent.VK_RIGHT:
				moveRight(current);
				break;
			case KeyEvent.VK_LEFT:		
				moveLeft(current);					
				break;
			case KeyEvent.VK_DOWN:    			
				moveDown(current);				 
				break;
			case KeyEvent.VK_UP:					
				moveUp(current);   
				break;
			}
		}
	}
	/**
	 * @brief  est responsable du déplacement le premier fantome
	 */
	private void moveFantome1(){
		Bord b;
		Bord current;	
		int x=game.MyFantome[0].getPosX();
		int y=game.MyFantome[0].getPosY();
		b=game.getCell(x,y);
		current = b;
		int xx=game.posxCenterFantom[0];
		int yy=game.posyCenterFantom[0];		
		Direction diex=game.status;
		if(game.status==Direction.NONE||(x==xx &y==yy))
		{
			diex=game.getRandom();
		}
		switch(diex){   
		case RIGHT:
			game.status=moveRightF(current);
			diex=game.status;
			break;
		case LEFT:			
			game.status=moveLeftF(current);
			diex=game.status;
			break;
		case DOWN:	    	
			game.status=moveDownF(current);				 
			diex=game.status;
			break;
		case UP:					
			game.status=moveUpF(current);
			diex=game.status;
			break;
		}	
	}
	
	/**
	 * @brief  est responsable du déplacement le deuxieme fantome
	 */
	private void moveFantome2(){
		Bord b;
		Bord current;
		int x=game.MyFantome[1].getPosX();
		int y=game.MyFantome[1].getPosY();
		b=game.getCell(x,y);
		int xx=game.posxCenterFantom[1];
		int yy=game.posyCenterFantom[1];
		current = b;
		Direction diex=game.status2;
		if(game.status2==Direction.NONE|| (x==xx && y==yy))
		{
			diex=game.getRandom();
		}
		switch(diex){ 		
		case RIGHT:
			game.status2=moveRightF(current);
			diex=game.status2;
			break;
		case LEFT:			
			game.status2=moveLeftF(current);
			diex=game.status2;
			break;
		case DOWN:	    	
			game.status2=moveDownF(current);				 
			diex=game.status2;
			break;
		case UP:					
			game.status2=moveUpF(current);
			diex=game.status2;
			break;
		}	
	}
 
	/**
	 * @brief  est responsable du déplacement le troisieme  fantome
	 */
	private void moveFantome3(){
		Bord b;
		Bord current;
		int x=game.MyFantome[2].getPosX();
		int y=game.MyFantome[2].getPosY();
		b=game.getCell(x,y);
		current = b;
		int xx=game.posxCenterFantom[2];
		int yy=game.posyCenterFantom[2];
		Direction diex=game.status3;
		if(game.status3==Direction.NONE || (x==xx && y==yy)) {
			diex=game.getRandom();
		}
		switch(diex){
		case RIGHT:
			game.status3=moveRightF(current);
			diex=game.status3;
			break;
		case LEFT:			
			game.status3=moveLeftF(current);
			diex=game.status3;
			break;
		case DOWN:	    	
			game.status3=moveDownF(current);				 
			diex=game.status3;
			break;
		case UP:					
			game.status3=moveUpF(current);
			diex=game.status3;
			break;
		}	
	}

	/**
	 * @brief  est responsable du déplacement le quatrieme  fantome
	 */
	private void moveFantome4(){
		Bord b;
		Bord current;
		int x=game.MyFantome[3].getPosX();
		int y=game.MyFantome[3].getPosY();
		b=game.getCell(x,y);
		current = b;
		int xx=game.posxCenterFantom[3];
		int yy=game.posyCenterFantom[3];
		Direction diex=game.status4;
		if(game.status4==Direction.NONE || (x==xx && y==yy)) {
			diex=game.getRandom();
		}
		switch(diex){	
		case RIGHT:
			game.status4=moveRightF(current);
			diex=game.status4;
			break;
		case LEFT:			
			game.status4=moveLeftF(current);
			diex=game.status4;
			break;
		case DOWN:	    	
			game.status4=moveDownF(current);				 
			diex=game.status4;
			break;
		case UP:					
			game.status4=moveUpF(current);
			diex=game.status4;
			break;
		}	
	}
	
	//abstract void setCouleur();
	abstract void moveLeft(Bord b);
	abstract void moveRight(Bord b);
	abstract void moveDown(Bord b);
	abstract void moveUp(Bord b);
	
	abstract  Direction moveRightF(Bord b);
	abstract  Direction moveLeftF(Bord b);
	abstract  Direction moveDownF(Bord b);
	abstract  Direction moveUpF(Bord b);
 

}