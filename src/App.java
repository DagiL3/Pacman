import javax.swing.JFrame;

public class App {
	private static final int FRAME_LOCATION_X = 100;
	private static final int FRAME_LOCATION_Y = 100;
	
	public static void main(String[] args){
		
		
		JFrame frame=new JFrame("Pac man");
		PackManview view =new PackManview();
		frame.setLocation(FRAME_LOCATION_X, FRAME_LOCATION_Y);
		frame.add(view);
		frame.setSize(view.getSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//2 red 3 green 4gray 5pink
		Personage_pacman pacman=new Personage_pacman();
		Personage_fantome fontome1=new Personage_fantome(2);
		Personage_fantome fontome2=new Personage_fantome(3);
		Personage_fantome fontome3=new Personage_fantome(4);
		Personage_fantome fontome4=new Personage_fantome(5);
	    	Game game1=new Game(pacman,fontome1,fontome2,fontome3,fontome4);
	    	game1.addbloc();
	    	game1.addPacgamme();
	    	game1.afficheBord();
	}
	
}
