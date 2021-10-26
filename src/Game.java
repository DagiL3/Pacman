public class  Game {
	
   private Bord[][] borde;
   private static int numberPacgammes =5; //100 food 
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
    	borde[1][1]=bloc;
    	borde[4][1]=bloc;
    	borde[6][1]=bloc;
    	borde[2][2]=bloc;
    	borde[4][2]=bloc;
    	borde[2][3]=bloc;
    	borde[4][3]=bloc;
    	borde[6][3]=bloc;
    	borde[7][3]=bloc;
    	borde[9][3]=bloc;
    	borde[0][4]=bloc;
    	borde[7][4]=bloc;
    	borde[3][5]=bloc;
    	borde[4][5]=bloc;
    	borde[5][5]=bloc;
    	borde[1][6]=bloc;
    	borde[7][6]=bloc;
    	borde[1][7]=bloc;
    	borde[4][7]=bloc;
    	borde[7][7]=bloc;
    	borde[9][7]=bloc;
    	borde[3][8]=bloc;
    	borde[6][9]=bloc;
    	borde[4][8]=bloc;
    	borde[8][9]=bloc;
    	borde[2][9]=bloc;
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
    				
    				System.out.print(borde[i][j].getType());
    				System.out.print(" ");
    				break;
    			case PACGOMME:
    				
    				System.out.print(borde[i][j].getMyPacgome().getPacgome());
    				System.out.print(" ");
					break;
    			
    			case OBSTACLE:
    				
    				System.out.print(borde[i][j].getType());
    				System.out.print(" ");
					break;
    				
    			case EMPTY:
    				
    				System.out.print(borde[i][j].getType());
    				System.out.print(" ");
					break;
    			
    			}
    		} 		
    		
    		System.out.println();
    	}  return true;
    }
    
    public void movePacman(int posX,int posY){
    	Personage_pacman b=borde[posX][posY].getPacman();
    	while(numberPacgammes>0) {
		 
    		if(posX>borde.length-1|| posX<0)return;
    		if(posY>borde[0].length-1|| posY<0)return;	
    		Bord current = getCell(posX,posY);		  
    		Direction direction=Direction.UP;//getRandom();
    		switch(direction){
    		case RIGHT:
    			moveRight(current);
    			break;
    		case LEFT:
    			moveLeft(current);
    			break;
    		case DOWN:
    			moveDown(current);
    			break;
    		case UP:
    		 b=	moveUp(current);
    			break;		   
    		}
    		movePacman( b.getPosX(), b.getPosY());
    	}		   
    }
	   
    private Personage_pacman moveUp(Bord b){
		   Personage_pacman pacman =b.getPacman();
		   int posx=pacman.getPosX();
		   int posy=pacman.getPosY();
		   
		   for(int j=posx-1;j>=0;j--){
			   if((borde[j][posy]).getType()!=Element.OBSTACLE){
				   if(borde[j][posy].getMyPacgome()!=null) {
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
		   return (pacman);
	  
}
    
	   private void moveDown(Bord b){
		   Personage_pacman pacman =b.getPacman();
		   int posx=pacman.getPosX();
		   int posy=pacman.getPosY();
		   for(int j=posx+1;j<borde.length;j++){
			   if((borde[j][posy]).getType()!=Element.OBSTACLE){
				   if(borde[j][posy].getMyPacgome()!=null) {
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
		   }
	   }
	private void moveRight(Bord b){
		   Personage_pacman pacman =b.getPacman();
		   int posx=pacman.getPosX();
		   int posy=pacman.getPosY();
		   
		   for(int i=posy+1;i<borde.length-1;i++){
			   if((borde[posx][i]).getType()!=Element.OBSTACLE){
				   if(borde[posx][i].getMyPacgome()!=null) {
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
		   }
	   }
    
    private void moveLeft(Bord b){
		   Personage_pacman pacman =b.getPacman();
		   int posx=pacman.getPosX();
		   int posy=pacman.getPosY();
		 
		   for(int i=posy-1;i>=0;i--){
			   if((borde[posx][i]).getType()!=Element.OBSTACLE){
				   if(borde[posx][i].getMyPacgome()!=null) {
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
		   }
	   
    }
    

    
    
    
    }
    
    


    
    
    
    
	

