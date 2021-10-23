
public class Personage_pacman {

	private  int vie;
	private  int color;
	private  int point;
	
	public Personage_pacman(){
		this.vie=3;
		this.color=1;//yellow
		this.point=0;
	}
	
	public void addVie(){
		this.vie++;
	}
	public void subVie(){
		this.vie--;
	}
	public void mangePacgomme(Pacgomme g){
		addPoints(g);
		//no_pacgomme --;
	}
	
	 private void addPoints(Pacgomme p){
		 switch(p.type){
		 
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
}
	

