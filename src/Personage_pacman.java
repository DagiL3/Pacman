
public class Personage_pacman  {

	private  int vie;
	private  int color;
	private  int point;
	public Element type;
	private int posX;
	private int posY;
	private Game game;
	
	
	public Personage_pacman( int posX,int posY,Game game){
		this.vie=3;
		this.color=1;//yellow
		this.point=0;
		this.type=Element.PACMAN;
		this.posX=posX;
		this.posY= posY;
		this.game=game;
	}
	
	/**
	 * @brief  ajouter les point pour le Pacman et vérifie le conditon pour ajouter le vie 
	 * @param g est un pacgomme qui a ete mange par un pacman
	 */
	public void mangePacgomme(MyPacgomme g){
		if(g==null)return;
		game.addPoints(g);
		addVie();
	}
	 
	/**
	 * @brief  ajouter une vie pour le Pacman 
	 */
	public void addVie(){
		if(this.point>=5000) {
			this.vie++;
			this.point-=5000;
		}
	}
	/********************************************Getters and Setters******************************************************/
		
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
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
		this.point = this.point+point;
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

	

