
public class Personage_pacman  {

	private  int vie;
	private  int color;
	private  int point;
	public Element type;
	private int posX;
	private int posY;
	
	public Personage_pacman(){
		this.vie=3;
		this.color=1;//yellow
		this.point=0;
		this.type=Element.PACMAN;
		this.posX=0;
		this.posY=0;
	}
	
	public void mangePacgomme(MyPacgomme g){
		addPoints(g);
		g.setPacgomme();
		//no_pacgomme --;
	}
	
	 private void addPoints(MyPacgomme p){
		 switch(p.getPacgome()){
		 
		 case BLEU:
		    point=point+100;
		    break;
		 case VIOLET:
			 point=point+300;
			    break;
		 case ORANGE:
			 point=point+500;
			    break;
		 case VERT:
			 point=point+1000;
			    break;
	   }
		
	}
	 
		public int getVie() {
			return vie;
		}

		public void setVie(int vie) {
			this.vie = vie;
		}

		public int getColor() {
			return color;
		}

		public void setColor(int color) {
			this.color = color;
		}

		public int getPoint() {
			return point;
		}

		public void setPoint(int point) {
			this.point = point;
		}

		public Object getType() {
			return type;
		}

		public void setType(Element type) {
			this.type = type;
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
}

	

