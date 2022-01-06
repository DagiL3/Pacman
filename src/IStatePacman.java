import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

abstract class IStatePacman {
	private Game game;
	private Bord[][] borde;
	private Personage_pacman pacman;
	
	public IStatePacman(Game game){
		this.game=game;
		this.pacman=game.getPacman();
		this.borde=game.getBorde();
	}
	public void movePacman(){
	  if(game.getPacman().getVie()<=0||game.getNumberPacgammes()<=0) {
		  return;
		
	  }else {
		  int x=game.getPacman().getPosX();
		  int y=game.getPacman().getPosY();
		  Bord current =game.getCell(x,y);	
		  /*Direction direction = game.StatusPacman;
		  if(game.StatusPacman==Direction.NONE){
			  direction=game.getRandomp();
		  }*/
		  //System.out.println(x+" "+y+" "+direction);
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

	abstract void setCouleur();
	abstract void moveLeft(Bord b);
	abstract void moveRight(Bord b);
	abstract void moveDown(Bord b);
	abstract void moveUp(Bord b);
	
 

}