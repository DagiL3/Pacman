public class  Game {
	
   private Bord[][] borde = new Bord[10][10];
   private static final int numberPacgammes =75; //100 food 
   private Bord bloc =new Bord(new Obstacle());
 
       
    // view 
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
    			case PACKGOMME:
    			//MyPacgomme e=borde[i][j].getMyPacgome().getType();
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

    
    
    
    
	

