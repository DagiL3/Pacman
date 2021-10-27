import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.Timer;

public class PackManview extends JPanel implements ActionListener {
	
	public final static int WIDTH = 1000;
	public final static int HEIGHT = 700;
	private Game game;
	private int currentSpeed = 3;
	private Timer timer;
	
	public PackManview(Game game){
		super();
		this.game=game;
		setOpaque(true);
		setSize(WIDTH,HEIGHT);
		timer=new Timer(200,this); 
		timer.start();
		
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d=(Graphics2D) g;
		g2d.setBackground(Color.BLUE);
		
			drawRectangle(g2d);
		
	}
	
	private void drawRectangle(Graphics2D g2d )  {
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
					g2d.fillOval(i*100+30, j*65+10, 12, 12);
					
				}
				else if(game.getBorde()[i][j].getType()==Element.PACMAN) {
					g2d.setColor(Color.yellow);
					g2d.fillOval(i*100+30, j*65+10, 40, 40);
					
							//g2d.drawOval(););
				}else {
					g2d.setColor(Color.gray);
					g2d.fill(new Rectangle2D.Double(i*100,j*65,width,hight));
				}
			}
			
		}
	}	  
	
	    public void movePacman(Bord b) {
	    	Bord c = b;
	    		Bord current = b;		  
	    		Direction direction=game.getRandom();
	    		
	    		switch(direction){
	    		case RIGHT:
						c=moveRight(current);
	    	  	current=c;
	    	    //repaint();
	    			break;
	    		case LEFT:
	    			
						c=moveLeft(current);
					
	    			current=c;
	    		 // repaint();
	    			 break;
	    		case DOWN:	    			
						c=moveDown(current);				 
	    			 current=c;
	    				//repaint();
	    			 break;
	    		case UP:					
						c=moveUp(current);
					
	    		 current=c;
	    		//	repaint(); 
	    		 break;
	    		}	    				    
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			/*while(game.getNumberPacgammes()>0) 
        	{
    		  movePacman (game.getCell(5,0));
    		  repaint(); 
    	    }*/
			  movePacman (game.getCell(5,0));		
			 // repaint(); 
		}
					   
		public Bord moveUp(Bord b) {
			
			   Personage_pacman pacman =b.getPacman();
			   int posx=pacman.getPosX();
			   int posy=pacman.getPosY();			   
			   for(int j=posx-1;j>=0;j--){
				   if (game.getNumberPacgammes()<=0)break;
				   if((game.borde[j][posy]).getType()!=Element.OBSTACLE){
					   if(game.borde[j][posy].getType()==Element.PACGOMME) {
						   pacman.mangePacgomme(game.borde[j][posy].getMyPacgome());
						  game.setNumberPacgammes();
					   	}
					   int v=j+1;
					   game.setCellNull(v,posy);
					   game.setCell(j,posy,pacman);
					   pacman.setPosX(j);
					   game.afficheBord();
				   }else break;
				   repaint(); 
			   }
			   return (game.getCell(pacman.getPosX(),pacman.getPosY()));		  
	}
	    
		public Bord moveDown(Bord b){
			
			   Personage_pacman pacman =b.getPacman();
			   int posx=pacman.getPosX();
			   int posy=pacman.getPosY();
			   for(int j=posx+1;j<game.borde.length;j++){
				   if (game.getNumberPacgammes()==0)break;
				   if((game.borde[j][posy]).getType()!=Element.OBSTACLE){
					   if(game.borde[j][posy].getType()==Element.PACGOMME) {
					   pacman.mangePacgomme(game.borde[j][posy].getMyPacgome());
					   game.setNumberPacgammes();
					   }
					   int v=j-1;
					   game.setCellNull(v,posy);
					   game.setCell(j,posy,pacman);
					   pacman.setPosX(j);
					   game.afficheBord();
				   }else
					   break;
				 repaint(); 
			   } 
			   return (game.getCell(pacman.getPosX(),pacman.getPosY()));
		   }
		public Bord moveRight(Bord b) {
			
			   Personage_pacman pacman =b.getPacman();
			   int posx=pacman.getPosX();
			   int posy=pacman.getPosY();
			   
			   for(int i=posy+1;i<game.borde.length;i++){
				   if (game.getNumberPacgammes()==0)break;
				   if((game.borde[posx][i]).getType()!=Element.OBSTACLE){
					   if(game.borde[posx][i].getType()==Element.PACGOMME) {
						   pacman.mangePacgomme(game.borde[posx][i].getMyPacgome());
						   game.setNumberPacgammes();
					   }
					   int v=i-1;
					   game.setCellNull(posx,v);	   
					   game.setCell(posx,i,pacman);
					   pacman.setPosY(i);
					 game.afficheBord();
				   }else
					   break;
				   repaint(); 
			   } return (game.getCell(pacman.getPosX(),pacman.getPosY()));
		   }
	    
		public   Bord moveLeft(Bord b){
		
			   Personage_pacman pacman =b.getPacman();
			   int posx=pacman.getPosX();
			   int posy=pacman.getPosY();
			 
			   for(int i=posy-1;i>=0;i--){
				   if (game.getNumberPacgammes()==0)break;
				   if((game.borde[posx][i]).getType()!=Element.OBSTACLE){
					   if(game.borde[posx][i].getType()==Element.PACGOMME) {
					      pacman.mangePacgomme(game.borde[posx][i].getMyPacgome());
					      game.setNumberPacgammes();
					   }
					   int v=i+1;
					   game.setCellNull(posx,v);
					   game.setCell(posx,i,pacman);
					   pacman.setPosY(i);
					  game.afficheBord();
				   }else 
					   break;
				 repaint(); 
			   }
			   return (game.getCell(pacman.getPosX(),pacman.getPosY()));
		   
	    }
	}



	


	


