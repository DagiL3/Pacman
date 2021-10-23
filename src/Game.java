
public class  Game {
   private Pacgomme[][] borde = new Pacgomme[10][10];
   private Pacgomme bloc=new Pacgomme(Pacgomme_type.OBSTACLE);
   private Personage_pacman pacman;
   private Personage_fantome fantom1;
   private Personage_fantome fantom2;
   private Personage_fantome fantom3;
   private Personage_fantome fantom4;
   private static final int numberPacgammes =75; //100 food 
   
    public Game(Personage_pacman pacman,Personage_fantome fantom1,Personage_fantome fantom2,
    		Personage_fantome fantom3,Personage_fantome fantom4){
    	this.pacman=pacman;
    	this.fantom1=fantom1;
    	this.fantom1=fantom2;
    	this.fantom1=fantom3;
    	this.fantom1=fantom4;	
    	
    }
    
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
    				borde[i][j]=new Pacgomme(Pacgomme_type.BLEU);
    			
    			}
    	}
    			
    }
    public void afficheBord(){
    	
    	for(int i=0;i<borde.length;i++) {
    		for(int j=0;j<borde[i].length;j++) {
    			System.out.print(borde[i][j].type);
    			System.out.print(" ");
    	      }
    		
    		System.out.println();
    	 }//System.out.print(borde[1][1]);
    }
    }

    
    
    
    
	

