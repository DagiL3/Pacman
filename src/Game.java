public class  Game {
	
   Bord[][] borde;
   private static int numberPacgammes =0; //100 food 
   private Bord bloc =new Bord(new Obstacle());
   //private Movement action;

   public Game(){
	   this.borde= new Bord[10][10];
	   addbloc();
	   addPacgamme();
	  
	   }
   
   public Bord getCell(int posX,int posY){
	   return borde[posX][posY];
   }
   
   public void setCellNull(int posX,int posY){
	   borde[posX][posY].setType(Element.EMPTY);
   }
 
   public void setCell(int posX,int posY,Personage_pacman pacman){
	   borde[posX][posY].setType((Element) pacman.getType());
	   borde[posX][posY].setPacman(pacman);
   }
   public void  setCellNullF(int posX,int posY){
	  
	   borde[posX][posY].setType(Element.EMPTY);
   } 
  
   public void setCellF(int posX,int posY,Personage_fantome fantome){
	   borde[posX][posY].setType((Element) fantome.getType());
	   borde[posX][posY].setFantom1(fantome);
   }
   
   /*To get Random value of enum */
   static Direction getRandom(){
	  return Direction.values()[(int) (Math.random()* Direction.values().length)];
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
    			if(i==3 && j==3) {borde[i][j]=new Bord(new Personage_fantome(i,j));}
    			else if(i==9 && j==9) {borde[i][j]=new Bord(new Personage_fantome(i,j));
    			}
    			else if(i==5 && j==0) {borde[i][j]=new Bord(new Personage_pacman(i,j));
    			}
    			
    			else if(borde[i][j]==null) {
    				borde[i][j]=new Bord(new MyPacgomme(Pacgomme.BLEU));
    				numberPacgammes++;
    			}	
    			}
    		}
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
    				System.out.print(borde[i][j].getMyPacgome().getPacgome()+" ");
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
    
    
    
    }
    
    


    
    
    
    
	

