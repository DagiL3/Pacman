
public class StateSuperPacman extends IStatePacman{

	private Game game;
	public StateSuperPacman(Game game){
		super(game);
		this.game=game;
		
	}
	
	 @Override
	void setCouleur(){
	    	game.getPacman().setColor(8);
	  }
	@Override
	public void moveLeft(Bord b) { 
		game.setPacman(b.getPacman());   
		  int posx=game.getPacman().getPosX();
		  int posy=game.getPacman().getPosY();			   
		  int j=posx-1;
		  if(j<0)return;
		  if(game.getNumberPacgammes()<=0)return ;
		  if((game.borde[j][posy]).getType()==Element.OBSTACLE){
			  return ;
		  }
		  if((game.borde[j][posy]).getType()!=Element.OBSTACLE){
			  if(game.borde[j][posy].getType()==Element.PACGOMME){
				   game.getPacman().mangePacgomme(game.borde[j][posy].getMyPacgome());
				  game.setNumberPacgammes();	   
			  }else if(game.borde[j][posy].getType()==Element.FANTOME){
					   game.getPacman().setVie();
					   game.FantomeToCentre(0);
						 return ;
			  }
			  game.setCellNull(j+1,posy,game.borde[j][posy]);
			  game.setCell(j,posy,game.getPacman());
			  game.getPacman().setPosX(j);			 		   
		  }	  
		  return;  
	 }
	
	@Override
	public void moveRight(Bord b) {
		 game.setPacman(b.getPacman());
		  //  if(pacman.getVie()<=0||getNumberPacgammes()<=0)System.out.print("game Over");
		  int posx=game.getPacman().getPosX();
		  int posy=game.getPacman().getPosY();
		  int j=posx+1;
		  if(j>=game.borde.length)return ;
		  //if (getNumberPacgammes()==0);
		  if((game.borde[j][posy]).getType()==Element.OBSTACLE) {
			  return ;
		  }
		  if((game.borde[j][posy]).getType()!=Element.OBSTACLE){
			  if(game.borde[j][posy].getType()==Element.PACGOMME) { 
				  game.getPacman().mangePacgomme(game.borde[j][posy].getMyPacgome());
				  game.setNumberPacgammes();		  
			  }
			  else if(game.borde[j][posy].getType()==Element.FANTOME){
					  game.getPacman().setVie();
					  game.FantomeToCentre(1);
						 return ;
			  }  
		  }
		  game.setCellNull(j-1,posy,game.borde[j][posy]);
		  game.setCell(j,posy,game.getPacman());
		  game.getPacman().setPosX(j);			   
		  return;
	 }
	
	@Override
	public void moveDown(Bord b){
		  game.setPacman(b.getPacman());
		  int posx=game.getPacman().getPosX();
		  int posy=game.getPacman().getPosY();
		  int i=posy+1;
		  if(i>=game.borde.length)return ;
		  if (game.getNumberPacgammes()==0)return ;
		  if((game.borde[posx][i]).getType()==Element.OBSTACLE){
			  return ;
		  }
		  if((game.borde[posx][i]).getType()!=Element.OBSTACLE){
			  if(game.borde[posx][i].getType()==Element.PACGOMME) {
				  game.getPacman().mangePacgomme(game.borde[posx][i].getMyPacgome());
				  game.setNumberPacgammes();
			  }else if(game.borde[posx][i].getType()==Element.FANTOME){
					  game.getPacman().setVie();	
					  game.FantomeToCentre(2);
						 return ;
			  }		 
			  game.setCellNull(posx,i-1,game.borde[posx][i]);	   
			  game.setCell(posx,i,game.getPacman());
			  game.getPacman().setPosY(i);		  
		  } 
		  return;
	 }
	
	@Override
	public void moveUp(Bord b) {    
		  game.setPacman(b.getPacman());
		  //if(pacman.getVie()<=0||getNumberPacgammes()<=0)System.out.print("game Over");
		  int posx=game.getPacman().getPosX();
		  int posy=game.getPacman().getPosY();			 
		  int i=posy-1;
		  if(i<0)return ;
		  if (game.getNumberPacgammes()==0)return ;
		  if((game.borde[posx][i]).getType()==Element.OBSTACLE){
			  return ;
		  }
		  if((game.borde[posx][i]).getType()!=Element.OBSTACLE){
			  if(game.borde[posx][i].getType()==Element.PACGOMME) {
				  game.getPacman().mangePacgomme(game.borde[posx][i].getMyPacgome());
				  game.setNumberPacgammes();	  
			  }else if(game.borde[posx][i].getType()==Element.FANTOME){ 
					  game.getPacman().setVie();
					  game.FantomeToCentre(3);
						 return ;
			  }
			  game.setCellNull(posx,i+1,game.borde[posx][i]);
			  game.setCell(posx,i,game.getPacman());
			  game.getPacman().setPosY(i);
		  }  
		  return;
	 }
	


}
