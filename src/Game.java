public class  Game {
	
   private Bord[][] borde;
   private static int numberPacgammes =64; //100 food 
   private Bord bloc =new Bord(new Obstacle());
   //private Movement action;
   
   public Game(){
	   this.borde= new Bord[10][10];
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
   
   /*To get Random value of enum */
   private static Direction getRandom(){
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
    			if(i==5 && j==0) {borde[i][j]=new Bord(new Personage_pacman(i,j));}
    			else if(borde[i][j]==null) {
    				borde[i][j]=new Bord(new MyPacgomme(Pacgomme.BLEU));
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
    			
    			}
    		} 		
    		
    		System.out.println();
    	} 
    	System.out.println();
    	return true;
    }
    
    public void movePacman(Bord b){
    //	Personage_pacman b=borde[posX][posY].getPacman();
    	Bord c = b;
    	
    		Bord current = b;		  
    		
    		Direction direction=getRandom();
    		switch(direction){
    		case RIGHT:
    	  	c=moveRight(current); 	
    	  	current=c;
    			break;
    		case LEFT:
    			c=moveLeft(current); 
    			current=c;
    			 //movePacman (b.getPosX(), b.getPosY());
    			 break;
    		case DOWN:
    			 c=moveDown(current); 
    			 current=c;
    			// movePacman (b.getPosX(), b.getPosY());	  
    			 break;
    		case UP:
    		 c=moveUp(current); 
    		 current=c;
    		// movePacman (b.getPosX(), b.getPosY());	 
    		 break;
    		}
    		while(numberPacgammes>0) 
        	{
    		movePacman (current);	
    		
    	}		   
    }
	   
    private Bord moveUp(Bord b){
		   Personage_pacman pacman =b.getPacman();
		   int posx=pacman.getPosX();
		   int posy=pacman.getPosY();
		   
		   for(int j=posx-1;j>=0;j--){
			   if((borde[j][posy]).getType()!=Element.OBSTACLE){
				   if(borde[j][posy].getType()==Element.PACGOMME) {
					   pacman.mangePacgomme(borde[j][posy].getMyPacgome());
					   numberPacgammes--;
				   	}
				   int v=j+1;
				   setCellNull(v,posy);
				   setCell(j,posy,pacman);
				   pacman.setPosX(j);
				   afficheBord();
			   }else break;
				  
		   }
		   return (getCell(pacman.getPosX(),pacman.getPosY()));
	  
}
    
	   private Bord moveDown(Bord b){
		   Personage_pacman pacman =b.getPacman();
		   int posx=pacman.getPosX();
		   int posy=pacman.getPosY();
		   for(int j=posx+1;j<borde.length;j++){
			   if((borde[j][posy]).getType()!=Element.OBSTACLE){
				   if(borde[j][posy].getType()==Element.PACGOMME) {
				   pacman.mangePacgomme(borde[j][posy].getMyPacgome());
				   numberPacgammes--;
				   }
				   int v=j-1;
				   setCellNull(v,posy);
				   setCell(j,posy,pacman);
				   pacman.setPosX(j);
				   afficheBord();
			   }else
				   break;
		   } return (getCell(pacman.getPosX(),pacman.getPosY()));
	   }
	private Bord moveRight(Bord b){
		   Personage_pacman pacman =b.getPacman();
		   int posx=pacman.getPosX();
		   int posy=pacman.getPosY();
		   
		   for(int i=posy+1;i<borde.length;i++){
			   if((borde[posx][i]).getType()!=Element.OBSTACLE){
				   if(borde[posx][i].getType()==Element.PACGOMME) {
					   pacman.mangePacgomme(borde[posx][i].getMyPacgome());
					   numberPacgammes--;
				   }
				   int v=i-1;
				   setCellNull(posx,v);	   
				   setCell(posx,i,pacman);
				   pacman.setPosY(i);
				   afficheBord();
			   }else
				   break;
		   } return (getCell(pacman.getPosX(),pacman.getPosY()));
	   }
    
    private Bord moveLeft(Bord b){
		   Personage_pacman pacman =b.getPacman();
		   int posx=pacman.getPosX();
		   int posy=pacman.getPosY();
		 
		   for(int i=posy-1;i>=0;i--){
			   if((borde[posx][i]).getType()!=Element.OBSTACLE){
				   if(borde[posx][i].getType()==Element.PACGOMME) {
				      pacman.mangePacgomme(borde[posx][i].getMyPacgome());
				      numberPacgammes--;
				   }
				   int v=i+1;
				   setCellNull(posx,v);
				   setCell(posx,i,pacman);
				   pacman.setPosY(i);
				  afficheBord();
			   }else 
				   break;
		   }return (getCell(pacman.getPosX(),pacman.getPosY()));
	   
    }
	public Bord[][] getBorde() {
		// TODO Auto-generated method stub
		return this.borde;
	}
    

    
    
    
    }
    
    


    
    
    
    
	

