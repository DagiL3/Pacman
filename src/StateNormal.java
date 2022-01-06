
public  class StateNormal extends IStatePacman {
	
	private Game game;
	public StateNormal(Game game){
		super(game);
		this.game=game;
		
	}
	
	 @Override
	void setCouleur(){
	    	game.getPacman().setColor(1);
	  }
	 
	@Override
	public void moveLeft(Bord b) {
		game.setPacman(b.getPacman());   
		  int posx=game.getPacman().getPosX();
		  int posy=game.getPacman().getPosY();			   
		  int j=posx-1;
		  if(j<0)return ;
		  if(game.getNumberPacgammes()<=0)return ;
		  if((game.borde[j][posy]).getType()==Element.OBSTACLE){
			  return ;
		  }
		  if((game.borde[j][posy]).getType()!=Element.OBSTACLE){
			  if(game.borde[j][posy].getType()==Element.PACGOMME){
				   game.getPacman().mangePacgomme(game.borde[j][posy].getMyPacgome());
				  game.setNumberPacgammes();	   
			  }else if(game.borde[j][posy].getType()==Element.FANTOME){
					   game.borde[j][posy].getFantom1().setPosX(j+1);
					   game.getPacman().setVie();
			  }
			  game.setCellNull(j+1,posy,game.borde[j][posy]);
			  game.setCell(j,posy,game.getPacman());
			  game.getPacman().setPosX(j);			 		   
		  }	  
		   
	 }
	
	@Override
	public void  moveRight(Bord b) {
		 game.setPacman(b.getPacman());
		  //  if(game.getPacman().getVie()<=0||getNumberPacgammes()<=0)System.out.print("game Over");
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
				  game.borde[j][posy].getFantom1().setPosX(j-1);
					  game.getPacman().setVie();
			  }  
		  }
		  game.setCellNull(j-1,posy,game.borde[j][posy]);
		  game.setCell(j,posy,game.getPacman());
		  game.getPacman().setPosX(j);			   
		  
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
					  game.borde[posx][i].getFantom1().setPosY(i-1);
			  }		 
			  game.setCellNull(posx,i-1,game.borde[posx][i]);	   
			  game.setCell(posx,i,game.getPacman());
			  game.getPacman().setPosY(i);		  
		  } 
		 
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
					  game.borde[posx][i].getFantom1().setPosY(i+1);
			  }
			  game.setCellNull(posx,i+1,game.borde[posx][i]);
			  game.setCell(posx,i,game.getPacman());
			  game.getPacman().setPosY(i);
		  }  
		 
	 }
	
	
}
