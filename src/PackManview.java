import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

import javax.swing.JComponent;

public class PackManview extends JComponent{
	
	public final static int WIDTH = 1000;
	public final static int HEIGHT = 700;
	private Game game;
	//private Bord bord;
	public PackManview(Game game){
		super();
		this.game=game;
		//this.bord=bord;
		setOpaque(true);
		setSize(WIDTH,HEIGHT);
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d=(Graphics2D) g;
		setBackground(Color.BLACK);
		drawRectangle(g2d);

	}
	private void drawRectangle(Graphics2D g2d ) {
		int width=100;
		int hight=70;
		g2d.setColor(Color.BLACK);
		
		for(int i=0;i <game.getBorde().length; i++){
			for(int j=0; j<game.getBorde()[i].length; j++){
				if(game.getBorde()[i][j].getType()==Element.OBSTACLE){
					g2d.setColor(Color.BLACK);
					g2d.fill(new Rectangle2D.Double(i*100,j*65,width,hight));
				}else if(game.getBorde()[i][j].getType()==Element.PACGOMME) {
					g2d.setColor(Color.BLUE);
					g2d.drawOval(i*100+30, j*65+10, 20, 20);
					
				}
			}
		}
		
		
		
	}

	public void drowLines(){
		
	}

}
