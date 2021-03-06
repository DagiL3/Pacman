
public  class StateNormal extends IStatePacman {
	private Personage_fantome fantome;
	private Game game;
	
	public StateNormal(Game game){
		super(game);
		this.game=game;
	}

 /********************************pacman*********************************************************************/

	 @Override
	public void moveLeft(Bord b) {
		game.setPacman(b.getPacman());   
		int posx=game.getPacman().getPosX();
		int posy=game.getPacman().getPosY();		
		  int j=posx-1;
		  if(j<0 &&/* posx!=0 &&*/ posy!=0 )return ;
		  if((posx==0&&posy==0)){
			  j=9;
			  posy=0;
		  }
		  if(game.getNumberPacgammes()<=0)return ;
		  if((game.borde[j][posy]).getType()==Element.OBSTACLE){
			  return ;
		  }
		  if((game.borde[j][posy]).getType()!=Element.OBSTACLE){
			  if(game.borde[j][posy].getType()==Element.PACGOMME){
				  game.getPacman().mangePacgomme(game.borde[j][posy].getMyPacgome());
				  game.setNumberPacgammes();	   
			  }else if(game.borde[j][posy].getType()==Element.FANTOME){
				  if((posx==0&&posy==0)){
					  game.borde[j][posy].getFantom1().setPosX(0);		   
				  }else {
					  game.borde[j][posy].getFantom1().setPosX(j+1);
				  }
				  game.getPacman().setVie();
			  }if((posx==0&&posy==0)){
				  game.setCellNull(0,0,game.borde[j][posy]);
				  game.setCell(j,posy,game.getPacman());
				  game.getPacman().setPosX(j);
			  }else {
				  game.setCellNull(j+1,posy,game.borde[j][posy]);
				  game.setCell(j,posy,game.getPacman());
				  game.getPacman().setPosX(j);
			  }
		  }	     
	 }
	
