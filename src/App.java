import javax.swing.JFrame;

public class App {
	private static final int FRAME_LOCATION_X = 0;
	private static final int FRAME_LOCATION_Y = 0;
	
	public static void main(String[] args) {
		
		
		JFrame frame=new JFrame("Pac man");
		Game game1=new Game();
		PackManview view =new PackManview(game1);
		frame.setLocation(FRAME_LOCATION_X, FRAME_LOCATION_Y);
		frame.add(view);
	    frame.setSize(view.getSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	

		/*//2 red 3 green 4gray 5pink
		//Personage_pacman pacman=new Personage_pacman(5,4);
		Personage_fantome fontome1=new Personage_fantome(2);
		Personage_fantome fontome2=new Personage_fantome(3);
		Personage_fantome fontome3=new Personage_fantome(4);
		Personage_fantome fontome4=new Personage_fantome(5);
		//Bord bord =new Bord(pacman,fontome1,fontome2,fontome3,fontome4);
	    	*/
		
			
			//game1.addPacMan();
		
	    	
	    	//game1.afficheBord();
	    	//System.out.print("hello");
		//view.movePacman(game1.getCell(5,0));
	  	//view.movePacman(game1.getCell(5,0));
	    //game1.afficheBord();
	}
	
}
