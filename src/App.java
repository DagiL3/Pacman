import javax.swing.JFrame;

public class App {
	private static final int FRAME_LOCATION_X = 0;
	private static final int FRAME_LOCATION_Y = 0;
	
	public static void myGame() {
		Game game1=new Game();
		JFrame frame=new JFrame("Pac man");
		PackManview view =new PackManview(game1);
		frame.setLocation(FRAME_LOCATION_X, FRAME_LOCATION_Y);
		frame.add(view);
	
	    frame.setSize(view.getSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		frame.setVisible(true);
		}
	
	public static void main(String[] args) {
		myGame();
		
		
	}
	
}
 