
public class Personage_fantome {
	private  int color;
	
	private Element type;
	private int posX;
	private int posY;
     
	public Personage_fantome(int posX,int posY,int color) {
		this.color=color;
		this.type=Element.FANTOME;
		this.posX=posX;
		this.posY=posY;
	}
	
	/********************************************Getters and Setters******************************************************/
	public void mangePacgomme(MyPacgomme g){
		g.setPacgomme();
	}
	
	public int getColor(){
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX){
		this.posX = posX;
	}
	public int getPosY(){
		return posY;
	}
	public void setPosY(int posY){
		this.posY = posY;
	}
	public Element getType(){
		return type;
	}
	public void setType(Element type){
		this.type = type;
	}
}
