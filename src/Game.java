import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

	public class  Game {
	
		Bord[][] borde;
		private static int numberPacgammes =0; //100 food 
		private Bord bloc =new Bord(new Obstacle());
		private Personage_pacman pacman;
		Direction status =Direction.LEFT;
		Direction status2 =Direction.LEFT;
		Direction status3=Direction.LEFT;
		Direction status4=Direction.LEFT;
		Personage_fantome[] MyFantome=new Personage_fantome[4];
		Personage_fantome fantome;
		//private Movement action;
  
		static int index=0 ;
		//initiale direction 
		private List<Integer> colors =new ArrayList<>();
		private int[] posxCenterFantom= {1,2,1,2};
		private int[] posyCenterFantom= {4,4,5,5};
		private Direction StatusPacman=Direction.RIGHT;
		static Direction choisi=Direction.LEFT;  
		
	
		static List<Direction> direction=new ArrayList<>();
		
		static List<Direction> direction1=new ArrayList<>();
		static List<Direction> transition=new ArrayList<>();
		static List<Direction> direction2=new ArrayList<>();
		
       
   
		private void createListRandom() { 		
			direction.add(Direction.DOWN);
			direction.add(Direction.LEFT);
			direction.add(Direction.RIGHT);
			direction.add(Direction.UP);
			
			
			direction1.add(Direction.DOWN);
			direction1.add(Direction.LEFT);
			direction1.add(Direction.RIGHT);
			direction1.add(Direction.UP);
			
		}
		public	void Mycolors() {
			colors.add(1);
			colors.add(2);colors.add(3);colors.add(4);
		}
		public Game(){
			createListRandom();
			this.borde= new Bord[10][10];
			addbloc();
			addElementToBored();	  
			Mycolors();
		}
		
		public Bord getCell(int posX,int posY){

			return borde[posX][posY];
		}
		public Personage_pacman getPacman(){
			return pacman;
		}
		/**
		 * copie b to the positin (posx,posy) 
		 * if b is pacgomme then (x,y) become Empty
		 * if b is fantome then (x,y) become famtom
		 * */
		public void setCellNull(int posX,int posY,Bord b){
			if(b.getType()==Element.OBSTACLE)return;
			if(b.getType()==Element.PACGOMME||b.getType()==Element.EMPTY) {
				borde[posX][posY].setType(Element.EMPTY);
			}else if(b.getType()==Element.FANTOME){
				borde[posX][posY].setType(Element.FANTOME);
				borde[posX][posY].setFantom1(b.getFantom1());
			}   
		}
		/**
		 *  copie pacman to the positin (posx,posy) 
		 **/
 
		public void setCell(int posX,int posY,Personage_pacman pacman){
			borde[posX][posY].setType((Element) pacman.getType());
			borde[posX][posY].setPacman(pacman);
		}
		
		/**
		 * copie b to the positin (posx,posy) 

		 * if b is pacgomme then (x,y) become pacgomme
		 * if b is fantome then (x,y) become famtom
		 * */
		public void  setCellNullF(int posX,int posY, Bord b){
			if(b.getType()==Element.OBSTACLE)return;
			if(b.getType()==Element.PACGOMME||b.getType()==Element.EMPTY) {
				borde[posX][posY].setType(b.getType());	
				borde[posX][posY].setPacgome(b.getMyPacgome());
				// borde[posX][posY].getMyPacgome().setPosX(posX);
			}
			/*else if(b.getType()==Element.PACMAN) {
            	 borde[posX][posY].setType(Element.PACMAN);
            	 borde[posX][posY].setPacman(b.getPacman());
            	 //borde[posX][posY].getPacman().setVie();
             } */
			else if(b.getType()==Element.FANTOME){
				borde[posX][posY].setType(Element.FANTOME);
				borde[posX][posY].setFantom1(b.getFantom1());
				borde[posX][posY].getFantom1().setColor(b.getFantom1().getColor());
			}
		}
		  
		/**copie fantome to the positin (posx,posy) 
		 * **/
		public void setCellF(int posX,int posY,Personage_fantome fantome){
			//borde[posX][posY].setType(Element.EMPTY);
			borde[posX][posY].setType((Element)fantome.getType());
			borde[posX][posY].setFantom1(fantome);
			borde[posX][posY].getFantom1().setColor(fantome.getColor());
		}
		
		static Direction getRandomp(){
			index = (int)(Math.random() * direction1.size());
			return direction1.get(index);
			
		}

		/*To get Random value of enum direction because fantomes move randomly */
		static Direction getRandom(){
			/* return  Direction.values()[(int) (Math.random() * Direction.values().length)];*/
			if(!(direction.isEmpty())){
				index = (int)(Math.random() * direction.size());
				choisi=direction.get(index);
				direction.remove(choisi);
				transition.add(choisi);
				if((direction.isEmpty())){
					for(int i=0;i<transition.size();i++){
						Direction dir=transition.get(i);
						direction2.add(dir);
						transition.remove(dir);
					}    	
				}
			}   
			else {	   
				index = (int)(Math.random() * direction2.size());
				choisi=direction2.get(index);
				direction2.remove(choisi);
				transition.add(choisi);
				if((direction2.isEmpty())){
					for(int i=0;i<transition.size();i++) {
						Direction dir=transition.get(i);
						direction.add(dir);
						transition.remove(dir);
					}		   
				}       
			}
			return choisi;
		}
 		
	
		/**creating obstacle in the borde de taile 10*10 */
		public void addbloc(){
			borde[0][4]=bloc; borde[1][1]=bloc;	borde[1][7]=bloc;borde[1][6]=bloc; borde[2][2]=bloc;borde[2][3]=bloc;
			borde[3][5]=bloc;borde[4][1]=bloc;
			borde[4][2]=bloc;borde[4][7]=bloc; borde[4][3]=bloc;
			borde[4][5]=bloc;borde[6][1]=bloc;borde[6][3]=bloc;borde[7][3]=bloc;borde[7][4]=bloc;borde[7][6]=bloc;
			borde[7][7]=bloc;borde[9][3]=bloc;borde[9][7]=bloc;borde[2][9]=bloc;borde[6][4]=bloc;borde[2][1]=bloc;borde[2][7]=bloc;
			borde[3][7]=bloc;borde[4][8]=bloc;borde[4][0]=bloc;borde[6][9]=bloc;borde[7][1]=bloc;borde[7][9]=bloc;borde[8][9]=bloc;
			borde[8][1]=bloc;
		}
    
		/**adding members to the borde one pacman , 
		 * four fantome and different pacgomme
		 * */
		public void addElementToBored(){
			for(int i=0;i<borde.length;i++) {
				for(int j=0;j<borde[i].length;j++) {
   
					if(i==9 && j==0) {borde[i][j]=new Bord(new Personage_fantome(i,j,1));
					MyFantome[0]=borde[i][j].getFantom1();
					//System.out.println(MyFantome[0].getType()+" MyFantome[0]"+"x:y"+i+j);
					}		
					if(i==0 && j==9) {borde[i][j]=new Bord(new Personage_fantome(i,j,2));
					MyFantome[1]=borde[i][j].getFantom1();
					}
					if(i==5 && j==5) {borde[i][j]=new Bord(new Personage_fantome(i,j,3));
					MyFantome[2]=borde[i][j].getFantom1();
					}
					else if(i==9 && j==8) {borde[i][j]=new Bord(new Personage_fantome(i,j,4));
					MyFantome[3]=borde[i][j].getFantom1();
					}
					else if(i==5 && j==0) {borde[i][j]=new Bord(new Personage_pacman(i,j));
					this.pacman=borde[i][j].getPacman();
					}
					/*creating pacgomme blue*/
					else if(i==3 && j==3) {borde[i][j]=new Bord(new MyPacgomme(Pacgomme.BLEU,i,j));
					borde[i][j]=new Bord(new MyPacgomme(Pacgomme.BLEU,i,j));
					numberPacgammes++;
					}
					/*creating pacgomme vert*/
					else if(i==1 && j==3) {borde[i][j]=new Bord(new MyPacgomme(Pacgomme.VERT,i,j));
					borde[i][j]=new Bord(new MyPacgomme(Pacgomme.VERT,i,j));
					numberPacgammes++;
					}
					/*creating pacgomme blue*/
					else if(i==5 && j==3) {borde[i][j]=new Bord(new MyPacgomme(Pacgomme.BLEU,i,j));
					borde[i][j]=new Bord(new MyPacgomme(Pacgomme.BLEU,i,j));
					numberPacgammes++;
					}
					/*creating pacgomme blue*/
					else if(i==9 && j==9) {borde[i][j]=new Bord(new MyPacgomme(Pacgomme.BLEU,i,j));
					borde[i][j]=new Bord(new MyPacgomme(Pacgomme.BLEU,i,j));
					numberPacgammes++;
					}
					/*creating pacgomme vert*/
					else if(i==6&& j==6) {borde[i][j]=new Bord(new MyPacgomme(Pacgomme.VERT,i,j));
					borde[i][j]=new Bord(new MyPacgomme(Pacgomme.VERT,i,j));
					numberPacgammes++;
					}
					/*creating different type of pacgomme randomly*/
					else if(borde[i][j]==null) {
						int s= (int)(Math.random()*(2-(-1)+1)+(-1));  	    
						borde[i][j]=new Bord(new MyPacgomme(Pacgomme.values()[s],i,j));
						//borde[i][j]=new Bord(new MyPacgomme(Pacgomme.BLEU,i,j));
						numberPacgammes++;
					}	
				}
			}
		}
		
		/**
		 * Fontem movement
		 */
		public Direction moveRightF(Bord b){	
			fantome =b.getFantom1();
			System.out.print(fantome.getPosX());
			int posx=fantome.getPosX();
			int posy=fantome.getPosY();	
			int j=posx+1;
			if( j>=borde.length)return Direction.NONE; 
			
			if((borde[j][posy]).getType()==Element.OBSTACLE){
				return Direction.NONE; 
			}
			else if((borde[j][posy]).getType()!=Element.OBSTACLE){   
				
				Bord rec_avanve=borde[j][posy]; 	   				
				if(rec_avanve.getType()==Element.PACGOMME){
					borde[j][posy].getMyPacgome().setPosX(j-1);
					setCellNullF(j-1,posy,rec_avanve);
					fantome.setPosX(j);
					setCellF(j,posy,fantome);  					
				}	else if(rec_avanve.getType()==Element.FANTOME){
					if((j+1==borde.length) || ((borde[j+1][posy]).getType()==Element.OBSTACLE)){
						return Direction.NONE;
					}
					  
				
					borde[j][posy].getFantom1().setPosX(j-1);
					//return Direction.NONE;
					setCellNullF(j-1,posy,rec_avanve);
					setCellF(j,posy,fantome);
					fantome.setPosX(j);
				}	else if(rec_avanve.getType()==Element.EMPTY){
					//borde[j][posy].g.setPosX(j-1);
					//return Direction.NONE;
					setCellNullF(j-1,posy,rec_avanve);
					fantome.setPosX(j);
					setCellF(j,posy,fantome);
				}	  	
				//System.out.println(posx+posy+"R"+fantome.getColor());
			}
			return Direction.RIGHT;	
		}
	
		public Direction moveLeftF(Bord b){		
			fantome =b.getFantom1();
			int posx=fantome.getPosX();
			int posy=fantome.getPosY();	
			int j=posx-1;
			if(j<0)return Direction.NONE;
			//if (getNumberPacgammes()<=0)return;
			else if((borde[j][posy]).getType()==Element.OBSTACLE) {
				return Direction.NONE;/*(getCell(fantome.getPosX(),fantome.getPosY()));*/
			}
			else{		 
				Bord rec_anvance=borde[j][posy]; 			
				if(rec_anvance.getType()==Element.PACGOMME) {
					borde[j][posy].getMyPacgome().setPosX(j+1);
					setCellNullF(j+1,posy,rec_anvance); 
					fantome.setPosX(j);
					setCellF(j,posy,fantome);
				}else if(rec_anvance.getType()==Element.FANTOME) {	
					if((j-1==-1) || ((borde[j-1][posy]).getType()==Element.OBSTACLE)) {
						  return Direction.NONE;
					}
					borde[j][posy].getFantom1().setPosX(j+1);
					setCellNullF(j+1,posy,rec_anvance); 
					
					setCellF(j,posy,fantome);		
					fantome.setPosX(j);
				}
				else if(rec_anvance.getType()==Element.EMPTY) {
					//borde[j][posy].getFantom1().setPosX(j+1);
					setCellNullF(j+1,posy,rec_anvance); 
					fantome.setPosX(j);
					setCellF(j,posy,fantome);		
				}	
				//System.out.println(posx+posy+"L "+fantome.getColor());			
			}	   
			return Direction.LEFT;
		}
		
		public  Direction moveDownF(Bord b){		          
			fantome =b.getFantom1();
			int posx=fantome.getPosX();
			int posy=fantome.getPosY();			 
			int i=posy+1;
			if(i>=borde.length)return Direction.NONE;
			if((borde[posx][i]).getType()==Element.OBSTACLE) {
				return Direction.NONE; 
			}
			else /*((borde[posx][i]).getType()!=Element.OBSTACLE)*/{				
				Bord rec_avence=borde[posx][i];
				if(rec_avence.getType()==Element.PACGOMME) {
					borde[posx][i].getMyPacgome().setPosY(i-1);
					setCellNullF(posx,i-1,rec_avence);
					fantome.setPosY(i);	   
					setCellF(posx,i,fantome);
				}else if(rec_avence.getType()==Element.PACMAN){
					//borde[posx][i].getPacman().setPosY(i-1);
					//return Direction.DOWN;
				}else if(rec_avence.getType()==Element.FANTOME) {
					if((i+1==borde.length) || ((borde[posx][i+1]).getType()==Element.OBSTACLE)) {
						  return Direction.NONE;
					}
					borde[posx][i].getFantom1().setPosY(i-1);
					setCellNullF(posx,i-1,rec_avence);
					fantome.setPosY(i);	   
					setCellF(posx,i,fantome);	
				}else if(rec_avence.getType()==Element.EMPTY) {
					//borde[posx][i].getFantom1().setPosY(i-1);
					setCellNullF(posx,i-1,rec_avence);
					 
					setCellF(posx,i,fantome);	
					fantome.setPosY(i);	  
				}			
				return Direction.DOWN;
			} 
			
		}
		
		public  Direction moveUpF(Bord b){		
			fantome =b.getFantom1();
			int posx=fantome.getPosX();
			int posy=fantome.getPosY();			 
			int i=posy-1;
			if(i<0)return Direction.NONE;
			if((borde[posx][i]).getType()==Element.OBSTACLE){
				return Direction.NONE; 
			}
			else {
				Bord rec_avence=borde[posx][i];
				if(rec_avence.getType()==Element.PACGOMME)
				{
					borde[posx][i].getMyPacgome().setPosY(i+1);
					setCellNullF(posx,i+1,rec_avence);	
					fantome.setPosY(i);
					setCellF(posx,i,fantome);
				}else if(rec_avence.getType()==Element.FANTOME) {
					if((i-1==-1) || ((borde[posx][i-1]).getType()==Element.OBSTACLE)) {	
						  return Direction.NONE;
					}
					borde[posx][i].getFantom1().setPosY(i+1);
					setCellNullF(posx,i+1,rec_avence);	
					
					setCellF(posx,i,fantome);
					fantome.setPosY(i);
				}else if(rec_avence.getType()==Element.EMPTY) {
					//borde[posx][i].getFantom1().setPosY(i+1);
					setCellNullF(posx,i+1,rec_avence);	
					fantome.setPosY(i);
					setCellF(posx,i,fantome);								
				}
				return Direction.UP;
			}
		}

		public void moveFantome(){			
			//System.out.println("Vie"+pacman.getVie());
			if(pacman.getVie()<=0||getNumberPacgammes()<=0){
				//afficheStatus();
				return;
				//System.out.println("game Over");
			}else {
				moveFantome1();
				moveFantome2();
				moveFantome3();
				moveFantome4();
			}
		}
			
				
		public void moveFantome1() {
			Bord b;
			Bord current;
			
			int x=MyFantome[0].getPosX();
			int y=MyFantome[0].getPosY();
			b=getCell(x,y);
			current = b;
			int xx=posxCenterFantom[0];
			int yy=posyCenterFantom[0];
			
			Direction diex=status;
			if(status==Direction.NONE||(x==xx &y==yy)) {
				diex=getRandom();
			}
			//System.out.println(diex+" 1 "+x+":"+y);
			System.out.println(diex+"RED");
			switch(diex){   
			case RIGHT:
				status=moveRightF(current);
				diex=status;
				break;
			case LEFT:			
				status=	moveLeftF(current);
				diex=status;
				break;
			case DOWN:	    	
				status=moveDownF(current);				 
				diex=status;
				break;
			case UP:					
				status=moveUpF(current);
				diex=status;
				break;
			}	
		}
		
		public void moveFantome2(){
			Bord b;
			Bord current;
			// for(int i=0;i<MyFantome.length;i++){	
			int x=MyFantome[1].getPosX();
			int y=MyFantome[1].getPosY();
			b=getCell(x,y);
			int xx=posxCenterFantom[1];
			int yy=posyCenterFantom[1];
			current = b;
			Direction diex=status2;
			if(status2==Direction.NONE|| (x==xx && y==yy)) {
				diex=getRandom();
			}
			//System.out.println(diex+" 2"+x+" :"+y);
			System.out.println(diex+"cyan");
			switch(diex){ 		
	    		case RIGHT:
	    			status2=moveRightF(current);
	    			diex=status2;
	    			    break;
	    		case LEFT:			
	    			status2=moveLeftF(current);
	    			diex=status2;
							 break;
	    		case DOWN:	    	
	    			status2=moveDownF(current);				 
	    			diex=status2;
						 break;
	    		case UP:					
	    			status2=moveUpF(current);
					diex=status2;
	    		 break;
	    		}	
		  }
	 
		public void moveFantome3(){
		  Bord b;
		  Bord current;
		 // for(int i=0;i<MyFantome.length;i++){	
			  int x=MyFantome[2].getPosX();
			  int y=MyFantome[2].getPosY();
		       b=getCell(x,y);
	    		 current = b;
	    		 int xx=posxCenterFantom[2];
	 			int yy=posyCenterFantom[2];
	    		 Direction diex=status3;
	    		 if(status3==Direction.NONE || (x==xx && y==yy)) {
	    	     	diex=getRandom();
	    		 }
	    		 // System.out.println(diex+" 2"+x+" :"+y);
	    		 System.out.println(diex+"DARK_GRAY");
	    		 switch(diex){
	    		 case RIGHT:
	    			 status3=moveRightF(current);
	    			 diex=status3;
	    			 break;
	    		 case LEFT:			
	    			 status3=moveLeftF(current);
	    			 diex=status3;
	    			 break;
	    		 case DOWN:	    	
	    			 status3=moveDownF(current);				 
	    			 diex=status3;
	    			 break;
	    		 case UP:					
	    			 status3=moveUpF(current);
	    			 diex=status3;
	    			 break;
	    		 }	
	  }
	  
		public void moveFantome4(){
		  Bord b;
		  Bord current;
		  // for(int i=0;i<MyFantome.length;i++){	
		  int x=MyFantome[3].getPosX();
		  int y=MyFantome[3].getPosY();
		  b=getCell(x,y);
		  current = b;
		  int xx=posxCenterFantom[3];
			int yy=posyCenterFantom[3];
		  Direction diex=status4;
		  if(status4==Direction.NONE || (x==xx && y==yy)) {
			  diex=getRandom();
		  }
		  // System.out.println(diex+" 2"+x+" :"+y);
		  System.out.println(diex+"GREEN");
		  switch(diex){	
		  case RIGHT:
			  status4=moveRightF(current);
			  diex=status4;
			  break;
		  case LEFT:			
			  status4=moveLeftF(current);
			  diex=status4;
			  break;
		  case DOWN:	    	
			  status4=moveDownF(current);				 
			  diex=status4;
			  break;
		  case UP:					
			  status4=moveUpF(current);
			  diex=status4;
			  break;
		  }	
	  }
	  
		public Bord[][] getBorde(){
		  // TODO Auto-generated method stub
		  return this.borde;
	  }
		
		public int getNumberPacgammes(){
		  return numberPacgammes;
	  }
		
		public void setNumberPacgammes(){
		  numberPacgammes--;
		}
      
		public Boolean afficheBord(){
		  for(int i=0;i<borde.length;i++) {
			  for(int j=0;j<borde[i].length;j++) {
				  switch(borde[i][j].getType())
				  {
				  case PACMAN:
					  //System.out.print(borde[i][j].getType());
					  System.out.print(" PACMAN ");
					  break;
				  case PACGOMME:   				
					  System.out.print(borde[i][j].getMyPacgome()/*.getPacgome()+" "*/);
					  //System.out.print(" ");
					  break;   			
				  case OBSTACLE:			
					  //System.out.print(borde[i][j].getType());
					  System.out.print(" OBSTACLE ");
					  break;  	
				  case EMPTY:    				
					  //System.out.print(borde[i][j].getType());
					  System.out.print(" EMPTY ");
					  break;
				  case FANTOME:    				
					  //System.out.print(borde[i][j].getType());
					  System.out.print(" FANTOME ");
					  break;	
    			}
			  } 		 		
			  System.out.println();
		  } 
		  System.out.println();
		  return true;
	  }
   /**
    	*le pacman mange un pacgomme orange les fantome vonent au centre et change leur color en blue 
   * @return 
   * **/	
		
		public Personage_pacman FantomeToCentre(){
			for(int i=0;i<=3;i++) {
				int x=posxCenterFantom[i];
				int y=posyCenterFantom[i];
				int fx=MyFantome[i].getPosX();
				int fy=MyFantome[i].getPosY();
				Bord rec_avanve=borde[x][y]; 
				Bord fantome=getCell(fx,fy);
				  MyFantome[i].setColor(11);
				//if(rec_avanve.getType()==Element.OBSTACLE)return;
			    if(rec_avanve.getType()==Element.PACGOMME){
					rec_avanve.getMyPacgome().setPosX(fx);
					rec_avanve.getMyPacgome().setPosY(fy);
					setCellNullF(fx,fy,rec_avanve);
					setCellF(x,y,fantome.getFantom1()); 
					fantome.getFantom1().setPosX(x);
					fantome.getFantom1().setPosY(y);
					
				}else if(rec_avanve.getType()==Element.PACMAN){
					pacman=rec_avanve.getPacman();
					System.out.println("center: "+pacman.getPosX());
					fantome.getFantom1().setPosX(x); fantome.getFantom1().setPosY(y);
					setCellNull(x,y,fantome);
					setCell(fx,fy,pacman);
					pacman.setPosX(fx);	pacman.setPosY(fy);
				}else if(rec_avanve.getType()==Element.EMPTY){
					setCellNullF(fx,fy,rec_avanve);
					fantome.getFantom1().setPosX(x);
					fantome.getFantom1().setPosY(y);
					setCellF(x,y,fantome.getFantom1()); 
				}	
			}
			return pacman;				
		}
  /**
   		* pour initinalize le couleur de les fantoms de blue au leur color d'origine 
   * */
		public void initalizeColor(){
		  for(int i=1;i<=4;i++){
			  MyFantome[i-1].setColor(i);
		  }
	  }
		/*Pacman*/  
		public Direction moveLeft(Bord b){//moveUp	
		  pacman =b.getPacman();	   
		  int posx=pacman.getPosX();
		  int posy=pacman.getPosY();			   
		  int j=posx-1;
		  if(j<0)return Direction.NONE;
		  if(getNumberPacgammes()<=0)return Direction.NONE;
		  if((borde[j][posy]).getType()==Element.OBSTACLE){
			  return Direction.NONE;
		  }
		  if((borde[j][posy]).getType()!=Element.OBSTACLE){
			  if(borde[j][posy].getType()==Element.PACGOMME){
				  Pacgomme orange =borde[j][posy].getMyPacgome().getPacgome();
				  pacman.mangePacgomme(borde[j][posy].getMyPacgome());
				  if(orange==Pacgomme.ORANGE) {
					System.out.println("L if"+orange);
					pacman=FantomeToCentre();					
				  }else if(orange==Pacgomme.VIOLET) {
					  initalizeColor();
				  }
				  setNumberPacgammes();
			  }else if(borde[j][posy].getType()==Element.FANTOME){
				  if(pacman.getColor()!=7) {
					  pacman.setVie();
				  }
				  borde[j][posy].getFantom1().setPosX(j+1);
			  }
			  setCellNull(j+1,posy,borde[j][posy]);
			  setCell(j,posy,pacman);
			  pacman.setPosX(j);			 		   
		  }	  
		  return Direction.LEFT;		  
	  }
	
		public Direction moveRight(Bord b){
		  pacman =b.getPacman();
		  //  if(pacman.getVie()<=0||getNumberPacgammes()<=0)System.out.print("game Over");
		  int posx=pacman.getPosX();
		  int posy=pacman.getPosY();
		  int j=posx+1;
		  if(j>=borde.length)return Direction.NONE;
		  //   if (getNumberPacgammes()==0);
		  if((borde[j][posy]).getType()==Element.OBSTACLE) {
			  return Direction.NONE;
		  }
		  if((borde[j][posy]).getType()!=Element.OBSTACLE){
			  if(borde[j][posy].getType()==Element.PACGOMME) {
				  Pacgomme orange =borde[j][posy].getMyPacgome().getPacgome();
				  pacman.mangePacgomme(borde[j][posy].getMyPacgome());
				  if(orange==Pacgomme.ORANGE) {
					  System.out.println("R if "+orange);
					  pacman=  FantomeToCentre();
				  }else if(orange==Pacgomme.VIOLET) {
					  initalizeColor();
				  }
				  setNumberPacgammes();
			  }
			  else if(borde[j][posy].getType()==Element.FANTOME){
				  if(pacman.getColor()!=7) {
					  pacman.setVie();
					  }
				  if(pacman.getColor()==1/*||pacman.getColor()==8*/) {
					  pacman.setVie();
				  }
				  borde[j][posy].getFantom1().setPosX(j-1);
			  }
		  }
		  setCellNull(j-1,posy,borde[j][posy]);
		  setCell(j,posy,pacman);
		  pacman.setPosX(j);			   
		  return Direction.RIGHT;
	  }
	
		public Direction moveDown(Bord b){//moveRight
		  pacman =b.getPacman();
		  //   if(pacman.getVie()<=0||getNumberPacgammes()<=0)System.out.print("game Over");
		  int posx=pacman.getPosX();
		  int posy=pacman.getPosY();
		  int i=posy+1;
		  if(i>=borde.length)return Direction.NONE;
		  if (getNumberPacgammes()==0)return Direction.NONE;
		  if((borde[posx][i]).getType()==Element.OBSTACLE){
			  return Direction.NONE;
		  }
		  if((borde[posx][i]).getType()!=Element.OBSTACLE){
			  if(borde[posx][i].getType()==Element.PACGOMME) {
				  Pacgomme orange =borde[posx][i].getMyPacgome().getPacgome();
				  pacman.mangePacgomme(borde[posx][i].getMyPacgome());
				  if(orange==Pacgomme.ORANGE) {
					  System.out.println("D if"+orange);
					  pacman=  FantomeToCentre();
				  }else if(orange==Pacgomme.VIOLET) {
					  initalizeColor();
				  }
				  setNumberPacgammes();
			  }else if(borde[posx][i].getType()==Element.FANTOME){
				  if(pacman.getColor()!=7){
					  pacman.setVie();	
				  }
				  borde[posx][i].getFantom1().setPosY(i-1);
			  }		 
			  setCellNull(posx,i-1,borde[posx][i]);	   
			  setCell(posx,i,pacman);
			  pacman.setPosY(i);		  
		  } 
		  return  Direction.DOWN;
	  }
	  
		public  Direction moveUp(Bord b){//moveLeft         
		  pacman=b.getPacman();
		  //if(pacman.getVie()<=0||getNumberPacgammes()<=0)System.out.print("game Over");
		  int posx=pacman.getPosX();
		  int posy=pacman.getPosY();			 
		  int i=posy-1;
		  if(i<0)return Direction.NONE;
		  if (getNumberPacgammes()==0)return Direction.NONE;
		  if((borde[posx][i]).getType()==Element.OBSTACLE){
			  return Direction.NONE;
		  }
		  if((borde[posx][i]).getType()!=Element.OBSTACLE){
			  if(borde[posx][i].getType()==Element.PACGOMME) {
				  Pacgomme orange =borde[posx][i].getMyPacgome().getPacgome();
				  pacman.mangePacgomme(borde[posx][i].getMyPacgome());
				  if(orange==Pacgomme.ORANGE) {
					  System.out.println("U if"+orange);
					  pacman= FantomeToCentre();
				  }
				  else if(orange==Pacgomme.VIOLET) {
					  initalizeColor();
				  }
				  setNumberPacgammes();		  
			  }else if(borde[posx][i].getType()==Element.FANTOME){
				  if(pacman.getColor()==8) {
					  pacman.setVie();	
				  }
				  borde[posx][i].getFantom1().setPosY(i+1);
			  }
			  setCellNull(posx,i+1,borde[posx][i]);
			  setCell(posx,i,pacman);
			  pacman.setPosY(i);
		  }  
		  return Direction.UP;
	  }
	
		public void movePacman_aleatoire(){
		  //System.out.println("Vie"+pacman.getVie());
		  if(pacman.getVie()<=0||getNumberPacgammes()<=0) {
			  //afficheStatus();
			  return;
			  //System.out.print("game Over");
		  }else {
			  // if(getNumberPacgammes()<=0)return;
			  int x=pacman.getPosX();
			  int y=pacman.getPosY();
			  Bord current =getCell(x,y);	
			  Direction direction = StatusPacman;
			  if(StatusPacman==Direction.NONE){
				  direction=getRandom();
			  }
			  //System.out.println(x+" "+y+" "+direction);
			  switch(direction){
			  case RIGHT:
				  StatusPacman=moveRight(current);
				  direction=StatusPacman;
				  break;
			  case LEFT:			
				  StatusPacman=moveLeft(current);					
				  direction=StatusPacman;
				  break;
			  case DOWN:	    			
				  StatusPacman=moveDown(current);				 
				  direction=StatusPacman;			
				  break;
			  case UP:					
				  StatusPacman=moveUp(current);
				  direction=StatusPacman;	 
				  break;
			  }
		  }
	  }
	  
		public void movePacman(){
		  if(pacman.getVie()<=0||getNumberPacgammes()<=0) {
			  return;
			
		  }else {
			  int x=pacman.getPosX();
			  int y=pacman.getPosY();
			  Bord current =getCell(x,y);	
			  Direction direction = StatusPacman;
			  if(StatusPacman==Direction.NONE){
				  direction=getRandomp();
			  }
			  //System.out.println(x+" "+y+" "+direction);
			  switch(direction){
			  case RIGHT:
				  StatusPacman=moveRight(current);
				  direction=StatusPacman;
				  break;
			  case LEFT:			
				  StatusPacman=moveLeft(current);					
				  direction=StatusPacman;
				  break;
			  case DOWN:	    			
				  StatusPacman=moveDown(current);				 
				  direction=StatusPacman;			
				  break;
			  case UP:					
				  StatusPacman=moveUp(current);
				  direction=StatusPacman;	 
				  break;
			  }
		  }
	  }
    
		public void afficheStatus(){
		  if(pacman.getVie()==0) {
			  JOptionPane.showMessageDialog(null, "Game Over ): ", " Game Status ",
					  JOptionPane.INFORMATION_MESSAGE);		  
		  }else if(pacman.getVie()>0&&getNumberPacgammes()<=0) {
			  JOptionPane.showMessageDialog(null, "Pacman Won (: ", " Game Status ",
					  JOptionPane.INFORMATION_MESSAGE);
		  }	
	  } 
	}
    
   
	/*public void moveFantome() {
		  Bord b;
		  Bord current;
		 /* for(int i=0;i<MyFantome.length;i++){	
			  int x=MyFantome[i].getPosX();
			  int y=MyFantome[i].getPosY();
			  int c=MyFantome[i].getColor();
			  System.out.println(x+":"+y+":"+c);
		  }*/
		 
		/*  for(int i=0;i<MyFantome.length;i++){	
			  int x=MyFantome[i].getPosX();
			  int y=MyFantome[i].getPosY();
			  current=getCell(x,y);
			  if(current==null)return;
			  System.out.println("tour"+current.getFantom1().getColor());
	    		 Direction diex=status;
	    		 if(status==Direction.NONE) {
	    	     	diex=getRandom();
	    		 }
	    		 System.out.println(diex);
	    		switch(diex){
	    		
	    		case RIGHT:
	    			status=moveRightF(current);
	    			diex=status;
	    			    break;
	    		case LEFT:			
	    			status=	moveLeftF(current);
	    			diex=status;
							 break;
	    		case DOWN:	    	
	    			status=moveDownF(current);				 
	    			diex=status;
						 break;
	    		case UP:					
	    			status=moveUpF(current);
					diex=status;
	    		 break;
	    		}	
		  }
	    }*/
    
    
	

