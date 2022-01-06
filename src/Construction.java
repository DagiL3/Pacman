
public class Construction {
	 
   Game game;
	Bord[][] borde;
		private static int numberPacgammes =0; 
		private Bord bloc =new Bord(new Obstacle());
		private Personage_pacman pacman;
		Personage_fantome[] MyFantome=new Personage_fantome[4];
	
		public Construction(Game game){
			this.borde= new Bord[10][10];
			this.game=game;
	     	addbloc();
		   addElementToBored();	
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
				else if(i==5 && j==0) {borde[i][j]=new Bord(new Personage_pacman(i,j,game));
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
	public Bord[][] getBorde() {
		return borde;
	}

	public void setBorde(Bord[][] borde) {
		this.borde = borde;
	}

	public static int getNumberPacgammes() {
		return numberPacgammes;
	}

	public static void setNumberPacgammes(int numberPacgammes) {
		Construction.numberPacgammes = numberPacgammes;
	}

	public Personage_pacman getPacman() {
		return pacman;
	}

	public void setPacman(Personage_pacman pacman) {
		this.pacman = pacman;
	}

	public Personage_fantome[] getMyFantome() {
		return MyFantome;
	}

	public void setMyFantome(Personage_fantome[] myFantome) {
		MyFantome = myFantome;
	}

}
