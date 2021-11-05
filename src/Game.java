import java.util.ArrayList;
import java.util.List;

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
   
   static Direction choisi=Direction.LEFT;
   static List<Direction> direction=new ArrayList<>();
   static List<Direction> transition=new ArrayList<>();
   static List<Direction> direction2=new ArrayList<>();
   
   private void createListRandom() { 
    direction.add(Direction.DOWN);
    direction.add(Direction.LEFT);
    direction.add(Direction.RIGHT);
    direction.add(Direction.UP);
   }
   public Game(){
	   createListRandom();
	   this.borde= new Bord[10][10];
	   addbloc();
	   addPacgamme();
	  
	   }
   
   public Bord getCell(int posX,int posY){
	   return borde[posX][posY];
   }
   
   public void setCellNull(int posX,int posY,Bord b){
	   if(b.getType()==Element.OBSTACLE)return;
	   if(b.getType()==Element.PACGOMME||b.getType()==Element.EMPTY) {
		   borde[posX][posY].setType(Element.EMPTY);
	   }else if(b.getType()==Element.FANTOME){
		   borde[posX][posY].setType(Element.EMPTY);
		   borde[posX][posY].setType(Element.FANTOME);
		   borde[posX][posY].setFantom1(b.getFantom1());
	   }
	   
   }
 
   public void setCell(int posX,int posY,Personage_pacman pacman){
	   borde[posX][posY].setType(Element.EMPTY);
	   borde[posX][posY].setType((Element) pacman.getType());
	   borde[posX][posY].setPacman(pacman);
   }
   
   
  public void  setCellNullF(int posX,int posY, Bord b){
	       if(b.getType()==Element.OBSTACLE)return;
		      if(b.getType()==Element.PACGOMME) {
			   borde[posX][posY].setType(b.getType());	
		       borde[posX][posY].setPacgome(b.getMyPacgome());
		      // borde[posX][posY].getMyPacgome().setPosX(posX);
             }
		      else if(b.getType()==Element.PACMAN) {
            	 borde[posX][posY].setType(Element.PACMAN);
            	 borde[posX][posY].setPacman(b.getPacman());
            	 //borde[posX][posY].getPacman().setVie();
             } else if(b.getType()==Element.FANTOME){
            	 borde[posX][posY].setType(Element.FANTOME);
          	     borde[posX][posY].setFantom1(b.getFantom1());
          	     borde[posX][posY].getFantom1().setColor(b.getFantom1().getColor());
             }
  }
          
   public void setCellF(int posX,int posY,Personage_fantome fantome){
	   //borde[posX][posY].setType(Element.EMPTY);
	   borde[posX][posY].setType((Element) fantome.getType());
	   borde[posX][posY].setFantom1(fantome);
	   borde[posX][posY].getFantom1().setColor(fantome.getColor());
   }
 
   /*To get Random value of enum */
   static Direction getRandom(){
	 /* return  Direction.values()[(int) (Math.random() * Direction.values().length)];*/
	   
	   if(!(direction.isEmpty())) {
		   index = (int)(Math.random() * direction.size());
		   choisi=direction.get(index);
		    direction.remove(choisi);
		    transition.add(choisi);
			//System.out.println(choisi+"A1");
		//	System.out.println(direction+"A1");
		    if((direction.isEmpty())) {
		    	for( int i=0;i<transition.size();i++) {
		    	   direction2.add(transition.get(i));
		    	   transition.remove(transition.get(i));
		    	}
		    	
		    }
	   }
	   
	   else {
		   
		   index = (int)(Math.random() * direction2.size());
		   choisi=direction2.get(index);
		   direction2.remove(choisi);
		   transition.add(choisi);
			//System.out.print(choisi+"A2");
			//System.out.println(direction+"A2");
		   if((direction2.isEmpty())) {
			   for( int i=0;i<transition.size();i++) {
		    	   direction.add(transition.get(i));
		    	   transition.remove(transition.get(i));
		    	}
			   
		    }
	       
	   }
	  // System.out.println(choisi);
          return choisi;
   }

 
    /**view*/ 
    public void addbloc(){
    	borde[0][4]=bloc;
    	borde[1][1]=bloc;
    	borde[1][7]=bloc;
    	borde[1][6]=bloc;
    	borde[2][2]=bloc;
    	borde[2][3]=bloc;
    	borde[3][5]=bloc;
        //borde[3][8]=bloc;
    	borde[4][1]=bloc;
    	borde[4][2]=bloc;
    	borde[4][7]=bloc;
    	borde[4][3]=bloc;
    	borde[4][5]=bloc;
    	borde[5][5]=bloc;
    	borde[6][1]=bloc;
    	borde[6][3]=bloc;
    	borde[7][3]=bloc;
    	borde[7][4]=bloc;
    	borde[7][6]=bloc;
    	borde[7][7]=bloc;
    	borde[9][3]=bloc;
    	borde[9][7]=bloc;
    	//new
    	borde[2][9]=bloc;
    	borde[6][4]=bloc;
    	borde[2][1]=bloc;
    	borde[2][7]=bloc;
    	borde[3][7]=bloc;
    	borde[4][8]=bloc;
    	borde[4][0]=bloc;
    	//borde[4][6]=bloc;
    	borde[6][9]=bloc;
    	borde[7][1]=bloc;
    	borde[7][9]=bloc;
    	borde[8][9]=bloc;
    	borde[8][1]=bloc;
    }
    
    public void addPacgamme(){
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
    			
    			else if(borde[i][j]==null) {
    				borde[i][j]=new Bord(new MyPacgomme(Pacgomme.BLEU,i,j));
    				numberPacgammes++;
    			}	
    			}
    		}
    }
    /**
	 * Fontem movement
	 */
	public Direction moveRightF(Bord b){	//moveDown		
		 fantome =b.getFantom1();
		   int posx=fantome.getPosX();
		   int posy=fantome.getPosY();	
		   int j=posx+1;
		   if( j>=borde.length)return Direction.NONE;
		   
		    if((borde[j][posy]).getType()==Element.OBSTACLE){
	   	    return Direction.NONE/*(getCell(fantome.getPosX(),fantome.getPosY()))*/; 
	   		}
		   else	if((borde[j][posy]).getType()!=Element.OBSTACLE){   			
			   				Bord rec_avanve=borde[j][posy]; 
			   				
			   				if(rec_avanve.getType()==Element.PACGOMME) {
			   					borde[j][posy].getMyPacgome().setPosX(j-1);
			   					
			   				}else if(rec_avanve.getType()==Element.PACMAN){
			   					borde[j][posy].getPacman().setPosX(j-1);
			   					
			   				}	else if(rec_avanve.getType()==Element.FANTOME){
			   					borde[j][posy].getFantom1().setPosX(j-1);
			   					
			   				}	
			   				setCellNullF(j-1,posy,rec_avanve);
			   				fantome.setPosX(j);
			   				setCellF(j,posy,fantome);
			   		    	
			   				//System.out.println(posx+posy+"R"+fantome.getColor());
			   		
			   		}
			   	return Direction.RIGHT;	
	}
	
	
	public Direction moveLeftF(Bord b){	//moveDown		
		 fantome =b.getFantom1();
		   int posx=fantome.getPosX();
		   int posy=fantome.getPosY();	
		   int j=posx-1;
		   if(j<0)return Direction.NONE;
		 //  if (getNumberPacgammes()<=0)return;
		   else  if((borde[j][posy]).getType()==Element.OBSTACLE) {
			   return Direction.NONE;/*(getCell(fantome.getPosX(),fantome.getPosY()));*/
						}
		   else/* ((borde[j][posy]).getType()!=Element.OBSTACLE)*/{
				 
							Bord rec_anvance=borde[j][posy]; 
						
								if(rec_anvance.getType()==Element.PACGOMME) {
			   					   borde[j][posy].getMyPacgome().setPosX(j+1);
			   					   
								}
								else if(rec_anvance.getType()==Element.PACMAN){
									borde[j][posy].getPacman().setPosX(j+1);
									
								}else if(rec_anvance.getType()==Element.FANTOME) {
									 
				   					 borde[j][posy].getFantom1().setPosX(j+1);
				   					
				   					}
								setCellNullF(j+1,posy,rec_anvance); 
								 fantome.setPosX(j);
								 setCellF(j,posy,fantome);		
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
	   					}else if(rec_avence.getType()==Element.PACMAN){
	   					 borde[posx][i].getPacman().setPosY(i-1);
	   					}else if(rec_avence.getType()==Element.FANTOME) {
	   					 borde[posx][i].getFantom1().setPosY(i-1);
	   					  
	   					}
					   setCellNullF(posx,i-1,rec_avence);
					   fantome.setPosY(i);	   
					   setCellF(posx,i,fantome);				  
					} 
		  return Direction.DOWN;
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
		   else/*((borde[posx][i]).getType()!=Element.OBSTACLE) */ {
						Bord rec_avence=borde[posx][i];
						if(rec_avence.getType()==Element.PACGOMME)
						{
							borde[posx][i].getMyPacgome().setPosY(i+1);
						}else if(rec_avence.getType()==Element.PACMAN) {
							borde[posx][i].getPacman().setPosY(i+1);
						}else if(rec_avence.getType()==Element.FANTOME) {
							borde[posx][i].getFantom1().setPosY(i+1);
							
						}					
						setCellNullF(posx,i+1,rec_avence);	
						fantome.setPosY(i);
				   		setCellF(posx,i,fantome);	
				   		   }
		   return Direction.UP;
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
	  

	public void moveFantome(){
		
		moveFantome1();
		moveFantome2();
		moveFantome3();
		moveFantome4();
	}
	
	  public void moveFantome1() {
		  Bord b;
		  Bord current;
		 // for(int i=0;i<MyFantome.length;i++){	
			  int x=MyFantome[0].getPosX();
			  int y=MyFantome[0].getPosY();
		       b=getCell(x,y);
	    		 current = b;
	    		 Direction diex=status;
	    		 if(status==Direction.NONE) {
	    	     	diex=getRandom();
	    		 }
	    		 System.out.println(diex+" 1 "+x+" :"+y);
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
	 //   }
	  public void moveFantome2() {
		  Bord b;
		  Bord current;
		 // for(int i=0;i<MyFantome.length;i++){	
			  int x=MyFantome[1].getPosX();
			  int y=MyFantome[1].getPosY();
		       b=getCell(x,y);
	    		 current = b;
	    		 Direction diex=status2;
	    		 if(status2==Direction.NONE) {
	    	     	diex=getRandom();
	    		 }
	    		 System.out.println(diex+" 2"+x+" :"+y);
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
	 //   }
	  public void moveFantome3() {
		  Bord b;
		  Bord current;
		 // for(int i=0;i<MyFantome.length;i++){	
			  int x=MyFantome[2].getPosX();
			  int y=MyFantome[2].getPosY();
		       b=getCell(x,y);
	    		 current = b;
	    		 Direction diex=status3;
	    		 if(status3==Direction.NONE) {
	    	     	diex=getRandom();
	    		 }
	    		 System.out.println(diex+" 2"+x+" :"+y);
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
	 //   }
	  public void moveFantome4() {
		  Bord b;
		  Bord current;
		 // for(int i=0;i<MyFantome.length;i++){	
			  int x=MyFantome[3].getPosX();
			  int y=MyFantome[3].getPosY();
		       b=getCell(x,y);
	    		 current = b;
	    		 Direction diex=status4;
	    		 if(status4==Direction.NONE) {
	    	     	diex=getRandom();
	    		 }
	    		 System.out.println(diex+" 2"+x+" :"+y);
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
	 //   }
	  
	public Bord[][] getBorde() {
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
    
    }
    
    


    
    
    
    
	

