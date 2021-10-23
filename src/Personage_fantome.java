
public class Personage_fantome {
	private  int color;
	private Object type;
	
	public Object getType() {
		return type;
	}

	public void setType(Object type) {
		this.type = type;
	}

	public Personage_fantome(int color) {
		this.color=color;
		this.type=Element.FANTOME;
	}
	
	
}
