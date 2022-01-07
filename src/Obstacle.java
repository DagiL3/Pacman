
public class Obstacle {
  private int color;
  private Element type;
  
  
  public Obstacle(){
	  this.color=3;
	  this.type=Element.OBSTACLE;
  }
  /********************************************Getters and Setters******************************************************/
public int getColor() {
	return color;
}

public void setColor(int color) {
	this.color = color;
}

public Element getType() {
	return type;
}

public void setType(Element type) {
	this.type = type;
}
}
