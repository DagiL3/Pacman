enum Pacgomme {
		    BLEU ,VIOLET, ORANGE, VERT;
	}
 
	public class MyPacgomme{	
		private Pacgomme  pacgom;
		private Element type;
		
		public  MyPacgomme(Pacgomme pacgom){
			this.pacgom=pacgom;
			this.type=Element.PACGOMME;
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
	
   

