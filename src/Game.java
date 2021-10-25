public class  Game {
	
   private Bord[][] borde = new Bord[10][10];
   private static int numberPacgammes =75; //100 food 
   private Bord bloc =new Bord(new Obstacle());
   //private Movement action;
   
   public Bord getCell(int posX,int posY){
	   return borde[posX][posY];
   }
   public void setCell(int posX,int posY,Bord bord){
	   borde[posX][posY]=bord;
   }
   
   /*To get Random value of enum */
   private static Direction getRandom(){
	  return Direction.values()[(int) (Math.random()* Direction.values().length)];
   }
      
   public void move(int posX,int posY){
	   if(posX>borde.length|| posX<0)return;
	   if(posY>borde[0].length|| posY<0)return;
	  while(numberPacgammes>0) {
		  System.out.print("je suis dans le move while");
	   switch(borde[posX][posY].getType())
	   {
	   case PACMAN:
		   Bord current =getCell(posX,posY);
		   Direction direction=getRandom();
		   switch(direction){
		   case RIGHT:
			   moveRight(current);
			 /// afficheBord();
			   break;
		   case LEFT:
			   moveLeft(current);
			  // afficheBord();
			   break;
		   case DOWN:
			   moveDown(current);
			//  afficheBord();
			   break;
		   case UP:
			   moveUp(current);
			 //  afficheBord();
			   break;
		   }
	   }
	  }
   }
   private void moveLeft(Bord b){
	   Personage_pacman pacman =b.getPacman();
	   int posx=pacman.getPosX();
	   int posy=pacman.getPosY();
	
	   for(int i=posx-1;i>=0;i--){
		   if((borde[i][posy]).getType()!=Element.OBSTACLE){
			   pacman.mangePacgomme(b.getMyPacgome());
			   numberPacgammes-=1;
			   setCell(i+1,posy,b);
			   afficheBord();
		   }else 
			   break;
	   }
   }
   
   private void moveRight(Bord b){
	   Personage_pacman pacman =b.getPacman();
	   int posx=pacman.getPosX();
	   int posy=pacman.getPosY();
	   
	   for(int i=posx+1;i<borde.length;i++){
		   if((borde[i][posy]).getType()!=Element.OBSTACLE){
			   pacman.mangePacgomme(b.getMyPacgome());
			   numberPacgammes-=1;
			   setCell(i+1,posy,b);
			   afficheBord();
		   }else
			   break;
	   }
   }
   
   private void moveDown(Bord b){
	   Personage_pacman pacman =b.getPacman();
	   int posx=pacman.getPosX();
	   int posy=pacman.getPosY();
	   
	   for(int j=posy+1;j<borde[posx].length;j++){
		   if((borde[posx][j]).getType()!=Element.OBSTACLE){
			   pacman.mangePacgomme(b.getMyPacgome());
			   numberPacgammes-=1;
			   setCell(posx,posy,b);
			   afficheBord();
		   }else
			   break;
	   }
   }
   
   private void moveUp(Bord b){
	   Personage_pacman pacman =b.getPacman();
	   int posx=pacman.getPosX();
	   int posy=pacman.getPosY();
	   
	   for(int j=posy-1;j>=0;j--){
		   if((borde[posx][j]).getType()!=Element.OBSTACLE){
			   pacman.mangePacgomme(b.getMyPacgome());
			   numberPacgammes-=1;
			   setCell(posx,posy,b);
			   afficheBord();
		   }
	   }
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
    			if(borde[i][j]==null)
    				borde[i][j]=new Bord(new MyPacgomme(Pacgomme.BLEU));
    			}
    	   }			
    }
    public Boolean afficheBord(){
    	for(int i=0;i<borde.length;i++) {
    		for(int j=0;j<borde[i].length;j++) {
    			switch(borde[i][j].getType())
    			{
    			case PACGOMME:
    				System.out.print(borde[i][j].getMyPacgome().getPacgome());
    				System.out.print(" ");
					break;
    			
    			case OBSTACLE:
    				
    				System.out.print(borde[i][j].getType());
    				System.out.print(" ");
					break;
    			}	
    		} 		
    		System.out.println();
    	}  return true;
    }
    
}

    
    
    
    
	

