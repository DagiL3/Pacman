
public class Personage_pacman  {

	private  int vie;
	private  int color;
	private  int point;
	public Element type;
	private int posX;
	private int posY;
	
	public Personage_pacman( int posX,int posY){
		this.vie=3;
		this.color=1;//yellow
		this.point=0;
		this.type=Element.PACMAN;
		this.posX=posX;
		this.posY= posY;
	}
	
	public void mangePacgomme(MyPacgomme g){
		if(g==null)return;
		addPoints(g);
		g.setPacgomme();
		addVie();
	}
	
	 private void addPoints(MyPacgomme p){
		if(p==null)return;
		if(p.getPacgome()==null)return;
		 switch(p.getPacgome()){
		 
		 case BLEU:
		    point=point+100;
		    //setColor(1);
		    break;
		 case VIOLET:
			 point=point+300;
			 setColor(7);//7:pale yellow.
			    break;
		 case ORANGE:
			 point=point+500;
			    setColor(8);//orenge
			    break;
		 case VERT:
			 point=point+1000;
	             //setcolor()//verte
			    break;
	   }
		
	}
	 
	 public void addVie(){
		 if(this.point>=5000) {
			this.vie++;
		 }
	 }
	 
		public int getVie() {
			return vie;
		}

		public void setVie() {
			this.vie--;
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

	

