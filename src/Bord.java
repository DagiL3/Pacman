public  class Bord {
	 private Element type;
	 private Personage_pacman pacman;
	 private Personage_fantome fantom1;
	 private MyPacgomme pacgome;
	 private Obstacle obstacle;
	  
	 public Bord(Personage_pacman pacman){
		 this.pacman=pacman;  
		 this.type=(Element) pacman.getType();
	 }
	 
	 public Bord(Personage_fantome fantom1){
		 this.fantom1=fantom1;
		 this.type=(Element) fantom1.getType();
	 }
	 public Bord(MyPacgomme pacgome){
     this.pacgome=pacgome;
     this.type=(Element)pacgome.getType();
		
	 }
	 public Bord(Obstacle obstacle){
	     this.obstacle=obstacle;	
	     this.type=(Element)obstacle.getType();
		 }
	
	 public Bord(Personage_pacman pacman,Personage_fantome fantom1,MyPacgomme pacgome,Obstacle obstacle){
		 this.fantom1=fantom1;
		 this.pacgome=pacgome;
		 this.pacman=pacman;
		 this.obstacle=obstacle;
	 }
	
	 public Personage_pacman getPacman() {
		return pacman;
	}

	public void setPacman(Personage_pacman pacman) {
		this.pacman = pacman;
	}

	public Personage_fantome getFantom1() {
		return fantom1;
	}

	public void setFantom1(Personage_fantome fantom1) {
		this.fantom1 = fantom1;
	}

	public MyPacgomme getMyPacgome() {
		return pacgome;
	}

	public void setPacgome(MyPacgomme pacgome) {
		this.pacgome = pacgome;
	}

	public Obstacle getObstacle() {
		return obstacle;
	}

	public Element getType() {
		return type;
	}

	
}
