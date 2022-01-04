import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PackManview extends JPanel implements ActionListener {
	
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 700;
	private Game game;
	private int currentSpeed = 3;
	private Timer timer;
	private long sleep=40;
	//private Personage_pacman pacman=getCell();
	//Personage_fantome fantome;
	Bord bord;
	
	public PackManview(Game game){
		super();
		this.game=game;	
		setOpaque(true);
		setSize(WIDTH,HEIGHT);
		// pacman=(game.getCell(5,0)).getPacman();
		timer=new Timer(300,this); 
		timer.start();		
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d=(Graphics2D) g;
		g2d.setBackground(Color.BLUE);		
		drawRectangle(g2d);		
		//movePacman (game.getCell(5,0));
		//moveFantome(game.getCell(0, 9));
		if(game.getNumberPacgammes()<=0||game.getPacman().getVie()<=0){
			// game.afficheStatus(); 
			return;
		}else {
			movement();
		}
	}
				
	public void movement(){
		if(game.getNumberPacgammes()<=0||game.getPacman().getVie()<=0){
			return;
		}
		//game.afficheStatus();
		//System.out.print("game Over");
		game.moveFantome();
		game.movePacman();
	}
	
	public void MovementNull()
	{
		game.afficheStatus();
	}	
	
	private void drawRectangle(Graphics2D g2d )  { 
		int width=100;
		int hight=70;
		g2d.setColor(Color.BLACK);
		g2d.setColor(Color.PINK);
		g2d.setFont(new Font("Ink Free",Font.BOLD,50));
		g2d.drawString("vie: "+ game.getPacman().getVie(), 1020, 60);	
		for(int i=0;i <game.getBorde().length; i++){
			for(int j=0; j<game.getBorde()[i].length; j++){
				if(game.getBorde()[i][j].getType()==Element.OBSTACLE){
					g2d.setColor(Color.BLACK);
					g2d.fill(new Rectangle2D.Double(i*100,j*65,width,hight));
					
				}else if(game.getBorde()[i][j].getType()==Element.PACGOMME) {
					
					if(game.getBorde()[i][j].getMyPacgome().getPacgome()==Pacgomme.BLEU) {
						g2d.setColor(Color.BLUE);
						/*x position is i*100+30 : y position is j*65+10
						 * for i =0  j varies(0-9) so we go horizontal 
						 * */
						g2d.fillOval(i*100+30, j*65+10, 12, 12);
					}else if(game.getBorde()[i][j].getMyPacgome().getPacgome()==Pacgomme.ORANGE){
						g2d.setColor(Color.ORANGE);
						g2d.fillOval(i*100+30, j*65+10, 17, 14);
					}
					else if(game.getBorde()[i][j].getMyPacgome().getPacgome()==Pacgomme.VERT){
						g2d.setColor(Color.GREEN);
						g2d.fillOval(i*100+30, j*65+10, 17, 14);
					}else if(game.getBorde()[i][j].getMyPacgome().getPacgome()==Pacgomme.VIOLET){
						g2d.setColor(Color.PINK);
						g2d.fillOval(i*100+30, j*65+10, 17, 14);
					}
					
				}
				else if(game.getBorde()[i][j].getType()==Element.PACMAN) {
					int color=	game.getBorde()[i][j].getPacman().getColor(); 
					if(color==1) {
					g2d.setColor(Color.yellow);
					g2d.fillOval(i*100+30, j*65+10, 40, 40);
					
					}else if(color==7) {
						g2d.setColor(new Color(239, 230, 112));//jaune pale
						g2d.fillOval(i*100+30, j*65+10, 35, 35);
					}	//g2d.drawOval(););
					else {
						g2d.setColor(Color.ORANGE);
						g2d.fillOval(i*100+30, j*65+10, 40, 40);
					}		
				}			
				else if(game.getBorde()[i][j].getType()==Element.FANTOME) {
					if(game.getBorde()[i][j].getFantom1().getColor()==1) {
						g2d.setColor(Color.RED);
						g2d.fillOval(i*100+30, j*65+10, 50, 50);
					}else if(game.getBorde()[i][j].getFantom1().getColor()==2){
						g2d.setColor(Color.cyan);
						g2d.fillOval(i*100+30, j*65+10, 50, 50);
					}else if(game.getBorde()[i][j].getFantom1().getColor()==3){
						g2d.setColor(Color.DARK_GRAY);
						g2d.fillOval(i*100+30, j*65+10, 50, 50);
					}else if(game.getBorde()[i][j].getFantom1().getColor()==4){
						g2d.setColor(Color.GREEN);
						g2d.fillOval(i*100+30, j*65+10, 50, 50);
					}else if(game.getBorde()[i][j].getFantom1().getColor()==11){
						g2d.setColor(Color.BLUE);
						g2d.fillOval(i*100+30, j*65+10, 50, 50);
					}
					//g2d.drawOval(););
				}else if(game.getBorde()[i][j].getType()==Element.EMPTY)  {
					g2d.setColor(Color.white);
					g2d.fill(new Rectangle2D.Double(i*100,j*65,width,hight));
				}
			}
		}
		
	}	  	    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(game.getNumberPacgammes()<=0||game.getPacman().getVie()==0){
			repaint();
			game.afficheStatus(); 
			timer.stop();
		}else {
			repaint();
		}
	}	
}




	


	


