enum Pacgomme {
		    BLEU ,VIOLET, ORANGE, VERT;
	}
 
	public class MyPacgomme{	
		private Pacgomme  pacgom;
		private Element type;
		private int posX;
		private int posY;
		
		public MyPacgomme(Pacgomme pacgom,int posX,int posY){
			this.pacgom=pacgom;
			this.type=Element.PACGOMME;
			this.posX=posX;
			this.posY=posY;
		}
		
		public int getPosX() {
			return posX;
		}

		public void setPosX(int posX) {
			this.posX = posX;
		}

		public int getPosY() {
			return posY;
		}

		public void setPosY(int posY) {
			this.posY = posY;
		}

		public void setPacgomme(){
			this.pacgom=null;
			this.type=null;
		}
		
		public Pacgomme getPacgome() {
			return pacgom;
		}

		public Element getType() {
				return type;
		}

	

	

	
}
	
   