	@Override
	public void  moveRight(Bord b) {
		game.setPacman(b.getPacman());
		int posx=game.getPacman().getPosX();
		int posy=game.getPacman().getPosY();
		int j=posx+1;
		if(j>=game.borde.length /*&& posx!=9 */&& posy!=0 )return ;
		if((posx==9&&posy==0)){
			j=0;
			posy=0;
		}
		
		if((game.borde[j][posy]).getType()==Element.OBSTACLE) {
			return ;
		}
		if((game.borde[j][posy]).getType()!=Element.OBSTACLE){
			if(game.borde[j][posy].getType()==Element.PACGOMME) { 
				game.getPacman().mangePacgomme(game.borde[j][posy].getMyPacgome());
				game.setNumberPacgammes();		  
			}
			else if(game.borde[j][posy].getType()==Element.FANTOME){
				if((posx==9&&posy==0)){
					game.borde[9][posy].getFantom1().setPosX(j-1);
				}else {
					game.borde[j][posy].getFantom1().setPosX(j-1);				  
				}
				game.getPacman().setVie();
			}  
		}	
		if((posx==9&&posy==0)){
			game.setCellNull(9,0,game.borde[0][0]);
			game.setCell(0,0,game.getPacman());
			game.getPacman().setPosX(0);           
		}else {
			game.setCellNull(j-1,posy,game.borde[j][posy]);
			game.setCell(j,posy,game.getPacman());
			game.getPacman().setPosX(j);	
		}	  
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
	
	/********************************fantom*********************************************************************/
	@Override
	public Direction moveRightF(Bord b){	
		fantome=b.getFantom1();
		int posx=fantome.getPosX();
		int posy=fantome.getPosY();	
		int j=posx+1;
		if( j>=game.borde.length)return Direction.NONE; 
		if((game.borde[j][posy]).getType()==Element.OBSTACLE){
			return Direction.NONE; 
		}
		else if((game.borde[j][posy]).getType()!=Element.OBSTACLE){   		
			Bord rec_avanve=game.borde[j][posy]; 	   				
			if(rec_avanve.getType()==Element.PACGOMME){
				game.borde[j][posy].getMyPacgome().setPosX(j-1);
				game.setCellNullF(j-1,posy,rec_avanve);
				fantome.setPosX(j);
				game.setCellF(j,posy,fantome);  					
			}else if(rec_avanve.getType()==Element.FANTOME){
				if((j+1==game.borde.length) || ((game.borde[j+1][posy]).getType()==Element.OBSTACLE)){
					return Direction.NONE;
				}
				game.borde[j][posy].getFantom1().setPosX(j-1);
				game.setCellNullF(j-1,posy,rec_avanve);
				game.setCellF(j,posy,fantome);
				fantome.setPosX(j);
			}else if(rec_avanve.getType()==Element.EMPTY){
				game.setCellNullF(j-1,posy,rec_avanve);
				fantome.setPosX(j);
				game.setCellF(j,posy,fantome);
			}else if(rec_avanve.getType()==Element.PACMAN){
				if(game.mykeybord==0) {
					game.borde[j][posy].getPacman().setVie();
					game.borde[j][posy].getPacman().setPosX(j-1);
					game.setCellNullF(j-1,posy,rec_avanve);
					fantome.setPosX(j);
					game.setCellF(j,posy,fantome);
				}
			}
		}
		return Direction.RIGHT;	
	}
    
	@Override
	public Direction moveLeftF(Bord b){		
		fantome =b.getFantom1();
		int posx=fantome.getPosX();
		int posy=fantome.getPosY();	
		int j=posx-1;
		if(j<0)return Direction.NONE;	
		else if((game.borde[j][posy]).getType()==Element.OBSTACLE) {
			return Direction.NONE;/*(getCell(fantome.getPosX(),fantome.getPosY()));*/
		}
		else{		 
			Bord rec_anvance=game.borde[j][posy]; 			
			if(rec_anvance.getType()==Element.PACGOMME) {
				game.borde[j][posy].getMyPacgome().setPosX(j+1);
				game.setCellNullF(j+1,posy,rec_anvance); 
				fantome.setPosX(j);
				game.setCellF(j,posy,fantome);
			}else if(rec_anvance.getType()==Element.FANTOME) {	
				if((j-1==-1) || ((game.borde[j-1][posy]).getType()==Element.OBSTACLE)) {
					return Direction.NONE;
				}
				game.borde[j][posy].getFantom1().setPosX(j+1);
				game.setCellNullF(j+1,posy,rec_anvance); 
				game.setCellF(j,posy,fantome);		
				fantome.setPosX(j);
			}
			else if(rec_anvance.getType()==Element.EMPTY) {
				//borde[j][posy].getFantom1().setPosX(j+1);
				game.setCellNullF(j+1,posy,rec_anvance); 
				fantome.setPosX(j);
				game.setCellF(j,posy,fantome);		
			}else if(rec_anvance.getType()==Element.PACMAN) {
				if(game.mykeybord==0) {
				game.borde[j][posy].getPacman().setVie();
				game.borde[j][posy].getPacman().setPosX(j+1);
				game.setCellNullF(j+1,posy,rec_anvance); 
				fantome.setPosX(j);
				game.setCellF(j,posy,fantome);
				}
			}			
		}	   
		return Direction.LEFT;
	}
	
	@Override
	public  Direction moveDownF(Bord b){		          
		fantome =b.getFantom1();
		int posx=fantome.getPosX();
		int posy=fantome.getPosY();			 
		int i=posy+1;
		if(i>=game.borde.length)return Direction.NONE;
		if((game.borde[posx][i]).getType()==Element.OBSTACLE) {
			return Direction.NONE; 
		}
		else{				
			Bord rec_avence=game.borde[posx][i];
			if(rec_avence.getType()==Element.PACGOMME) {
				game.borde[posx][i].getMyPacgome().setPosY(i-1);
				game.setCellNullF(posx,i-1,rec_avence);
				fantome.setPosY(i);	   
				game.setCellF(posx,i,fantome);
			}else if(rec_avence.getType()==Element.FANTOME) {
				if((i+1==game.borde.length) || ((game.borde[posx][i+1]).getType()==Element.OBSTACLE)) {
					return Direction.NONE;
				}
				game.borde[posx][i].getFantom1().setPosY(i-1);
				game.setCellNullF(posx,i-1,rec_avence);
				fantome.setPosY(i);	   
				game.setCellF(posx,i,fantome);	
			}else if(rec_avence.getType()==Element.EMPTY) {
				game.setCellNullF(posx,i-1,rec_avence);	 
				game.setCellF(posx,i,fantome);	
				fantome.setPosY(i);	  
			}else if(rec_avence.getType()==Element.PACMAN) {
				if(game.mykeybord==0){
					game.borde[posx][i].getPacman().setVie();
					game.borde[posx][i].getPacman().setPosY(i-1);
					game.setCellNullF(posx,i-1,rec_avence);
					fantome.setPosY(i);	   
					game.setCellF(posx,i,fantome);
				}
			}		
			return Direction.DOWN;
		} 	
	}
	
	@Override
	public  Direction moveUpF(Bord b){		
		fantome =b.getFantom1();
		int posx=fantome.getPosX();
		int posy=fantome.getPosY();			 
		int i=posy-1;
		if(i<0)return Direction.NONE;
		if((game.borde[posx][i]).getType()==Element.OBSTACLE){
			return Direction.NONE; 
		}
		else {
			Bord rec_avence=game.borde[posx][i];
			if(rec_avence.getType()==Element.PACGOMME)
			{
				game.borde[posx][i].getMyPacgome().setPosY(i+1);
				game.setCellNullF(posx,i+1,rec_avence);	
				fantome.setPosY(i);
				game.setCellF(posx,i,fantome);
			}else if(rec_avence.getType()==Element.FANTOME) {
				if((i-1==-1) || ((game.borde[posx][i-1]).getType()==Element.OBSTACLE)) {	
					return Direction.NONE;
				}
				game.borde[posx][i].getFantom1().setPosY(i+1);
				game.setCellNullF(posx,i+1,rec_avence);		
				game.setCellF(posx,i,fantome);
				fantome.setPosY(i);
			}else if(rec_avence.getType()==Element.EMPTY) {
				game.setCellNullF(posx,i+1,rec_avence);	
				fantome.setPosY(i);
				game.setCellF(posx,i,fantome);								
			}else if(rec_avence.getType()==Element.PACMAN) {
				if(game.mykeybord==0) {
					game.borde[posx][i].getPacman().setVie();
					game.borde[posx][i].getPacman().setPosY(i+1);
					game.setCellNullF(posx,i+1,rec_avence);	
					fantome.setPosY(i);
					game.setCellF(posx,i,fantome);
				}
			}
			return Direction.UP;
		}
	}

}
